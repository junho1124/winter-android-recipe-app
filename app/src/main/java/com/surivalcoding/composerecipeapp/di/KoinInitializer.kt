package com.surivalcoding.composerecipeapp.di

import android.app.Application
import com.surivalcoding.composerecipeapp.di.command.viewCommandModule
import com.surivalcoding.composerecipeapp.di.data.mockDataSourceModule
import com.surivalcoding.composerecipeapp.di.repository.repositoryModule
import com.surivalcoding.composerecipeapp.di.use_case.useCaseModule
import com.surivalcoding.composerecipeapp.di.view_model.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

fun initKoin(app: Application) {
    startKoin {
        androidLogger()
        androidContext(app)
        modules(
            listOf(
                viewCommandModule,
                mockDataSourceModule,
                viewModelModule,
                repositoryModule,
                useCaseModule,
                appModule,
            )
        )
    }
}