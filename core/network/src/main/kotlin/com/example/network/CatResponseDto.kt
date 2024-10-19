package com.example.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CatResponseDto (
    @Json(name = "_id")
    val _id: String,
    @Json(name = "mimetype")
    val mimetype: String,
    @Json(name = "size")
    val size: Long?,
    @Json(name = "tags")
    val tags: List<String>?){
}