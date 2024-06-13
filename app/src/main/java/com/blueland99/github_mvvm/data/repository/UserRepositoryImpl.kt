package com.blueland99.github_mvvm.data.repository

import com.blueland99.github_mvvm.data.model.UserEntity
import com.blueland99.github_mvvm.data.model.UserListEntity
import com.blueland99.github_mvvm.data.source.remote.UserRemoteDataSource
import com.blueland99.github_mvvm.domain.model.User
import com.blueland99.github_mvvm.domain.model.UserList
import com.blueland99.github_mvvm.domain.repository.UserRepository

class UserRepositoryImpl(
    private val remoteDataSource: UserRemoteDataSource
) : UserRepository {
    override suspend fun getUsers(
        query: String,
        page: Int?,
        limit: Int?,
    ): UserList {
        return remoteDataSource.getUsers(query, page, limit).toDomainModel()
    }

    private fun UserListEntity.toDomainModel(): UserList {
        return UserList(
            items = items.map { it.toDomainModel() }
        )
    }

    private fun UserEntity.toDomainModel(): User {
        return User(
            id = id,
            login = login,
        )
    }
}
