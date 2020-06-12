package com.example.gitbook.di.main


import com.example.gitbook.ui.userslist.fragments.RepoDetailFragment
import com.example.gitbook.ui.userslist.fragments.ReposFragment
import com.example.gitbook.ui.userslist.fragments.UsersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributesUsersFragment(): UsersFragment

    @ContributesAndroidInjector
    abstract fun contributesReposFragment(): ReposFragment

    @ContributesAndroidInjector
    abstract fun contributesRepoDetailFragment(): RepoDetailFragment
}