package com.surivalcoding.composerecipeapp.repository

import com.surivalcoding.composerecipeapp.data_source.local.BookmarkDataSource
import com.surivalcoding.composerecipeapp.data_source.remote.RecipeDataSource
import com.surivalcoding.composerecipeapp.mapper.toModel
import com.surivalcoding.composerecipeapp.model.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeRepositoryImpl(
    private val recipeDataSource: RecipeDataSource,
    private val bookmarkDataSource: BookmarkDataSource,
    ) : RecipeRepository {
    override fun getSavedRecipes(): List<Recipe>  {
        val savedRecipeIds = bookmarkDataSource.getSavedRecipes()
        val savedRecipes = recipeDataSource.getSavedRecipes()
        return savedRecipes.filter { savedRecipeIds.contains(it.id) }.map { it.toModel() }
    }

    override fun bookmarkRecipe(recipeId: Int) {
        bookmarkDataSource.saveRecipe(recipeId)
    }
}