package br.com.muccio.extension

import br.com.muccio.controller.request.PostBookRequest
import br.com.muccio.controller.request.PostCustomerRequest
import br.com.muccio.controller.request.PutBookRequest
import br.com.muccio.controller.request.PutCustomerRequest
import br.com.muccio.controller.response.BookResponse
import br.com.muccio.controller.response.CustomerResponse
import br.com.muccio.controller.response.PurchaseResponse
import br.com.muccio.enums.BookStatus
import br.com.muccio.enums.CustomerStatus
import br.com.muccio.model.BookModel
import br.com.muccio.model.CustomerModel
import br.com.muccio.model.PurchaseModel

fun PostCustomerRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(
        name = this.name,
        email = this.email,
        status = CustomerStatus.ACTIVE
    )
}

fun PutCustomerRequest.toCustomerModel(previousValue: CustomerModel): CustomerModel {
    return CustomerModel(
        id = previousValue.id,
        name = this.name,
        email = this.email,
        status = previousValue.status
    )
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
        name = this.name ?: previousValue.name,
        price = this.price ?: previousValue.price,
        status = previousValue.status,
        customer = previousValue.customer
    )
}

fun CustomerModel.toResponse(): CustomerResponse {
    return CustomerResponse(
        id = this.id,
        name = this.name,
        email = this.email,
        status = this.status
    )
}

fun BookModel.toResponse(): BookResponse {
    return BookResponse(
        id = this.id,
        name = this.name,
        status = this.status,
        price = this.price,
        customer = this.customer
    )
}


fun PurchaseModel.toResponse(): PurchaseResponse {
    return PurchaseResponse(
        id = this.id,
        customer = this.customer.toResponse(),
        books = this.books.map { BookResponse(it.id!!, it.name, it.price) }.toMutableList(),
        nfe = this.nfe,
        price = this.price,
        createdAt = this.createdAt
    )
}


