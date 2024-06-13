package com.blueland99.github_mvvm.domain.repository

import com.blueland99.github_mvvm.domain.model.UserList

interface UserRepository {
    suspend fun getUsers(
        query: String,
        page: Int?,
        limit: Int?,
    ): UserList
}
