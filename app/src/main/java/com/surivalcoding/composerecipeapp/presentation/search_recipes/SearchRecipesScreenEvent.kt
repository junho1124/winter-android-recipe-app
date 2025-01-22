package com.surivalcoding.composerecipeapp.presentation.search_recipes

import com.surivalcoding.composerecipeapp.core.presentation.ViewEventable

sealed class SearchRecipesScreenEvent: ViewEventable {
    object InitSearchRecipes : SearchRecipesScreenEvent()
    data class SearchRecipes(val query: String) : SearchRecipesScreenEvent()
    data class NavigateToRecipeDetail(val recipeId: Int) : SearchRecipesScreenEvent()
    data class BookmarkRecipe(val recipeId: Int) : SearchRecipesScreenEvent()
}