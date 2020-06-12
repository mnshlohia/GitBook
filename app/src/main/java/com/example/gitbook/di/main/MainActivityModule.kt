package com.example.gitbook.di.main


import android.content.Context
import com.example.gitbook.MainActivity
import com.example.gitbook.api.main.MainApiInterface
import com.example.gitbook.persistence.AppDatabase
import com.example.gitbook.persistence.UserDao
import com.example.gitbook.ui.userslist.fragments.adapters.RepoListAdapter
import com.example.gitbook.ui.userslist.fragments.adapters.UserListAdapter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class MainActivityModule {


    private var mainActivity: MainActivity? = null

    var context: Context? = null

    fun MainActivityContextModule(mainActivity: MainActivity?) {
        this.mainActivity = mainActivity
        context = mainActivity
    }


    @Provides
    fun provideContext(): Context? {
        return mainActivity
    }

    @Provides
    fun providesMainApiInterface(retrofit: Retrofit): MainApiInterface {
        return retrofit.create(MainApiInterface::class.java)
    }

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao {
        return db.getUserDao()
    }

    @Provides
    fun providesUserListAdapter(): UserListAdapter {
        return UserListAdapter()
    }

    @Provides
    fun providesRepoListAdapter(): RepoListAdapter {
        return RepoListAdapter()
    }

}