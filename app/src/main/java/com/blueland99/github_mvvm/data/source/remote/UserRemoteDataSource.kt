package com.blueland99.github_mvvm.data.source.remote

import com.blueland99.github_mvvm.data.model.UserListEntity
import retrofit2.Response
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val apiService: GitHubApiService) {
    suspend fun getUsers(
        query: String,
        page: Int?,
        limit: Int?,
    ): Response<UserListEntity> {
        return apiService.getUsers(query, page, limit)
    }
}
