package com.example.android_practice.webServices.activity

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.Volley
import com.example.android_practice.databinding.ActivityGetUserDetailBinding
import com.example.android_practice.webServices.Utils.AppConstant
import com.example.android_practice.webServices.Utils.DebouncingQueryTextListener
import com.example.android_practice.webServices.Utils.observeEvent
import com.example.android_practice.webServices.adapter.GetUserAdapter
import com.example.android_practice.webServices.factory.UserViewModelFactory
import com.example.android_practice.webServices.fragment.AddUserFragment
import com.example.android_practice.webServices.fragment.EditUserFragment
import com.example.android_practice.webServices.fragment.UserProfile
import com.example.android_practice.webServices.model.UserModel
import com.example.android_practice.webServices.viewModel.UserViewModel
import kotlinx.coroutines.launch

class GetUserDetailActivity : AppCompatActivity() {

    /** Properties declaration*/
    private lateinit var binding: ActivityGetUserDetailBinding
    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: GetUserAdapter
    private var userList = mutableListOf<UserModel>()


    /** Lifecycle of Activity */
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this, UserViewModelFactory(AppConstant.userRepository))[UserViewModel::class.java]

        prepareRecyclerView()
        binding.fabAddUser.setOnClickListener {
            AddUserFragment().show(supportFragmentManager, "ADD")
        }

        searchViewPrepare()

        userViewModel.user.observe(this) { userList ->
            binding.pbLoader.visibility = View.GONE
            binding.bgLoading.visibility = View.GONE
            this.userList.clear()
            this.userList.addAll(userList.toMutableList())
            userAdapter.setUserDetail(userList)
            userAdapter.notifyDataSetChanged()
        }

        userViewModel.updateResponseData.observe(this) { updateData->
            binding.pbLoader.visibility = View.GONE
            userList[updateData.first] = updateData.second!!
            userAdapter.setUserDetail(userList)
            userAdapter.notifyItemChanged(updateData.first)
        }

        userViewModel.createdUser.observe(this) { newUser ->
            userList.add(userList.lastIndex + 1, newUser)
            userAdapter.setUserDetail(userList)
            userAdapter.notifyItemInserted(userList.lastIndex + 1)
        }

        userViewModel.deleteUserSuccess.observe(this) { position ->
            binding.pbLoader.visibility = View.GONE
            this.userList.removeAt(position)
            userAdapter.setUserDetail(this.userList)
            userAdapter.notifyDataSetChanged()
        }

        userViewModel.searchedUsers.observe(this) { newUserList ->
            binding.pbLoader.visibility = View.GONE
            this.userList = newUserList
            userAdapter.setUserDetail(this.userList)
            userAdapter.notifyDataSetChanged()
        }

        /** Practice for okHttp
        //getDataThroughOkHttp() */

        /** Practice GetDataThrough Volley
        //getDataThroughVolley()  */
    }

    private fun searchViewPrepare() {

        binding.searchViewForRv.setOnQueryTextListener(DebouncingQueryTextListener(this.lifecycle) { newText ->

            newText?.let {
                if (it.isEmpty()) {
                    getDataThroughVolley()
                } else {
                    binding.pbLoader.visibility = View.VISIBLE
                    userViewModel.searchUser(newText)
                }
            }

        })
    }

    /** Do Practice on OkHttp API Calling
    @SuppressLint("NotifyDataSetChanged")
    private fun getDataThroughOkHttp() {
        userViewModel.getUserThroughOkHttp("student")
        userViewModel.okHttpResponse.observe(this) { userList ->
            this.userList.clear()
            this.userList.addAll(userList)
            userAdapter.setUserDetail(userList.toMutableList())
            userAdapter.notifyDataSetChanged()
        }
    }  */

    /** Do Practice on Volley API Calling */
    @SuppressLint("NotifyDataSetChanged")
    private fun getDataThroughVolley() {
        val queue = Volley.newRequestQueue(this)
        userViewModel.getDataThroughVolley(queue, "student")
        userViewModel.volleyResponse.observe(this) { userList ->
            this.userList.clear()
            this.userList.addAll(userList)
            userAdapter.setUserDetail(userList.toMutableList())
            userAdapter.notifyDataSetChanged()
        }
    }

    /** RecyclerView Prepare */
    private fun prepareRecyclerView()  {
        binding.pbLoader.visibility = View.VISIBLE
        binding.bgLoading.visibility = View.VISIBLE
        userAdapter = GetUserAdapter(this::editUser, this::deleteUser, this::seeUserDetail)
        binding.rvMovies.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(applicationContext)
        }
    }

    /*** Edit User Detail Handling  */
    private fun editUser(item: UserModel, position: Int) {
        EditUserFragment(item) { newUser ->
            binding.pbLoader.visibility = View.VISIBLE
            userViewModel.updateUser( hashMapOf(
                "id" to newUser.id,
                "createdAt" to newUser.createdAt,
                "name" to newUser.name,
                "avatar" to newUser.avatar,
                "emailId" to newUser.emailId
            ), position, item.id)
        }.show(supportFragmentManager, "Edit User")
    }

    /*** Delete User handle */
    private fun deleteUser(userId: String, position: Int) {
        binding.pbLoader.visibility = View.VISIBLE
        userViewModel.deleteUser(userId, position)
    }

    /*** Show User Profile on Click of ItemView of RecyclerView  */
    private fun seeUserDetail(id: String) {
        lifecycleScope.launch {
            userViewModel.getUserThroughHttp("student/$id")
            binding.pbLoader.visibility = View.VISIBLE
        }
        userViewModel.showUser.observeEvent(this) { userData ->
            UserProfile(userData).show(supportFragmentManager, "User Profile")
            binding.pbLoader.visibility = View.GONE
        }
    }
}