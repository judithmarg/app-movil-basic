package com.example.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Book::class, User::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun bookDao(): IBookDao

    abstract fun userDao(): IUserDao

    companion object {
        @Volatile
        private var Instance:AppRoomDatabase? = null

        fun getDatabase(context: Context): AppRoomDatabase {
            //if the instance is not null, return it, otherwise create a new database instance
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context,
                    AppRoomDatabase::class.java, "item_database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}