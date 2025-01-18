package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import coil3.Extras
import com.surivalcoding.composerecipeapp.AppApplication
import com.surivalcoding.composerecipeapp.model.Recipe
import com.surivalcoding.composerecipeapp.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SavedRecipesScreenViewModel(
    private val recipeRepository: RecipeRepository
): ViewModel() {
    private val _savedRecipes: MutableStateFlow<List<Recipe>> = MutableStateFlow(recipeRepository.getSavedRecipes())
    val savedRecipes: StateFlow<List<Recipe>> = _savedRecipes.asStateFlow()

    fun onBookmark(recipe: Recipe) {
        recipeRepository.bookmarkRecipe(recipe.id)
        viewModelScope.launch {
            _savedRecipes.emit(recipeRepository.getSavedRecipes())
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