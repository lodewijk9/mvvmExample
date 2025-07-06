package com.example.mvvmexample.domain.model

import com.example.mvvmexample.data.db.entities.QuoteEntity
import com.example.mvvmexample.data.model.QuoteModel

data class Quote(val quote: String, val author: String) // DTO

fun QuoteModel.toDomain() = Quote(quote, author) // Mapper

fun QuoteEntity.toDomain() = Quote(quote, author) // Mapper