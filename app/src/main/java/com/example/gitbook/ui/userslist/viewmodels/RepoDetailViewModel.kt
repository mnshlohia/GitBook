package com.example.gitbook.ui.userslist.viewmodels

import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.gitbook.ui.RepoDetailItem
import com.example.gitbook.ui.userslist.repositories.RepoDetailRepositoryImpl
import javax.inject.Inject


class RepoDetailViewModel @Inject constructor() : ViewModel() {

     private val listLiveData: MutableLiveData<RepoDetailItem> by lazy {
        MutableLiveData<RepoDetailItem>()
    }


    @Inject
    lateinit var repoDetailRepositoryImpl: RepoDetailRepositoryImpl

    fun liveData()= listLiveData

   fun fetchData(user:String,repo:String){
       repoDetailRepositoryImpl.getReposDetail(user,repo,liveData())
   }

}