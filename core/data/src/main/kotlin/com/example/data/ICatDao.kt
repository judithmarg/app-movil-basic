package com.example.data

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface ICatDao {
    @Query("SELECT * FROM cats_table")
    fun getList():List<Cat>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cat: Cat)
}