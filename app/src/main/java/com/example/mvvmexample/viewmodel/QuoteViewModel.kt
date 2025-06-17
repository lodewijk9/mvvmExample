package com.example.mvvmexample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.model.QuoteModel
import com.example.mvvmexample.model.QuoteProvider

class QuoteViewModel: ViewModel() {

    // life data allows to subscribe a data model
    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote(){
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote)
    }

}