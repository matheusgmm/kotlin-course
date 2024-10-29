package br.com.muccio.controller

import br.com.muccio.controller.request.PostBookRequest
import br.com.muccio.controller.request.PutBookRequest
import br.com.muccio.extension.toBookModel
import br.com.muccio.model.BookModel
import br.com.muccio.service.BookService
import br.com.muccio.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/book")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody request: PostBookRequest) {
        val customer = customerService.getById(request.customerId)
        bookService.create(request.toBookModel(customer))

    }

    @GetMapping
    fun findAll(): List<BookModel> {
        return bookService.findAll();
    }

    @GetMapping("/active")
    fun findActives(): List<BookModel> {
        return bookService.findActives()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): BookModel {
        return bookService.findById(id)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Int): Unit {
        bookService.deleteById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: PutBookRequest) {
        val bookSaved =  bookService.findById(id)
        bookService.update(book.toBookModel(bookSaved))
    }


}