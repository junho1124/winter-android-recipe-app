package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.core.model.Result
import com.surivalcoding.composerecipeapp.data.data_source.local.BookmarkDataSource
import com.surivalcoding.composerecipeapp.data.data_source.remote.RecipeDataSource
import com.surivalcoding.composerecipeapp.mapper.toModel
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository

class RecipeRepositoryImpl(
    private val recipeDataSource: RecipeDataSource,
    private val bookmarkDataSource: BookmarkDataSource,
    ) : RecipeRepository {
    override fun getRecipes(): Result<List<Recipe>, Exception> {
        try {
            val recipes = recipeDataSource.getRecipes()
            return Result.Success(recipes.map { it.toModel() })
        } catch (e: Exception) {
            return Result.Error(e)
        }
    }

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

    override fun searchRecipes(query: String): Result<List<Recipe>, Exception> {
        try {
            val recipes = recipeDataSource.getRecipes().filter { it.name?.contains(query, ignoreCase = true) ?: false }
            return Result.Success(recipes.map { it.toModel() })
        } catch (e: Exception) {
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