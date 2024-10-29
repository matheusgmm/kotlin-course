package br.com.muccio.controller.request

import br.com.muccio.model.CustomerModel

data class PostCustomerRequest (
    var name: String,

    var email: String
)