package com.surivalcoding.composerecipeapp.model

data class Author(
    val id: String,
    val name: String,
    val portraitUrl: String,
    val isUserFollowed: Boolean,
    val address: String
)