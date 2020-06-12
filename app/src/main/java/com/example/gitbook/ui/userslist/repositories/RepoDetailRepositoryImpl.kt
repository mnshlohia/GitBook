package com.example.gitbook.ui.userslist.repositories


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.example.gitbook.api.main.MainApiInterface
import com.example.gitbook.ui.RepoDetailItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class RepoDetailRepositoryImpl @Inject constructor():RepoDetailRepo{

    private var liveData: MutableLiveData<RepoDetailItem>?=null

    @Inject
    lateinit var mainApiInterface: MainApiInterface

    override  fun getReposDetail(
        user: String,
        repo: String,
        liveData: MutableLiveData<RepoDetailItem>?
    ) {
        this.liveData=liveData
         mainApiInterface.getRepoDetail(user,repo).enqueue(object : Callback<RepoDetailItem>{
             override fun onFailure(call: Call<RepoDetailItem>, t: Throwable) {
             }

             override fun onResponse(
                 call: Call<RepoDetailItem>,
                 response: Response<RepoDetailItem>
             ) {
                 liveData?.value=response.body()
             }


         })
    }


}
