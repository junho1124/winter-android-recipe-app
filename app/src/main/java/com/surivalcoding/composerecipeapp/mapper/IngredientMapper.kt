package com.surivalcoding.composerecipeapp.mapper

import com.surivalcoding.composerecipeapp.dto.IngredientWrapperDto
import com.surivalcoding.composerecipeapp.model.Ingredient

fun IngredientWrapperDto.toModel(): Ingredient {
    return Ingredient(
        id = ingredient?.id ?: 0,
        name = ingredient?.name ?: "",
        imageUrl = ingredient?.image ?: "",
        amount = amount ?: 0,
    )
}