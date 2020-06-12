package com.example.gitbook.ui.userslist.repositories

import androidx.paging.PageKeyedDataSource
import com.example.gitbook.ui.UsersItem
import retrofit2.Call
import retrofit2.Response


class UsersPageKeyedDataSource internal constructor(private val userListRepositoryImpl: UserListRepositoryImpl) :
    PageKeyedDataSource<Int,UsersItem>() {
    private var sourceIndex = 0

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, UsersItem>
    ) {
        userListRepositoryImpl.getUsers().enqueue(object : retrofit2.Callback<List<UsersItem>> {
            override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<List<UsersItem>>,
                response: Response<List<UsersItem>>
            ) {
                sourceIndex++
                response.body()?.let { callback.onResult(it,null,sourceIndex) }
            }


        } )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UsersItem>) {
        userListRepositoryImpl.getUsers().enqueue(object : retrofit2.Callback<List<UsersItem>> {
            override fun onFailure(call: Call<List<UsersItem>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<List<UsersItem>>,
                response: Response<List<UsersItem>>
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

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UsersItem>) {
    }

}