package com.example.data

import android.content.Context

class UserRepository(val context: Context) {
    val userDao = AppRoomDatabase.getDatabase(context).userDao()

    suspend fun insert(user: User){
        userDao.insert(user)
    }

    fun getListUser(): List<User> {
        return userDao.getAll()
    }
}