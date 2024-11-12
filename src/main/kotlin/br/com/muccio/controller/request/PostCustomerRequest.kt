package br.com.muccio.controller.request

import br.com.muccio.validation.EmailAvailable
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class PostCustomerRequest (

    @field:NotEmpty(message = "Name cannot be empty.")
    var name: String,

    @field:Email(message = "E-mail must be valid.")
    @field:EmailAvailable
    var email: String
)