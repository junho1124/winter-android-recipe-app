package com.surivalcoding.composerecipeapp.di.use_case

import com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case.BookmarkRecipeUseCase
import com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case.GetRecipesUseCase
import com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case.GetSavedRecipesUseCase
import com.surivalcoding.composerecipeapp.domain.use_case.recipe_use_case.SearchRecipesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { BookmarkRecipeUseCase(get()) }
    single { GetRecipesUseCase(get()) }
    single { GetSavedRecipesUseCase(get()) }
    single { SearchRecipesUseCase(get()) }
}