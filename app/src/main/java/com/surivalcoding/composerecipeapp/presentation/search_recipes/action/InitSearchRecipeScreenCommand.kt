package com.surivalcoding.composerecipeapp.presentation.search_recipes.action

import androidx.lifecycle.viewModelScope
import com.surivalcoding.composerecipeapp.core.domain.useCase.VoidParams
import com.surivalcoding.composerecipeapp.core.model.Result
import com.surivalcoding.composerecipeapp.core.presentation.ViewCommandable
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case.GetSavedRecipesUseCase
import com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case.SearchRecipesUseCase
import com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case.SearchRecipesUseCaseParams
import com.surivalcoding.composerecipeapp.presentation.search_recipes.SearchRecipesScreenEvent
import com.surivalcoding.composerecipeapp.presentation.search_recipes.SearchRecipesScreenViewModel
import kotlinx.coroutines.launch

class InitSearchRecipeScreenCommand(
    private val getSavedRecipesUseCase: GetSavedRecipesUseCase,
    private val searchRecipesUseCase: SearchRecipesUseCase,
) : ViewCommandable<SearchRecipesScreenEvent.InitSearchRecipes, SearchRecipesScreenViewModel> {
    override fun execute(
        event: SearchRecipesScreenEvent.InitSearchRecipes,
        vm: SearchRecipesScreenViewModel
    ) {
        vm.viewModelScope.launch {
            // 두 결과를 비동기로 병렬 실행하여 수집
            val savedRecipesResult = getSavedRecipesUseCase(VoidParams())
            val recipesResult =
                searchRecipesUseCase(SearchRecipesUseCaseParams(""))

            // 두 결과가 모두 성공이면 상태 업데이트
            if (savedRecipesResult is Result.Success && recipesResult is Result.Success) {
                vm.updateState(
                    vm.state.value.copy(
                        bookmarkRecipeIds = savedRecipesResult.data.map { it.id }
                            .toSet(),
                        recipes = recipesResult.data,
                        isLoading = false
                    )
                )
            } else {
                // 실패하면 실패 처리
                val error =
                    (savedRecipesResult as? Result.Error)?.error
                        ?: (recipesResult as? Result.Error)?.error
                        ?: Exception("Unknown error")
                vm.gotFailure(error)
            }
        }
    }
}
