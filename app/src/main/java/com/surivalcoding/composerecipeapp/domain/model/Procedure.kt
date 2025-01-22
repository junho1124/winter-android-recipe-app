package com.surivalcoding.composerecipeapp.domain.model

data class Procedure(
    val recipeId: Int,
    val step: Int,
    val content: String,
) {
    companion object {
        fun default() = Procedure(
            recipeId = 1,
            step = 1,
            content = "Default Procedure"
        )
    }
}
