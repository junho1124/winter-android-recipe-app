package com.surivalcoding.composerecipeapp.domain.repository

import com.surivalcoding.composerecipeapp.core.model.Result
import com.surivalcoding.composerecipeapp.domain.model.Recipe

interface RecipeRepository {
    fun getRecipes(): Result<List<Recipe>, Exception>
    fun getSavedRecipes(): Result<List<Recipe>, Exception>
    fun searchRecipes(query: String): Result<List<Recipe>, Exception>
    fun bookmarkRecipe(recipeId: Int): Result<Boolean, Exception>
}