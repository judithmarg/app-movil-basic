package com.example.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
@JsonClass(generateAdapter = true)
data class CatDto(
    @Json(name = "createdAt")
    val createAt: String
) {
}