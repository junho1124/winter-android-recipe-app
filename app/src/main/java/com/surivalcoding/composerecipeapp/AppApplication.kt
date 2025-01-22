package com.surivalcoding.composerecipeapp

import android.app.Application
import com.surivalcoding.composerecipeapp.data.data_source.local.MockBookmarkDataSourceImpl
import com.surivalcoding.composerecipeapp.data.data_source.remote.MockRecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.domain.repository.RecipeRepository
import com.surivalcoding.composerecipeapp.data.repository.RecipeRepositoryImpl
import com.surivalcoding.composerecipeapp.di.initKoin

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(this)
    }
}