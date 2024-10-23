package com.example.repository

import com.example.data.Cat

class CatRepository (
    val remoteDataSource: CataasRemoteDataSource,
    val localDataSource: CataasLocalDataSource
){

    fun fetchData(): List<Cat>{
        remoteDataSource.getList
        return listOf()
    }
}