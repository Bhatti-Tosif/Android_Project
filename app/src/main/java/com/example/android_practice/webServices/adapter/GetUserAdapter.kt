package com.example.android_practice.webServices.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_practice.databinding.ItemGetUserDetailBinding
import com.example.android_practice.webServices.model.UserModel

class GetUserAdapter(private var editUser: (UserModel, Int) -> Unit, private var deleteUser: (String, Int) -> Unit, private  var seeUserDetail: (String) -> Unit): RecyclerView.Adapter<GetUserAdapter.GetUserViewHolder>() {

    /** properties Declaration **/
    private var userList = mutableListOf<UserModel>()

    /** Set User List */
    fun setUserDetail(userList: MutableList<UserModel>) {
        this.userList = userList
    }

    /*** Create ViewHolder Class for Showing user Detail */
    inner class GetUserViewHolder(val binding: ItemGetUserDetailBinding): RecyclerView.ViewHolder(binding.root) {

        /* bind function for bind data to UI */
        fun bind(userDetail: UserModel, position: Int) {
            Glide.with(itemView)
                .load(userDetail.avatar)
                .into(binding.ivUserPic)
            binding.userModel = userDetail

            binding.btnEditUser.setOnClickListener {
                editUser(userDetail, position)
            }

            binding.btnDeleteUser.setOnClickListener {
                deleteUser(userDetail.id, position)
            }

            itemView.setOnClickListener {
                seeUserDetail(userDetail.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GetUserViewHolder {
        val binding = ItemGetUserDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GetUserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: GetUserViewHolder, position: Int) {
        userList[position].let { holder.bind(it, position) }
    }
}