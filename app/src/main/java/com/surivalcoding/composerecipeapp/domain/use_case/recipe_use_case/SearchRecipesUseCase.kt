package com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case

import com.surivalcoding.composerecipeapp.core.model.Result
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.core.domain.useCase.UseCase
import com.surivalcoding.composerecipeapp.core.domain.useCase.UseCaseParams

class SearchRecipesUseCase(
    private val recipeRepository: RecipeRepository,
): UseCase<SearchRecipesUseCaseParams, Result<List<Recipe>, Exception>> {
    override suspend fun invoke(params: SearchRecipesUseCaseParams): Result<List<Recipe>, Exception> {
        return recipeRepository.searchRecipes(params.query)
    }

}

class SearchRecipesUseCaseParams(
    val query: String,
): UseCaseParams