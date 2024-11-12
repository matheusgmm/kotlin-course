package br.com.muccio.event.listener

import br.com.muccio.event.PurchaseEvent
import br.com.muccio.service.BookService
import br.com.muccio.service.PurchaseService
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.UUID


@Component
class UpdateSoldBookListener(
    private val bookService: BookService
) {

    @Async
    @EventListener
    fun listen(purchaseEvent: PurchaseEvent) {
        println("Updating books status")
        bookService.purchase(purchaseEvent.purchaseModel.books)
    }
}