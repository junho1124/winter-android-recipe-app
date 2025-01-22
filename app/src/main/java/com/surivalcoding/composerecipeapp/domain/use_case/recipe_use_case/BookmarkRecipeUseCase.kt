package com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case

import com.surivalcoding.composerecipeapp.core.model.Result
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.core.domain.useCase.UseCase
import com.surivalcoding.composerecipeapp.core.domain.useCase.UseCaseParams

class BookmarkRecipeUseCase(
    private val recipeRepository: RecipeRepository,
): UseCase<BookmarkRecipeUseCaseParams, Result<Boolean, Exception>> {
    override suspend fun invoke(params: BookmarkRecipeUseCaseParams): Result<Boolean, Exception> {
        return recipeRepository.bookmarkRecipe(params.recipeId)
    }
}

class BookmarkRecipeUseCaseParams(
    val recipeId: Int,
): UseCaseParams