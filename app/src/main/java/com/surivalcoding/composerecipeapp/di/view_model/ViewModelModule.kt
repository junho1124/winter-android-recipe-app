package com.surivalcoding.composerecipeapp.di.view_model

import com.surivalcoding.composerecipeapp.presentation.saved_recipes.SavedRecipesScreenViewModel
import com.surivalcoding.composerecipeapp.presentation.search_recipes.SearchRecipesScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SavedRecipesScreenViewModel(get(), get()) }
    viewModel { SearchRecipesScreenViewModel(get(), get(), get()) }
}