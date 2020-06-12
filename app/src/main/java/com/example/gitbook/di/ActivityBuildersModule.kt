package com.example.gitbook.di


import com.example.gitbook.MainActivity
import com.example.gitbook.SplashActivity
import com.example.gitbook.di.main.MainActivityModule
import com.example.gitbook.di.main.MainFragmentBuildersModule
import com.example.gitbook.di.main.MainRepositoriesModule
import com.example.gitbook.di.main.MainViewModelsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {


    @ContributesAndroidInjector
    abstract fun contributesSplashActivity(): SplashActivity


    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            MainFragmentBuildersModule::class,
            MainViewModelsModule::class,
            MainRepositoriesModule::class])
    abstract fun contributesMainActivity(): MainActivity

}