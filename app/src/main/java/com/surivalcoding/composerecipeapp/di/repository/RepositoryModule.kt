package com.surivalcoding.composerecipeapp.di.repository

import com.surivalcoding.composerecipeapp.data.repository.RecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<RecipeRepository> { RecipeRepositoryImpl(get(), get()) }
}