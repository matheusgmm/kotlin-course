package br.com.muccio.controller.response

import java.math.BigDecimal
import java.time.LocalDateTime

class PurchaseResponse (
    var id: Int? = null,

    var customer: CustomerResponse,

    var books: MutableList<BookResponse>,

    var nfe: String?,

    var price: BigDecimal,

    var createdAt: LocalDateTime
)

