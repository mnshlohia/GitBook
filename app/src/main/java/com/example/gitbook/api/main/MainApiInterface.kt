package com.example.gitbook.api.main


import com.example.gitbook.ui.RepoDetailItem
import com.example.gitbook.ui.RepoListItem
import com.example.gitbook.ui.UsersItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MainApiInterface {

    @GET("users")
    fun getUsers(@Query("since") since: Int=0): Call<List<UsersItem>>

    @GET("users/{user}/repos")
    fun getRepos(@Path("user") user: String): Call<List<RepoListItem>>

    @GET("repos/{user}/{repo}")
    fun getRepoDetail(@Path("user") user: String,@Path("repo") repo: String): Call<RepoDetailItem>


}

