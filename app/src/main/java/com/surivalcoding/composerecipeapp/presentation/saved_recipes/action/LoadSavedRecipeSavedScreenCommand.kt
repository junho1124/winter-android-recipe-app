package com.surivalcoding.composerecipeapp.presentation.saved_recipes.action

import androidx.lifecycle.viewModelScope
import com.surivalcoding.composerecipeapp.core.domain.useCase.VoidParams
import com.surivalcoding.composerecipeapp.core.presentation.ViewCommandable
import com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case.GetSavedRecipesUseCase
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.SavedRecipesScreenViewModel
import com.surivalcoding.composerecipeapp.core.model.Result
import kotlinx.coroutines.launch

class GetSavedRecipeSavedScreenCommand(
    private val getSavedRecipesUseCase: GetSavedRecipesUseCase,
) : ViewCommandable<SavedRecipesScreenEvent.GetSavedRecipes, SavedRecipesScreenViewModel> {
    override fun execute(
        event: SavedRecipesScreenEvent.GetSavedRecipes,
        vm: SavedRecipesScreenViewModel
    ) {
        vm.viewModelScope.launch {
            val result = getSavedRecipesUseCase(VoidParams())
            when (result) {
                is Result.Success -> {
                    vm.updateState(
                        vm.state.value.copy(
                            recipes = result.data,
                            isLoading = false
                        )
                    )
                }
                is Result.Error -> {
                    vm.gotFailure(result.error)
                }
            }
        }
    }

}