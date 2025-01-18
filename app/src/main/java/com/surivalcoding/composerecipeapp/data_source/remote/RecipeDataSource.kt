package com.surivalcoding.composerecipeapp.data_source.remote

import com.surivalcoding.composerecipeapp.dto.RecipeDto

interface RecipeDataSource {
    fun getRecipes(): List<RecipeDto>
    fun getSavedRecipes(): List<RecipeDto>
}