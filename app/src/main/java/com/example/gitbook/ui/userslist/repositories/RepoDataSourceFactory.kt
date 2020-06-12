package com.example.gitbook.ui.userslist.repositories

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.gitbook.ui.RepoListItem
import javax.inject.Inject


class RepoDataSourceFactory @Inject constructor(private val repoPagedKeyDataSource: RepoPagedKeyDataSource) : DataSource.Factory<Int, RepoListItem>() {
    private var username: String?=null
    val liveDataUsers: MutableLiveData<RepoPagedKeyDataSource>? = MutableLiveData()


    override fun create(): DataSource<Int, RepoListItem> {
        repoPagedKeyDataSource.setUsername(username)
        liveDataUsers?.postValue(repoPagedKeyDataSource)
        return repoPagedKeyDataSource
    }

    fun setUsername(username: String?) {
          this.username=username
    }

}