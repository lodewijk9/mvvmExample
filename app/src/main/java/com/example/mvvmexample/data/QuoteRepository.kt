package com.example.mvvmexample.data

import com.example.mvvmexample.data.db.dao.QuoteDao
import com.example.mvvmexample.data.db.entities.QuoteEntity
import com.example.mvvmexample.data.model.QuoteModel
import com.example.mvvmexample.data.network.QuoteService
import com.example.mvvmexample.domain.model.Quote
import com.example.mvvmexample.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao,
) {
    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDataBase(): List<Quote> {
        val response:List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes:List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}