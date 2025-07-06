package com.example.mvvmexample.domain

import com.example.mvvmexample.data.QuoteRepository
import com.example.mvvmexample.data.db.entities.toDataBase
import com.example.mvvmexample.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke():List<Quote>{
        val quotes = repository.getAllQuotesFromApi()
        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDataBase() })
            quotes
        }else{
            repository.getAllQuotesFromDataBase()
        }
    }
}