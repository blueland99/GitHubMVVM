package com.blueland99.github_mvvm.mapper

import com.blueland99.github_mvvm.data.model.UserEntity
import com.blueland99.github_mvvm.data.model.UserListEntity
import com.blueland99.github_mvvm.domain.model.User
import com.blueland99.github_mvvm.domain.model.UserList

fun UserListEntity.toDomainModel(): UserList {
    return UserList(
        items = this.items.map { it.toDomainModel() },
    )
}

fun UserEntity.toDomainModel(): User {
    return User(
        id,
        login,
        avatarURL
    )
}