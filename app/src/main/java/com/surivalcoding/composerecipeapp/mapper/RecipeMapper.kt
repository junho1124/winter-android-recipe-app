package com.surivalcoding.composerecipeapp.mapper

import com.surivalcoding.composerecipeapp.dto.RecipeDto
import com.surivalcoding.composerecipeapp.model.Recipe

fun RecipeDto.toModel(): Recipe {
    return Recipe(
        category = category ?: "",
        id = id ?: 0,
        name = name ?: "",
        image = image ?: "",
        chef = chef ?: "",
        time = time ?: "",
        rating = rating ?: 0.0f,
        ingredients = ingredients?.map { it.toModel() } ?: emptyList()
    )
}