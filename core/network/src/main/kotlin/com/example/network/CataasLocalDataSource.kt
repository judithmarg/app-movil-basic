package com.example.network

import com.example.data.Cat
import com.example.data.CatRepository

class CataasLocalDataSource (
    val catRepository: CatRepository
) {
    suspend fun getCatResponse(): List<Cat> {
        return catRepository.getListCats()
    }
}