package com.blueland99.github_mvvm.domain.model

data class UserList(val items: List<User>)

data class User(
    val id: Long,
    val login: String,
    val avatarURL: String?
)