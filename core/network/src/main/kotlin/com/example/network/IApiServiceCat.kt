package com.example.network

import retrofit2.http.GET
import retrofit2.http.Path

interface IApiServiceCat {
    @GET("api/cats?limit=10&skip=0")
    suspend fun getInfoCat(): List<CatResponseDto>

}