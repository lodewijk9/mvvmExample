package com.example.mvvmexample.domain

import com.example.mvvmexample.data.QuoteRepository
import com.example.mvvmexample.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetRandomQuoteUseCaseTest {

    @RelaxedMockK
    private lateinit var  quoteRepository: QuoteRepository
    private lateinit var  getRandomQuoteUseCase: GetRandomQuoteUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getRandomQuoteUseCase = GetRandomQuoteUseCase(quoteRepository)
    }

    @Test
    fun `when get all quotes from database return non nullable response`() = runBlocking {

        val myList = listOf(Quote("hey this is a test","lodewijk"))

        //given
        coEvery { quoteRepository.getAllQuotesFromDataBase() } returns myList
        //when
        val response = getRandomQuoteUseCase()
        // then
        assert(response == myList.first())

    }

    @Test
    fun `when database is empty returns null`() = runBlocking {

        //given
        coEvery { quoteRepository.getAllQuotesFromDataBase() } returns emptyList()
        //when
        val response = getRandomQuoteUseCase()
        //then
        assert(response == null)

    }

}