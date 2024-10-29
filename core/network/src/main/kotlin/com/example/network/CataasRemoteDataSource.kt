package com.example.network

class CataasRemoteDataSource(
    val retrofitService: RetrofitBuilder2
) {
    suspend fun getCatResponse(): List<CatResponseDto> {
        return retrofitService.apiService.getInfoCat()
    }

    suspend fun getList(tag: String): List<CatDto> {
        val response = retrofitService.apiService.fetchCats(tag)
        if (response.isSuccessful){
            return response.body()!!
        }
        return listOf()
    }
}