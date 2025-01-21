package com.surivalcoding.composerecipeapp.core

interface Failrueable {
    fun gotFailure(failure: Exception)
}