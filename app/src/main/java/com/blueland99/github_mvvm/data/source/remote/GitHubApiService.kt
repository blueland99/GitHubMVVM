package com.blueland99.github_mvvm.data.source.remote

import com.blueland99.github_mvvm.data.model.UserListEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApiService {
    @GET("search/users")
    suspend fun getUsers(
        @Query("q") query: String,
        @Query("page") page: Int?,
        @Query("per_page") limit: Int?,
    ): UserListEntity
}
