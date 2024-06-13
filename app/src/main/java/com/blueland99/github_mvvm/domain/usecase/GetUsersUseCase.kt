package com.blueland99.github_mvvm.domain.usecase

import com.blueland99.github_mvvm.domain.repository.UserRepository
import com.blueland99.github_mvvm.domain.model.User
import com.blueland99.github_mvvm.domain.model.UserList
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend fun execute(
        query: String,
        page: Int? = 1,
        limit: Int? = 30,
    ): UserList {
        return userRepository.getUsers(query, page, limit)
    }
}
