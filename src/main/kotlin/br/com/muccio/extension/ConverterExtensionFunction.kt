package br.com.muccio.extension

import br.com.muccio.controller.request.PostBookRequest
import br.com.muccio.controller.request.PostCustomerRequest
import br.com.muccio.controller.request.PutBookRequest
import br.com.muccio.controller.request.PutCustomerRequest
import br.com.muccio.enums.BookStatus
import br.com.muccio.model.BookModel
import br.com.muccio.model.CustomerModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun PutCustomerRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}

fun PostBookRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ACTIVE,
        customer = customer
    )
}

fun PutBookRequest.toBookModel(previousValue: BookModel): BookModel {
    return BookModel(
        id = previousValue.id,
        name = this.name ?: previousValue.name ,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}


