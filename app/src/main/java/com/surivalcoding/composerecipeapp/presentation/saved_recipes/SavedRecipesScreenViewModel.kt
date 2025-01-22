package com.surivalcoding.composerecipeapp.presentation.saved_recipes

import androidx.lifecycle.viewModelScope
import com.surivalcoding.composerecipeapp.core.domain.useCase.VoidParams
import com.surivalcoding.composerecipeapp.core.model.Result
import com.surivalcoding.composerecipeapp.core.presentation.ViewModelable
import com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case.BookmarkRecipeUseCase
import com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case.BookmarkRecipeUseCaseParams
import com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case.GetSavedRecipesUseCase
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.action.SavedRecipesScreenEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SavedRecipesScreenViewModel(
    private val getSavedRecipesUseCase: GetSavedRecipesUseCase,
    private val bookmarkRecipeUseCase: BookmarkRecipeUseCase,
) : ViewModelable<SavedRecipesScreenState, SavedRecipesScreenEvent>(
    SavedRecipesScreenState.initialState()
) {

    init {
        onEvent(SavedRecipesScreenEvent.GetSavedRecipes)
    }

    override fun onEvent(event: SavedRecipesScreenEvent) {
        when (event) {
            is SavedRecipesScreenEvent.BookmarkRecipe -> {
                viewModelScope.launch {
                    val result =
                        bookmarkRecipeUseCase(BookmarkRecipeUseCaseParams(event.recipeId))
                    when (result) {
                        is Result.Success -> {
                            updateState(
                                state.value.copy(
                                    recipes = state.value.recipes.filter { it.id != event.recipeId },
                                    isLoading = false,
                                )
                            )
                        }

                        is Result.Error -> {
                            gotFailure(result.error)
                        }
                    }
                }
            }

            is SavedRecipesScreenEvent.GetSavedRecipes -> {
                viewModelScope.launch {
                    delay(1000)
                    val result = getSavedRecipesUseCase(VoidParams())
                    when (result) {
                        is Result.Success -> {
                            updateState(
                                state.value.copy(
                                    recipes = result.data,
                                    isLoading = false
                                )
                            )
                        }

                        is Result.Error -> {
                            gotFailure(result.error)
                        }
                    }
                }
            }

            is SavedRecipesScreenEvent.NavigateToRecipeDetail -> TODO()
        }
    }
}