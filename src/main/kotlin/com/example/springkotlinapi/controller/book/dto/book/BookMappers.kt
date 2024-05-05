package com.example.springkotlinapi.controller.book.dto.book

import com.example.springkotlinapi.entity.book.Book

fun BookRequest.toBook(): Book {
    return Book(
        title = this.title,
        status = this.status
    )
}

fun Book.toBookResponse(): BookResponse{
    return BookResponse(
        id = this.id ?: 0,
        title = this.title,
        status = this.status
    )
}