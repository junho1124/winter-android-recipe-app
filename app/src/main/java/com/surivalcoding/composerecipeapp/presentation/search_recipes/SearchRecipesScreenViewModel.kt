package com.surivalcoding.composerecipeapp.presentation.search_recipes

import androidx.lifecycle.viewModelScope
import com.surivalcoding.composerecipeapp.core.model.Result
import com.surivalcoding.composerecipeapp.core.presentation.ViewModelable
import com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case.BookmarkRecipeUseCase
import com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case.BookmarkRecipeUseCaseParams
import com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case.SearchRecipesUseCase
import com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case.SearchRecipesUseCaseParams
import com.surivalcoding.composerecipeapp.presentation.search_recipes.action.InitSearchRecipeScreenCommand
import kotlinx.coroutines.launch

class SearchRecipesScreenViewModel(
    private val initSearchRecipeScreenCommand: InitSearchRecipeScreenCommand,
    private val searchRecipesUseCase: SearchRecipesUseCase,
    private val bookmarkRecipeUseCase: BookmarkRecipeUseCase,
) : ViewModelable<SearchRecipesScreenState, SearchRecipesScreenEvent>(
    SearchRecipesScreenState.initialState()
) {

    init {
        viewModelScope.launch {
            onEvent(SearchRecipesScreenEvent.InitSearchRecipes)
        }
    }

    override fun onEvent(event: SearchRecipesScreenEvent) {
        when (event) {
            is SearchRecipesScreenEvent.BookmarkRecipe -> {
                viewModelScope.launch {
                    val result =
                        bookmarkRecipeUseCase(BookmarkRecipeUseCaseParams(event.recipeId))
                    when (result) {
                        is Result.Success -> {
                            updateState(
                                state.value.copy(
                                    bookmarkRecipeIds = state.value.bookmarkRecipeIds.toMutableSet()
                                        .apply {
                                            if (contains(event.recipeId)) {
                                                remove(event.recipeId)
                                            } else {
                                                add(event.recipeId)
                                            }
                                        })
                            )
                        }

                        is Result.Error -> {
                            gotFailure(result.error)
                        }
                    }
                }
            }

            is SearchRecipesScreenEvent.NavigateToRecipeDetail -> TODO()
            is SearchRecipesScreenEvent.SearchRecipes -> {
                viewModelScope.launch {
                    val result =
                        searchRecipesUseCase(SearchRecipesUseCaseParams(event.query))
                    when (result) {
                        is Result.Success -> {
                            updateState(
                                state.value.copy(
                                    filteredRecipes = result.data,
                                    query = event.query,
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

            is SearchRecipesScreenEvent.InitSearchRecipes -> initSearchRecipeScreenCommand.execute(
                event,
                this
            )
        }
    }

}