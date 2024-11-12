package br.com.muccio.controller.response

import br.com.muccio.enums.BookStatus
import br.com.muccio.model.CustomerModel
import java.math.BigDecimal

class BookResponse (

    var id: Int? = null,

    var name: String,

    var price: BigDecimal,

    var customer: CustomerModel? = null,

    var status: BookStatus? = null
)