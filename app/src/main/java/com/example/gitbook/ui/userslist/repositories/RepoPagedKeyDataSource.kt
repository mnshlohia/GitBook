package com.example.gitbook.ui.userslist.repositories

import androidx.paging.PageKeyedDataSource
import com.example.gitbook.ui.RepoListItem
import retrofit2.Call
import retrofit2.Response


class RepoPagedKeyDataSource internal constructor(private val repositoryImpl: RepoLIstRepositoryImpl) :
    PageKeyedDataSource<Int, RepoListItem>() {
    private var user: String?=null
    private var sourceIndex = 0

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, RepoListItem>
    ) {
        user?.let {
            repositoryImpl.getRepos(it).enqueue(object : retrofit2.Callback<List<RepoListItem>> {
                override fun onFailure(call: Call<List<RepoListItem>>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<List<RepoListItem>>,
                    response: Response<List<RepoListItem>>
                ) {
                    sourceIndex++
                    response.body()?.let { callback.onResult(it,null,sourceIndex) }
                }


            } )
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, RepoListItem>) {
        user?.let {
            repositoryImpl.getRepos(it).enqueue(object : retrofit2.Callback<List<RepoListItem>> {
                override fun onFailure(call: Call<List<RepoListItem>>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<List<RepoListItem>>,
                    response: Response<List<RepoListItem>>
                ) {
                    val keyAdjacent: Int? = if(params.key==3){
                        null
                    }else{
                        params.key + 1
                    }
                    response.body()?.let { callback.onResult(it,keyAdjacent) }
                }


            } )
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, RepoListItem>) {
    }

    fun setUsername(username: String?) {
          this.user=username
    }

}