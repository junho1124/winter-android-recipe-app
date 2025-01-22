package com.surivalcoding.composerecipeapp.core.presentation

interface Failrueable {
    fun gotFailure(failure: Exception)
}