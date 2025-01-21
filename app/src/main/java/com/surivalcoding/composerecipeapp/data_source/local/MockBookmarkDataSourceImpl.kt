package com.surivalcoding.composerecipeapp.data_source.local

class MockBookmarkDataSourceImpl : BookmarkDataSource {
    private val savedRecipes = mutableListOf<Int>(1, 2, 3)
    override fun isRecipeSaved(recipeId: Int): Boolean {
        return savedRecipes.contains(recipeId)
    }

    override fun getSavedRecipes(): List<Int> {
        return savedRecipes
    }

    override fun saveRecipe(recipeId: Int) {
        savedRecipes.add(recipeId)
    }

    override fun removeRecipe(recipeId: Int) {
        savedRecipes.remove(recipeId)
    }
}