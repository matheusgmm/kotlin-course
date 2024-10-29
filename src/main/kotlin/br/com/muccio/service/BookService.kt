package br.com.muccio.service

import br.com.muccio.enums.BookStatus
import br.com.muccio.model.BookModel
import br.com.muccio.repository.BookRepository
import org.springframework.stereotype.Service


@Service
class BookService(
    val bookRepository: BookRepository
) {


    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun findAll(): List<BookModel> {
        return bookRepository.findAll().toList()
    }

    fun findActives(): List<BookModel> {
        return bookRepository.findByStatus(BookStatus.ACTIVE)
    }

    fun findById(id: Int): BookModel {
        return bookRepository.findById(id).orElseThrow { NoSuchElementException("Book with ID: $id not found!") }
    }

    fun deleteById(id: Int) {
        val book = findById(id)
        book.status = BookStatus.CANCELLED

        update(book)
    }

    fun update(book: BookModel) {
        bookRepository.save(book)
    }

}
