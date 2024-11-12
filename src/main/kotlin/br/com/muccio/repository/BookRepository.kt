package br.com.muccio.repository

import br.com.muccio.enums.BookStatus
import br.com.muccio.model.BookModel
import br.com.muccio.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface BookRepository: JpaRepository<BookModel, Int> {

    fun findByNameContaining(name: String): List<BookModel>

    fun findByStatus(status: BookStatus, pageable: Pageable): Page<BookModel>

    fun findByCustomer(customer: CustomerModel): List<BookModel>
}