package com.example.gitbook.ui.userslist.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.gitbook.ui.UsersItem
import com.example.gitbook.ui.userslist.repositories.UserDataSourceFactory
import javax.inject.Inject


class UserListingViewModel @Inject constructor(userDataSourceFactory: UserDataSourceFactory) : ViewModel() {

    private var listLiveData: LiveData<PagedList<UsersItem>>? = null

    fun getUserLiveData()= listLiveData

   init {
       val pagedListConfig = PagedList.Config.Builder()
           .setEnablePlaceholders(true)
           .setInitialLoadSizeHint(10)
           .setPageSize(10).build()
       listLiveData =
           LivePagedListBuilder(userDataSourceFactory, pagedListConfig)
               .build()
   }

}