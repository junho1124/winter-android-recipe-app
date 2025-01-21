package com.surivalcoding.composerecipeapp.repository

import com.surivalcoding.composerecipeapp.core.model.Result
import com.surivalcoding.composerecipeapp.data_source.local.BookmarkDataSource
import com.surivalcoding.composerecipeapp.data_source.remote.RecipeDataSource
import com.surivalcoding.composerecipeapp.mapper.toModel
import com.surivalcoding.composerecipeapp.model.Recipe

class RecipeRepositoryImpl(
    private val recipeDataSource: RecipeDataSource,
    private val bookmarkDataSource: BookmarkDataSource,
    ) : RecipeRepository {
    override fun getSavedRecipes(): Result<List<Recipe>, Exception> {
        try {
            val savedRecipeIds = bookmarkDataSource.getSavedRecipes()
            val savedRecipes = recipeDataSource.getSavedRecipes()
            return Result.Success(savedRecipes.filter { savedRecipeIds.contains(it.id) }.map { it.toModel() })

        } catch (e: Exception) {
            e.printStackTrace()
            return Result.Error(e)
        }
    }

    override fun bookmarkRecipe(recipeId: Int): Result<Boolean, Exception> {
        try {
            if(bookmarkDataSource.isRecipeSaved(recipeId)) {
                bookmarkDataSource.removeRecipe(recipeId)
                return Result.Success(false)
            } else {
                bookmarkDataSource.saveRecipe(recipeId)
                return Result.Success(true)
            }
        } catch (e: Exception) {
            return Result.Error(e)
        }
    }
}