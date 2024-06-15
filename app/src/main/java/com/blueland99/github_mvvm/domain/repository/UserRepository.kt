package com.blueland99.github_mvvm.domain.repository

import com.blueland99.github_mvvm.domain.model.UserList
import retrofit2.Response

interface UserRepository {
    suspend fun getUsers(
        query: String,
        page: Int?,
        limit: Int?,
    ): Response<UserList>
}
