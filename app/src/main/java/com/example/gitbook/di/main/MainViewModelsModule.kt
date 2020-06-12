package com.example.gitbook.di.main


import androidx.lifecycle.ViewModel
import com.example.gitbook.di.ViewModelKey
import com.example.gitbook.ui.userslist.viewmodels.RepoDetailViewModel
import com.example.gitbook.ui.userslist.viewmodels.RepoViewModel
import com.example.gitbook.ui.userslist.viewmodels.UserListingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserListingViewModel::class)
    abstract fun bindsUserListingViewModel(homeScreenViewModel: UserListingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RepoViewModel::class)
    abstract fun bindsRepoViewModel(repoViewModel: RepoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RepoDetailViewModel::class)
    abstract fun bindsRepoDetailViewModel(repoDetailViewModel: RepoDetailViewModel): ViewModel
}