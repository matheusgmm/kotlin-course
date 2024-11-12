package br.com.muccio.controller.request

import jakarta.validation.constraints.NotEmpty

data class PutCustomerRequest (

    @field:NotEmpty(message = "Name cannot be empty.")
    var name: String,

    var email: String
)