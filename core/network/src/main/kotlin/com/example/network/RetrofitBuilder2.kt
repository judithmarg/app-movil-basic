package com.example.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder2 {
    private const val BASE_URL = "https://cataas.com/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val apiService: IApiServiceCat = getRetrofit().create(IApiServiceCat::class.java)
}