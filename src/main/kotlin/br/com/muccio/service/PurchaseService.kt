package br.com.muccio.service

import br.com.muccio.controller.response.PurchaseResponse
import br.com.muccio.enums.BookStatus
import br.com.muccio.enums.Errors
import br.com.muccio.event.PurchaseEvent
import br.com.muccio.exceptions.BadRequestException
import br.com.muccio.exceptions.ResourceNotFoundException
import br.com.muccio.extension.toResponse
import br.com.muccio.model.PurchaseModel
import br.com.muccio.repository.PurchaseRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service


@Service
class PurchaseService(
    private val purchaseRepository: PurchaseRepository,
    private val applicationEventPublisher: ApplicationEventPublisher,
    private val bookService: BookService
) {

    fun create(purchaseModel: PurchaseModel) {

        val bookIds = purchaseModel.books.mapNotNull { it.id }.toSet()

        if (bookIds.isEmpty()) {
            throw BadRequestException(
                Errors.ML101.message.format(purchaseModel.books.flatMap { listOf(it.id) }.joinToString(", ")),
                Errors.ML101.code)
        }

        val foundBooks = bookService.findAllByIds(bookIds)

        val foundBookIds = foundBooks.map { it.id }.toSet()
        val missingBookIds = bookIds - foundBookIds


        if (missingBookIds.isNotEmpty()) {
            throw ResourceNotFoundException(
                Errors.ML101.message.format(missingBookIds.joinToString(", ")),
                Errors.ML101.code
            )
        }

        if (foundBooks.any { it.status !== BookStatus.ACTIVE }) {
            val inactiveBooks = foundBooks
                .filter { it.status != BookStatus.ACTIVE }
                .map { it.status }
                .distinct()
            throw BadRequestException(
                Errors.ML102.message.format(inactiveBooks.joinToString(", ")),
                Errors.ML102.code
            )
        }

        purchaseRepository.save(purchaseModel)
        println("Triggering purchase event")
        applicationEventPublisher.publishEvent(PurchaseEvent(this, purchaseModel))
        println("Finishing processing")
    }

    fun update(purchaseModel: PurchaseModel) {
        purchaseRepository.save(purchaseModel)
    }

    fun findPurchaseByCustomerId(id: Int): List<PurchaseResponse> {
        val purchases = purchaseRepository.findByCustomerId(id)
        return purchases.map { it.toResponse() }
    }

}
