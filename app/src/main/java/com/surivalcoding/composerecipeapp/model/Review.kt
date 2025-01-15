package com.surivalcoding.composerecipeapp.model

import com.surivalcoding.composerecipeapp.model.Author
import java.time.LocalDateTime

data class Review(
    val id: String,
    val author: Author,
    val content: String,
    val rate: Int,
    val createdAt: LocalDateTime
)