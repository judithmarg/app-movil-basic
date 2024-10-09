package com.example.data

import android.content.Context

class BookRepository(val context: Context) {
    val bookDao = AppRoomDatabase.getDatabase(context).bookDao()

    suspend fun insert(book: Book) {
        bookDao.insert(book)
    }

    fun getListBooks(): List<Book> {
        return bookDao.getList()
    }
}