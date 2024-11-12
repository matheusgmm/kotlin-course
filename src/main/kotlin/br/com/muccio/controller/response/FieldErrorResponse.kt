package br.com.muccio.controller.response

data class FieldErrorResponse(
    var message: String,
    var field: String
)