package com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case

import com.surivalcoding.composerecipeapp.core.domain.useCase.VoidParamUseCase
import com.surivalcoding.composerecipeapp.core.domain.useCase.VoidParams
import com.surivalcoding.composerecipeapp.core.model.Result
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository

class GetRecipesUseCase(
    private val recipeRepository: RecipeRepository
): VoidParamUseCase<Result<List<Recipe>, Exception>> {
    override suspend fun invoke(params: VoidParams): Result<List<Recipe>, Exception> {
        return recipeRepository.getRecipes()
    }
}

