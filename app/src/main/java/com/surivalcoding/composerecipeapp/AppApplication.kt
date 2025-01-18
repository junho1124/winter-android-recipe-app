package com.surivalcoding.composerecipeapp

import android.app.Application
import com.surivalcoding.composerecipeapp.data_source.local.MockBookmarkDataSourceImpl
import com.surivalcoding.composerecipeapp.data_source.remote.MockRecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.repository.RecipeRepositoryImpl

class AppApplication: Application() {
    val recipeRepository: RecipeRepository by lazy {
        RecipeRepositoryImpl(
            MockRecipeDataSourceImpl(),
            MockBookmarkDataSourceImpl()
        )
    }
}