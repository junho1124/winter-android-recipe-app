package com.surivalcoding.composerecipeapp.repository

import com.surivalcoding.composerecipeapp.core.model.Result
import com.surivalcoding.composerecipeapp.model.Recipe

interface RecipeRepository {
    fun getSavedRecipes(): Result<List<Recipe>, Exception>
    fun searchRecipes(query: String): Result<List<Recipe>, Exception>
    fun bookmarkRecipe(recipeId: Int): Result<Boolean, Exception>
}