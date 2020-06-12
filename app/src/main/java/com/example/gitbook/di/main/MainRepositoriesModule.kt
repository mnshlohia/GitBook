package com.example.gitbook.di.main


import com.example.gitbook.ui.userslist.repositories.*
import dagger.Module
import dagger.Provides

@Module
 class MainRepositoriesModule {

    @Provides
     fun providesUserListRepositoryImpl(): UserListRepo{
        return UserListRepositoryImpl()
    }

    @Provides
    fun providesUsersPageKeyedDataSource(userListRepositoryImpl: UserListRepositoryImpl): UsersPageKeyedDataSource {
        return UsersPageKeyedDataSource(userListRepositoryImpl)
    }

    @Provides
    fun providesUserDataSourceFactory(usersPageKeyedDataSource: UsersPageKeyedDataSource): UserDataSourceFactory {
        return  UserDataSourceFactory(usersPageKeyedDataSource)
    }

    @Provides
    fun providesRepoLIstRepositoryImpl(): RepoListRepo{
        return RepoLIstRepositoryImpl()
    }

    @Provides
    fun providesRepoPagedKeyDataSource(repoLIstRepositoryImpl: RepoLIstRepositoryImpl): RepoPagedKeyDataSource {
        return RepoPagedKeyDataSource(repoLIstRepositoryImpl)
    }

    @Provides
    fun providesRepoDataSourceFactory(repoPagedKeyDataSource: RepoPagedKeyDataSource): RepoDataSourceFactory {
        return  RepoDataSourceFactory(repoPagedKeyDataSource)
    }

    @Provides
    fun providesRepoDetailRepositoryImpl(): RepoDetailRepo{
        return RepoDetailRepositoryImpl()
    }

}