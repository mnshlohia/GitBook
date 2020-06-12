package com.example.gitbook.ui.userslist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gitbook.R
import com.example.gitbook.ui.RepoListItem
import com.example.gitbook.databinding.UserListingLayoutBinding
import com.example.gitbook.di.ViewModelProviderFactory
import com.example.gitbook.ui.userslist.CustomItemDecorationUserList
import com.example.gitbook.ui.userslist.fragments.adapters.RepoListAdapter
import com.example.gitbook.ui.userslist.viewmodels.RepoViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ReposFragment : DaggerFragment(), RepoListAdapter.ItemCallback {
    private var username: String? = null

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var repoViewModel: RepoViewModel

    lateinit var binding: UserListingLayoutBinding

    @Inject
    lateinit var repoListAdapter: RepoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserListingLayoutBinding.inflate(inflater)
        setRepoRecyclerViewLayoutManagerToAdapter()
        return binding.root
    }

    private fun setRepoRecyclerViewLayoutManagerToAdapter() {
        val mLayoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        context?.let { CustomItemDecorationUserList(it) }?.let {
            binding.usersRV.addItemDecoration(it)
        }
        binding.usersRV.layoutManager = mLayoutManager
        binding.usersRV.adapter = repoListAdapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        repoViewModel = ViewModelProvider(viewModelStore, viewModelProviderFactory)
            .get(RepoViewModel::class.java)
        arguments?.let {
            username = it.getString("username")
        }
        binding.usersHeader.text= "$username's ${getString(R.string.repoList)}"
        repoViewModel.setPagination(username)
        observeRepoListLiveData()

    }


    private fun observeRepoListLiveData() {
        repoViewModel.liveData()?.observe(viewLifecycleOwner, Observer {
            it?.let {
                setRepoListingAdapter(it)
            } ?: run {
            }
        })

    }
    private fun setRepoListingAdapter(it: PagedList<RepoListItem>) {
        repoListAdapter.setItemCallBack(this)
        repoListAdapter.submitList(it)
    }

    override fun clickItemCallback(reponame: String) {

        val bundle= bundleOf("username" to username,"reponame" to reponame)

        activity?.let { it1 ->
            Navigation.findNavController(
                it1, R.id.nav_host_fragment_container
            ).navigate(R.id.action_repoScreen_to_repoDetailFragment,bundle)
        }
    }

}