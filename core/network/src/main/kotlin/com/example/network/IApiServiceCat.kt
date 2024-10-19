package com.example.network

import retrofit2.http.GET
import retrofit2.http.Path

interface IApiServiceCat {
    @GET("api/cats")
    suspend fun getInfoCat(): List<CatResponseDto>

}