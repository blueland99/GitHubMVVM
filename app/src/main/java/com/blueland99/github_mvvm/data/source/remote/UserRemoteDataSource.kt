package com.blueland99.github_mvvm.data.source.remote

import com.blueland99.github_mvvm.data.model.UserEntity
import com.blueland99.github_mvvm.data.model.UserListEntity
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(private val apiService: GitHubApiService) {
    suspend fun getUsers(
        query: String,
        page: Int?,
        limit: Int?,
    ): UserListEntity {
        return apiService.getUsers(query, page, limit)
    }
}
