package com.surivalcoding.composerecipeapp.di.command

import com.surivalcoding.composerecipeapp.presentation.saved_recipes.action.GetSavedRecipeSavedScreenCommand
import com.surivalcoding.composerecipeapp.presentation.search_recipes.action.InitSearchRecipeScreenCommand
import org.koin.dsl.module

val viewCommandModule = module {
    single { GetSavedRecipeSavedScreenCommand(get()) }
    single { InitSearchRecipeScreenCommand(get(), get()) }
}