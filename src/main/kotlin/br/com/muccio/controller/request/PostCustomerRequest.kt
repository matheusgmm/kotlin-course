package br.com.muccio.controller.request

import br.com.muccio.model.CustomerModel

data class PostCustomerRequest (
    var nome: String,

    var email: String
) {
    fun toCustomerModel(): CustomerModel {
        return CustomerModel(nome = this.nome, email = this.email)
    }
}