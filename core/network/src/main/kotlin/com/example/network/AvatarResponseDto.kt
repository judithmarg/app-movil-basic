package com.example.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class AvatarResponseDto (
    @Json(name = "login")
    val login: String,
    @Json(name = "avatar_url")
    val url: String,
    @Json(name = "name")
    val name: String?,
    @Json(name = "company")
    val company: String?,
    @Json(name = "bio")
    val bio: String?
){
}