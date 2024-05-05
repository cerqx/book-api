package com.example.springkotlinapi.service.book

import com.example.springkotlinapi.entity.book.Book
import com.example.springkotlinapi.repository.book.BookRepository
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

@Service
class BookService(
    private val bookRepository: BookRepository
) {
    suspend fun save(book: Book): Book {
        return bookRepository.save(book)
    }

    suspend fun findAll(): List<Book> {
        return bookRepository.findAll().toList()
    }

    suspend fun findByTitle(title: String): List<Book>{
        return bookRepository.findByTitle(title)
    }

    suspend fun findById(id: Long): Book{
        return bookRepository.findById(id)
            ?: throw Exception("Not found")
    }

    suspend fun deleteById(id: Long){
        return bookRepository.deleteById(id)
    }
}