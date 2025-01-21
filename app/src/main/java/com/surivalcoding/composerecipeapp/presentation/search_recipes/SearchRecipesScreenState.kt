package com.surivalcoding.composerecipeapp.presentation.search_recipes

import com.surivalcoding.composerecipeapp.core.ViewState
import com.surivalcoding.composerecipeapp.model.Recipe

data class SearchRecipesScreenState(
    val query: String = "",
    val recipes: List<Recipe> = emptyList(),
    val bookmarkRecipeIds: Set<Int> = emptySet(),
    val filteredRecipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = true,
) : ViewState() {
    companion object {
        fun initialState() = SearchRecipesScreenState()
    }
}