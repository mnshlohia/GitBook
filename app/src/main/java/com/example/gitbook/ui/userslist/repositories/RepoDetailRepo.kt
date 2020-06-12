package com.example.gitbook.ui.userslist.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.example.gitbook.ui.RepoDetailItem
import retrofit2.Call

interface RepoDetailRepo {
    fun getReposDetail(
        user: String,
        repo: String,
        liveData: MutableLiveData<RepoDetailItem>?
    )
}