package com.example.gitbook.ui.userslist.repositories


import com.example.gitbook.ui.RepoListItem
import com.example.gitbook.api.main.MainApiInterface
import retrofit2.Call
import javax.inject.Inject


class RepoLIstRepositoryImpl @Inject constructor():RepoListRepo{


    @Inject
    lateinit var mainApiInterface: MainApiInterface

    override  fun getRepos(user:String): Call<List<RepoListItem>> {
        return mainApiInterface.getRepos(user)
    }


}
