package com.example.gitbook.ui.userslist.repositories

import com.example.gitbook.ui.RepoListItem
import retrofit2.Call

interface RepoListRepo {
    fun getRepos(user:String): Call<List<RepoListItem>>
}