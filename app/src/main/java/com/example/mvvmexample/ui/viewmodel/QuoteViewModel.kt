package com.example.mvvmexample.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmexample.data.model.QuoteModel
import com.example.mvvmexample.domain.GetQuotesUseCase
import com.example.mvvmexample.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {

    // life data allows to subscribe a data model
    val quoteModel = MutableLiveData<QuoteModel>()

    val getQuotesUseCase = GetQuotesUseCase()

    val getRandomQuoteUseCase = GetRandomQuoteUseCase()

    val isLoading = MutableLiveData<Boolean>()

    fun randomQuote(){
        isLoading.postValue(true)
        val quote:QuoteModel? = getRandomQuoteUseCase()
        if(quote!=null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            delay(2000)
            val result = getQuotesUseCase()
            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
            println("result----------> $result")
        }
    }

}