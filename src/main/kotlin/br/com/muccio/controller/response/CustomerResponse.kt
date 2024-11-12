package br.com.muccio.controller.response

import br.com.muccio.enums.CustomerStatus

data class CustomerResponse (

    var id: Int? = null,

    var name: String,

    var email: String,

    var status: CustomerStatus
)