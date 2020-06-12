package com.example.gitbook.ui.userslist.repositories

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.gitbook.ui.UsersItem
import javax.inject.Inject


class UserDataSourceFactory @Inject constructor(private val usersPageKeyedDataSource: UsersPageKeyedDataSource) : DataSource.Factory<Int, UsersItem>() {
     val liveDataUsers: MutableLiveData<UsersPageKeyedDataSource>? = MutableLiveData()


    override fun create(): DataSource<Int,UsersItem> {
        liveDataUsers?.postValue(usersPageKeyedDataSource)
        return usersPageKeyedDataSource
    }

}