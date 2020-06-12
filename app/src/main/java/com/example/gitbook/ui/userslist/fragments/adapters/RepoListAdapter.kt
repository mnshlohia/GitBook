package com.example.gitbook.ui.userslist.fragments.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.gitbook.R
import com.example.gitbook.ui.RepoListItem
import com.example.gitbook.databinding.UserListItemLayoutBinding


class RepoListAdapter  :
    PagedListAdapter<RepoListItem, RepoListAdapter.ViewHolder>(UserDiffCallback()) {
    private var mContext: Context? = null
    private var itemCallback:ItemCallback?=null

    fun setItemCallBack(itemCallback: ItemCallback){
        this.itemCallback=itemCallback
    }

    class UserDiffCallback : DiffUtil.ItemCallback<RepoListItem>() {
        override fun areItemsTheSame(oldItem: RepoListItem, newItem: RepoListItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RepoListItem, newItem: RepoListItem): Boolean {
            return oldItem == newItem
        }

    }

    inner class ViewHolder(val binding: UserListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.itemCL.setOnClickListener{
                getItem(adapterPosition)?.name?.let { itemCallback?.clickItemCallback(it) }
            }
        }

        fun bind(item: RepoListItem?) {
            Glide.with(binding.root)
                .load(R.drawable.ic_baseline_person_24)
                .error(R.drawable.ic_baseline_person_24)
                .apply(RequestOptions.circleCropTransform())
                .into(binding.avatarImage)


            binding.apply {
                userName.text = item?.name
                itemId.text = "Forks :${item?.forks}"
                userType.text = "Watchers Count : ${item?.watchers_count}"
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val mInflater = LayoutInflater.from(mContext)
        val binding = UserListItemLayoutBinding.inflate(mInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)

    }

    interface ItemCallback{
        fun clickItemCallback(username:String)
    }

}