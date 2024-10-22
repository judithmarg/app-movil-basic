package com.example.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ICatDao {
    @Query("SELECT * FROM cat_table")
    fun getList():List<Cat>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cat: Cat)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(cats: List<Cat>)
}