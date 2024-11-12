package br.com.muccio.controller.request

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class PostBookRequest (

    @field:NotEmpty(message = "Name cannot be empty.")
    var name: String,

    @field:NotNull(message = "Price cannot be null.")
    var price: BigDecimal,

    @JsonAlias("customer_id")
    var customerId: Int
)