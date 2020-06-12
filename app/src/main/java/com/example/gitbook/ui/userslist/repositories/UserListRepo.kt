package com.example.gitbook.ui.userslist.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.example.gitbook.ui.UsersItem

interface UserListRepo {
   suspend fun  getUsersList(order: MutableLiveData<List<UsersItem>>)
}