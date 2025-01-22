package com.surivalcoding.composerecipeapp.di.data

import com.surivalcoding.composerecipeapp.data.data_source.local.BookmarkDataSource
import com.surivalcoding.composerecipeapp.data.data_source.local.MockBookmarkDataSourceImpl
import com.surivalcoding.composerecipeapp.data.data_source.remote.MockRecipeDataSourceImpl
import com.surivalcoding.composerecipeapp.data.data_source.remote.RecipeDataSource
import org.koin.dsl.module

val mockDataSourceModule = module {
    single<RecipeDataSource> { MockRecipeDataSourceImpl() }
    single<BookmarkDataSource> { MockBookmarkDataSourceImpl() }
}