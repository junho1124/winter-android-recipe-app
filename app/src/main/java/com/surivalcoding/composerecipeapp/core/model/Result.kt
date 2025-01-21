package com.surivalcoding.composerecipeapp.core.model

sealed class Result<out D, out E: Exception> {
    data class Success<D>(val data: D) : Result<D, Nothing>()
    data class Error<E: Exception>(val error: E) : Result<Nothing, E>()
}