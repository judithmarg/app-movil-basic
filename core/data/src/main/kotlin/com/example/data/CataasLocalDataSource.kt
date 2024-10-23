package com.example.data

class CataasLocalDataSource (
    val catRepository: CatRepository
) {
    suspend fun getCatResponse(): List<Cat> {
        return catRepository.getListCats()
    }
}