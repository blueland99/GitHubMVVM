package com.blueland99.github_mvvm.data.model

data class UserListEntity(
    val totalCount: Long,
    val incompleteResults: Boolean,
    val items: List<UserEntity>
)

data class UserEntity(
    val login: String,
    val id: Long,
    val nodeID: String,
    val avatarURL: String,
    val gravatarID: String,
    val url: String,
    val htmlURL: String,
    val followersURL: String,
    val followingURL: String,
    val gistsURL: String,
    val starredURL: String,
    val subscriptionsURL: String,
    val organizationsURL: String,
    val reposURL: String,
    val eventsURL: String,
    val receivedEventsURL: String,
    val type: String,
    val siteAdmin: Boolean,
    val score: Long
)