package com.example.network

class GithubRemoteDataSource(
    val retrofitService: RetrofitBuilder
) {
    suspend fun getAvatarInfo(githubLogin: String): AvatarResponseDto {
        return retrofitService.apiService.getInfoAvatar(githubLogin)
    }

    //suspend fun getNameInfo
}