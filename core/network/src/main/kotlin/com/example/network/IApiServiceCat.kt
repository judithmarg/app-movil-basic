package com.example.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IApiServiceCat {
    @GET("api/cats?limit=10&skip=0")
    suspend fun getInfoCat(): List<CatResponseDto>

    @GET("api/cats")
    suspend fun fetchCats(
        @Query("tag") tag: String,
    ): Response<List<CatDto>>

}