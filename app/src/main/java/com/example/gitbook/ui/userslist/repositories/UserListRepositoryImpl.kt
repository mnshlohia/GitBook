package com.example.gitbook.ui.userslist.repositories


import android.graphics.Movie
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList.BoundaryCallback
import com.example.gitbook.api.main.MainApiInterface
import com.example.gitbook.persistence.UserDao
import com.example.gitbook.ui.UsersItem
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class UserListRepositoryImpl @Inject constructor():UserListRepo{


    @Inject
    lateinit var mainApiInterface: MainApiInterface

     fun getUsers(): Call<List<UsersItem>> {
      return mainApiInterface.getUsers(0)
    }

    override suspend fun getUsersList(order: MutableLiveData<List<UsersItem>>) {
    }

}
