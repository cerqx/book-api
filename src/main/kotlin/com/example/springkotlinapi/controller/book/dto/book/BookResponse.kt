package com.example.springkotlinapi.controller.book.dto.book

data class BookResponse(
    val id: Long,
    val title: String,
    val status: Boolean
)