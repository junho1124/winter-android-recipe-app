package com.surivalcoding.composerecipeapp.presentation.saved_recipes.action

import com.surivalcoding.composerecipeapp.core.presentation.ViewEventable

sealed class SavedRecipesScreenEvent : ViewEventable {
    object GetSavedRecipes : SavedRecipesScreenEvent()
    data class NavigateToRecipeDetail(val recipeId: Int) :
        SavedRecipesScreenEvent()

    data class BookmarkRecipe(val recipeId: Int) : SavedRecipesScreenEvent()
}