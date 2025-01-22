package com.surivalcoding.composerecipeapp.data.data_source.local

interface BookmarkDataSource {
    fun isRecipeSaved(recipeId: Int): Boolean
    fun getSavedRecipes(): List<Int>
    fun saveRecipe(recipeId: Int)
    fun removeRecipe(recipeId: Int)
}