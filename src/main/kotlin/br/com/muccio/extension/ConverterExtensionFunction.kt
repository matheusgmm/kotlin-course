package br.com.muccio.extension

import br.com.muccio.controller.request.PostCustomerRequest
import br.com.muccio.controller.request.PutCustomerRequest
import br.com.muccio.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(nome = this.nome, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, nome = this.name, email = this.email)
}

