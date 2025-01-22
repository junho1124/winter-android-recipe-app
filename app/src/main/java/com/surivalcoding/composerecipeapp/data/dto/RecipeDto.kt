package com.surivalcoding.composerecipeapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class RecipeWrapperDto(
    val recipes: List<RecipeDto>? = null
)

@Serializable
data class RecipeDto(
    val category: String? = null,
    val id: Int? = null,
    val name: String? = null,
    val image: String? = null,
    val chef: String? = null,
    val time: String? = null,
    val rating: Float? = null,
    val ingredients: List<IngredientWrapperDto>? = null
)

@Serializable
data class IngredientWrapperDto(
    val ingredient: IngredientDto? = null,
    val amount: Int? = null
)

@Serializable
data class IngredientDto(
    val id: Int? = null,
    val name: String? = null,
    val image: String? = null
)
