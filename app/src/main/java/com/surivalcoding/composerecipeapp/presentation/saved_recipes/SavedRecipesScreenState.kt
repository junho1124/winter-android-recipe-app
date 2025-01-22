package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import com.surivalcoding.composerecipeapp.core.presentation.ViewStateable
import com.surivalcoding.composerecipeapp.domain.model.Recipe

data class SavedRecipesScreenState(
    val recipes: List<Recipe> = emptyList(),
    val isLoading: Boolean = true
): ViewStateable() {
    companion object {
        fun initialState() = SavedRecipesScreenState()
    }
}