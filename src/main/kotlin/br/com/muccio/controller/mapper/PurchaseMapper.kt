package br.com.muccio.controller.mapper

import br.com.muccio.controller.request.PostPurchaseRequest
import br.com.muccio.model.PurchaseModel
import br.com.muccio.service.BookService
import br.com.muccio.service.CustomerService
import org.springframework.stereotype.Component


@Component
class PurchaseMapper(
    private val bookService: BookService,
    private val customerService: CustomerService
) {

    fun toModel(request: PostPurchaseRequest): PurchaseModel {
        val customer = customerService.findById(request.customerId)
        val books = bookService.findAllByIds(request.bookIds)

        return PurchaseModel(
            customer = customer,
            books = books.toMutableList(),
            price = books.sumOf { it.price }
        )
    }
}