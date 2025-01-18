package com.surivalcoding.composerecipeapp.data_source.local

interface BookmarkDataSource {
    fun getSavedRecipes(): List<Int>
    fun saveRecipe(recipeId: Int)
    fun removeRecipe(recipeId: Int)
}