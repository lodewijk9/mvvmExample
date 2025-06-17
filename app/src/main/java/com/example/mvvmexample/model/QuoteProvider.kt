package com.example.mvvmexample.model

class QuoteProvider {
    companion object {

        fun random(): QuoteModel {
            val position = (0..5).random()
            return quoteModel[position]
        }

        private val quoteModel = listOf<QuoteModel>(
            QuoteModel("hola0", "camilo0"),
            QuoteModel("hola1", "camilo1"),
            QuoteModel("hola2", "camilo2"),
            QuoteModel("hola3", "camilo3"),
            QuoteModel("hola4", "camilo4"),
            QuoteModel("hola5", "camilo5")
        )
    }
}