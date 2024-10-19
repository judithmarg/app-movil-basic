package com.example.data

import android.content.Context

class CatRepository(val context: Context) {
    val catDao = AppRoomDatabase.getDatabase(context).catDao()

    suspend fun insert(cat: Cat) {
        catDao.insert(cat)
    }

    fun getListBooks(): List<Cat> {
        return catDao.getList()
    }
}