package com.surivalcoding.composerecipeapp.model

import com.surivalcoding.composerecipeapp.model.Author


data class RecipeDetail(
    val author: Author,
    val serve: Int,
    val ingredients: List<Ingredient>,
    val steps: List<Step>,
)