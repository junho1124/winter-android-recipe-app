package com.surivalcoding.composerecipeapp.presentation.search_recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.core.ViewModelable
import com.surivalcoding.composerecipeapp.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.core.model.Result

class SearchRecipesScreenViewModel(
    private val recipeRepository: RecipeRepository
): ViewModelable<SearchRecipesScreenState>(
    SearchRecipesScreenState.initialState()) {

    init {
        val savedRecipesResult = recipeRepository.getSavedRecipes()
        val recipesResult = recipeRepository.searchRecipes("")
        when (recipesResult) {
            is Result.Success -> {
                updateState(state.value.copy(recipes = recipesResult.data, isLoading = false))
            }
            is Result.Error -> {
                gotFailure(recipesResult.error)
            }
        }
        when (savedRecipesResult) {
            is Result.Success -> {
                updateState(state.value.copy(bookmarkRecipeIds = savedRecipesResult.data.map { it.id }.toSet()))
            }
            is Result.Error -> {
                gotFailure(savedRecipesResult.error)
            }
        }
    }

    fun onQueryChanged(query: String) {
        val result = recipeRepository.searchRecipes(query)
        when (result) {
            is Result.Success -> {
                updateState(state.value.copy(filteredRecipes = result.data, query = query, isLoading = false))
            }
            is Result.Error -> {
                gotFailure(result.error)
            }
        }
    }

    fun onRecipeClicked(recipeId: Int) {
        // TODO: Route to recipe detail screen
        throw NotImplementedError("Not implemented yet")
    }

    fun onBookmark(recipeId: Int) {
        val result = recipeRepository.bookmarkRecipe(recipeId)
        when (result) {
            is Result.Success -> {
                updateState(state.value.copy(bookmarkRecipeIds = state.value.bookmarkRecipeIds.toMutableSet().apply {
                    if (contains(recipeId)) {
                        remove(recipeId)
                    } else {
                        add(recipeId)
                    }
                }))
            }
            is Result.Error -> {
                gotFailure(result.error)
            }
        }
    }



    companion object {
            val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    modelClass: Class<T>,
                    extras: CreationExtras
                ): T {
                    val application = checkNotNull(extras[APPLICATION_KEY])

                    return SearchRecipesScreenViewModel(
                        (application as AppApplication).recipeRepository,
                    ) as T
                }
            }
        }

}