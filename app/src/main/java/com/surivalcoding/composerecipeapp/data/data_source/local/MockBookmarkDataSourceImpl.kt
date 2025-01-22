package com.surivalcoding.composerecipeapp.data.data_source.local

import org.koin.dsl.module

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