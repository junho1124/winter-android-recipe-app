package com.surivalcoding.composerecipeapp.repository

import com.surivalcoding.composerecipeapp.model.Recipe

interface RecipeRepository {
    fun getSavedRecipes(): List<Recipe>
    fun bookmarkRecipe(recipeId: Int)
}