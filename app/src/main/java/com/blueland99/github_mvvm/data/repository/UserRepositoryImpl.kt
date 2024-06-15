package com.blueland99.github_mvvm.data.repository

import com.blueland99.github_mvvm.data.source.remote.UserRemoteDataSource
import com.blueland99.github_mvvm.domain.model.UserList
import com.blueland99.github_mvvm.domain.repository.UserRepository
import com.blueland99.github_mvvm.mapper.toDomainModel
import retrofit2.Response

class UserRepositoryImpl(
    private val remoteDataSource: UserRemoteDataSource
) : UserRepository {
    override suspend fun getUsers(
        query: String,
        page: Int?,
        limit: Int?,
    ): Response<UserList> {
        val response = remoteDataSource.getUsers(query, page, limit)
        return if (response.isSuccessful) {
            Response.success(response.body()?.toDomainModel())
        } else {
            Response.error(response.code(), response.errorBody()!!)
        }
    }
}
