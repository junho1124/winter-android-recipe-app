package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.core.ViewModelable
import com.surivalcoding.composerecipeapp.model.Recipe
import com.surivalcoding.composerecipeapp.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.core.model.Result
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SavedRecipesScreenViewModel(
    private val recipeRepository: RecipeRepository
): ViewModelable<SavedRecipesScreenState>(SavedRecipesScreenState.initialState()) {

    init {
        viewModelScope.launch {
            delay(1000)
            val result = recipeRepository.getSavedRecipes()
            when(result) {
                is Result.Success -> {
                    updateState(state.value.copy(recipes = result.data, isLoading = false))
                }
                is Result.Error -> {
                    gotFailure(result.error)
                }
            }
        }
    }

    fun onBookmark(recipe: Recipe) {
        val result = recipeRepository.bookmarkRecipe(recipe.id)

        when(result) {
            is Result.Success -> {
                updateState(state.value.copy(recipes = state.value.recipes - recipe))
            }
            is Result.Error -> {
                gotFailure(result.error)
            }
        }


    }

    fun onRecipeClicked(recipe: Recipe) {
        // Route to recipe detail screen
        throw NotImplementedError("Not implemented yet")
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application = checkNotNull(extras[APPLICATION_KEY])
                val savedStateHandle = extras.createSavedStateHandle()

                return SavedRecipesScreenViewModel(
                    (application as AppApplication).recipeRepository,
                ) as T
            }
        }
    }
}