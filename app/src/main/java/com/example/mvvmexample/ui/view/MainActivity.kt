package com.example.mvvmexample.ui.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.mvvmexample.databinding.ActivityMainBinding
import com.example.mvvmexample.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private  lateinit var  binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView((binding.root))

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvText1.text = currentQuote.quote
            binding.tvText2.text = currentQuote.author
        })

        quoteViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        })

        // becomes the activity into a button
        binding.main.setOnClickListener{ quoteViewModel.randomQuote() }

    }
}