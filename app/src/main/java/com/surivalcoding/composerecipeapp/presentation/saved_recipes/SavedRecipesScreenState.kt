package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import com.surivalcoding.composerecipeapp.core.ViewState
import com.surivalcoding.composerecipeapp.model.Recipe

data class SavedRecipesScreenState(
    val recipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = true
): ViewState() {
    companion object {
        fun initialState() = SavedRecipesScreenState()
    }
}