package com.example.network

class CataasRemoteDataSource(
    val retrofitService: RetrofitBuilder2
) {
    suspend fun getCatResponse(): List<CatResponseDto> {
        return retrofitService.apiService.getInfoCat()
    }
}