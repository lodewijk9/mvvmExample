package com.example.mvvmexample.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
// you use this annotation in case of, variable local names do not match with remote names in parenthesis remote name
data class QuoteModel (@SerialName("quote") val quote:String,@SerializedName("author") val author:String)