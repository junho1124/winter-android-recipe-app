package com.surivalcoding.composerecipeapp.data.data_source.remote

import com.surivalcoding.composerecipeapp.data.dto.RecipeDto

interface RecipeDataSource {
    fun getRecipes(): List<RecipeDto>
    fun getSavedRecipes(): List<RecipeDto>
}