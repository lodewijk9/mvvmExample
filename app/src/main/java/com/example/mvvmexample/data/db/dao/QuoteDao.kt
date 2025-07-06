package com.example.mvvmexample.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmexample.data.db.entities.QuoteEntity

@Dao
interface QuoteDao {
    @Query("SELECT * FROM quote_table ORDER BY author DESC")
    suspend fun getAllQuotes():List<QuoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes: List<QuoteEntity>)

    @Query("DELETE FROM quote_table")
    suspend fun deleteAllQuotes()
}