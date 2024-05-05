package com.example.springkotlinapi.controller.book

import com.example.springkotlinapi.controller.book.dto.book.BookRequest
import com.example.springkotlinapi.controller.book.dto.book.BookResponse
import com.example.springkotlinapi.controller.book.dto.book.toBook
import com.example.springkotlinapi.controller.book.dto.book.toBookResponse
import com.example.springkotlinapi.entity.book.Book
import com.example.springkotlinapi.service.book.BookService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/book")
class BookController(
    private val bookService: BookService
) {

    @PostMapping("/new")
    suspend fun save(@RequestBody book: BookRequest): BookResponse {
        return bookService.save(book.toBook()).toBookResponse()
    }

    @GetMapping("/all")
    suspend fun findAll(): List<BookResponse> {
        return bookService.findAll().map { it.toBookResponse() }
    }

    @GetMapping("/id/{id}")
    suspend fun findById(@PathVariable id: Long): BookResponse{
        return bookService.findById(id).toBookResponse()
    }

    @GetMapping("/title/{title}")
    suspend fun findByTitle(@PathVariable title: String): List<BookResponse>{
        return bookService.findByTitle(title).map { it.toBookResponse() }
    }
}