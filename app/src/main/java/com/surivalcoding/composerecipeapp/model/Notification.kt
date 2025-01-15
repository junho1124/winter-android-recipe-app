package com.surivalcoding.composerecipeapp.model

import java.time.LocalDateTime

data class Notification(
    val notiId: String,
    val isRead: Boolean,
    val notiTitle: String,
    val notiContent: String,
    val receivedAt: LocalDateTime
)