package com.example.gitbook.ui.userslist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gitbook.R
import com.example.gitbook.databinding.UserListingLayoutBinding
import com.example.gitbook.di.ViewModelProviderFactory
import com.example.gitbook.persistence.UserDao
import com.example.gitbook.ui.UsersItem
import com.example.gitbook.ui.userslist.CustomItemDecorationUserList
import com.example.gitbook.ui.userslist.fragments.adapters.UserListAdapter
import com.example.gitbook.ui.userslist.viewmodels.UserListingViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class UsersFragment : DaggerFragment(),UserListAdapter.ItemCallback{
    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var userListingViewModel: UserListingViewModel

    lateinit var binding: UserListingLayoutBinding

    @Inject
    lateinit var userListAdapter: UserListAdapter

    @Inject
    lateinit var userDao: UserDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserListingLayoutBinding.inflate(inflater)
        setUserRecyclerViewLayoutManagerToAdapter()
        return binding.root

    }

    private fun setUserRecyclerViewLayoutManagerToAdapter() {
        val mLayoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        context?.let { CustomItemDecorationUserList(it) }?.let {
            binding.usersRV.addItemDecoration(it)
        }
        binding.usersRV.layoutManager = mLayoutManager
        binding.usersRV.adapter = userListAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        userListingViewModel = ViewModelProvider(viewModelStore, viewModelProviderFactory)
            .get(UserListingViewModel::class.java)

        observeUserListLiveData()
        getData()
    }

    private fun getData() {
        /*if (::userListingViewModel.isInitialized) {
            userListingViewModel.getUSerLIstData()
        }*/
    }

    private fun observeUserListLiveData() {
            userListingViewModel.getUserLiveData()?.observe(viewLifecycleOwner, Observer {
                it?.let {
                    setUserListingAdapter(it)
                } ?: run {
                }
            })

    }
    private fun setUserListingAdapter(it: PagedList<UsersItem>) {
        userListAdapter.setItemCallBack(this)
        userListAdapter.submitList(it)
    }

    override fun clickItemCallback(username: String) {

        val bundle=bundleOf("username" to username)

        activity?.let { it1 ->
            Navigation.findNavController(
                it1, R.id.nav_host_fragment_container
            ).navigate(R.id.action_userScreen_to_reposFragment,bundle)
        }
    }

}