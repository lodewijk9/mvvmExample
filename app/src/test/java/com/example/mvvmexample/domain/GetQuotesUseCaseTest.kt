package com.example.mvvmexample.domain

import com.example.mvvmexample.data.QuoteRepository
import com.example.mvvmexample.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class GetQuotesUseCaseTest {

    @RelaxedMockK
    // you use lateinit indicating the compiler you will use this var later and won`t be nullable
    private lateinit var quoteRepository: QuoteRepository
    private lateinit var getQuotesUseCase: GetQuotesUseCase

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getQuotesUseCase = GetQuotesUseCase(quoteRepository)
    }

    @Test
    fun `when The Api Does Not Return Anything Then Gets Value From Database`() = runBlocking {
        //given: if this function is called return this but this do not run anything
        coEvery { quoteRepository.getAllQuotesFromApi() } returns emptyList()
        //when: this is what will be returned
        getQuotesUseCase()
        //then: is validated with the expected
        coVerify (exactly = 1){ quoteRepository.getAllQuotesFromDataBase() }

    }

    @Test
    fun `when api returns something then get values from api` () = runBlocking {
        val myList = listOf(Quote("hey this is a test","lodewijk"))
        //given
        coEvery { quoteRepository.getAllQuotesFromApi() } returns  myList
        //when
        val response = getQuotesUseCase()
        //then
        coVerify(exactly = 1) { quoteRepository.clearQuotes() }
        coVerify(exactly = 1) { quoteRepository.insertQuotes(any()) }
        coVerify(exactly = 0) { quoteRepository.getAllQuotesFromDataBase() }
        assert(myList == response)
    }

}