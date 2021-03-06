package com.example.gitbook.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindsViewModelFactory(modelProviderFactory: ViewModelProviderFactory):ViewModelProvider.Factory
}