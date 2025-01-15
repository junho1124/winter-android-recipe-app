package com.surivalcoding.composerecipeapp.model

import java.time.LocalDateTime

data class Recipe(
    val id: String,
    val name: String,
    val authorName: String,
    val timeTaken: Int,
    val rate: Float,
    val circledThumbnailImageUrl: String,
    val thumbnailImageUrl: String,
    val isUserSaved: Boolean,
    val isUserReviewed: Boolean,
    val isUserRated: Boolean,
    val isNew: Boolean,
    val categories: List<String>,
    val createdAt: LocalDateTime
) {
    companion object {
        fun default() = Recipe(
            id = "dsa",
            name = "Traditional Italian Pizza",
            authorName = "John Doe",
            timeTaken = 30,
            rate = 4.5f,
            circledThumbnailImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQ9KxAcXh_FBy7LoQ8pN-XEeBfN3u8CpLDLA&s",
            thumbnailImageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQ9KxAcXh_FBy7LoQ8pN-XEeBfN3u8CpLDLA&s",
            isUserSaved = false,
            isUserReviewed = false,
            isUserRated = false,
            isNew = true,
            categories = arrayOf("Pizza", "Italian").toList(),
            createdAt = LocalDateTime.MAX
        )
    }
}