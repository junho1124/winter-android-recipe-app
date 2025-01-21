package com.surivalcoding.composerecipeapp.presentation

import kotlinx.serialization.Serializable

interface Route


@Serializable
open class AuthGraph : Route

sealed class AuthRoute : AuthGraph() {
    @Serializable
    object Login : AuthRoute()

    @Serializable
    object Register : AuthRoute()
}