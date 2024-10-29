package com.example.repository

import com.example.model.Cat

class CataasRepository (
//    val remoteDataSource: CataasRemoteDataSource,
//    val localDataSource: CataasLocalDataSource
){

    suspend fun getList(): List<Cat>{
        return listOf(
            Cat("a","b", listOf("aa")),
            Cat("a","b", listOf("aa")),
            Cat("a","b", listOf("aa"))
        )
    }
}