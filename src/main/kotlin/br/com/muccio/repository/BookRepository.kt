package br.com.muccio.repository

import br.com.muccio.enums.BookStatus
import br.com.muccio.model.BookModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface BookRepository: CrudRepository<BookModel, Int> {

    fun findByNameContaining(name: String): List<BookModel>

    fun findByStatus(active: BookStatus): List<BookModel>
}