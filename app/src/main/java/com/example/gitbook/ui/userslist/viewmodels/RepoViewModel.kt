package com.example.gitbook.ui.userslist.viewmodels

import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.gitbook.ui.RepoListItem
import com.example.gitbook.ui.userslist.repositories.RepoDataSourceFactory
import javax.inject.Inject


class RepoViewModel @Inject constructor(
    private val repoDataSourceFactory: RepoDataSourceFactory
) : ViewModel() {

    private var listLiveData: LiveData<PagedList<RepoListItem>>? = null

    fun liveData()= listLiveData


    fun setPagination(username: String?) {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(10)
            .setPageSize(10).build()
        repoDataSourceFactory.setUsername(username)
        listLiveData =
            LivePagedListBuilder(repoDataSourceFactory, pagedListConfig)
                .build()
    }


}