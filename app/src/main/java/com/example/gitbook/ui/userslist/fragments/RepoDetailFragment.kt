package com.example.gitbook.ui.userslist.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gitbook.R
import com.example.gitbook.databinding.RepoDetailLayoutBinding
import com.example.gitbook.di.ViewModelProviderFactory
import com.example.gitbook.ui.RepoDetailItem
import com.example.gitbook.ui.userslist.viewmodels.RepoDetailViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class RepoDetailFragment : DaggerFragment() {
    private var username: String? = null
    private var reponame: String? = null

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    private lateinit var repoDetailViewModel: RepoDetailViewModel

    lateinit var binding: RepoDetailLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RepoDetailLayoutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        repoDetailViewModel = ViewModelProvider(viewModelStore, viewModelProviderFactory)
            .get(RepoDetailViewModel::class.java)
        arguments?.let {
            username = it.getString("username")
            reponame = it.getString("reponame")

        }
        observeRepoListLiveData()
        username?.let { reponame?.let { it1 -> repoDetailViewModel.fetchData(it, it1) } }
    }

    private fun observeRepoListLiveData() {
        repoDetailViewModel.liveData().observe(viewLifecycleOwner, Observer {
            it?.let {

                processUI(it)
            } ?: run {
            }
        })
    }

    private fun processUI(item: RepoDetailItem) {
        binding.apply {
            item.also {
                header.text = "${it.name}'s ${getString(R.string.repoDetail)}"
                nameValueTV.text=it.name
                nameFullValueTV.text=it.full_name
                stargazersValueTV.text=it.stargazers_count.toString()
                watchersValueTV.text=it.watchers_count.toString()
                languageValueTV.text=it.language
                forksValueTV.text=it.forks_count.toString()
                subscribersValueTV.text=it.subscribers_count.toString()
                htmlUrlValueTV.text=it.html_url
                descValueTV.text=it.description
            }
        }
    }
}