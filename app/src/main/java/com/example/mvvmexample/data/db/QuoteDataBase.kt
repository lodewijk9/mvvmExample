package com.example.mvvmexample.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmexample.data.db.dao.QuoteDao
import com.example.mvvmexample.data.db.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDataBase : RoomDatabase() {
    // for each DAO file you have to create an abstract class
    abstract fun getQuoteDao(): QuoteDao
}