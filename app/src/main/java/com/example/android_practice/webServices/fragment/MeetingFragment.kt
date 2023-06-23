package com.example.android_practice.webServices.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.Volley
import com.example.android_practice.databinding.FragmentMeetingBinding
import com.example.android_practice.webServices.Utils.AppConstant
import com.example.android_practice.webServices.Utils.DebouncingQueryTextListener
import com.example.android_practice.webServices.Utils.observeEvent
import com.example.android_practice.webServices.adapter.GetUserAdapter
import com.example.android_practice.webServices.factory.UserViewModelFactory
import com.example.android_practice.webServices.model.UserModel
import com.example.android_practice.webServices.viewModel.UserViewModel
import kotlinx.coroutines.launch


class MeetingFragment : Fragment() {

    /** Properties declaration*/
    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: GetUserAdapter
    private var userList = mutableListOf<UserModel>()
    private lateinit var binding: FragmentMeetingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeetingBinding.inflate(inflater)


        userViewModel = ViewModelProvider(this, UserViewModelFactory(AppConstant.userRepository))[UserViewModel::class.java]

        prepareRecyclerView()
        binding.fabAddUser.setOnClickListener {
            AddUserFragment().show(childFragmentManager, "ADD")
        }

        searchViewPrepare()

        observer()

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observer() {

        userViewModel.user.observe(viewLifecycleOwner) { userList ->
            binding.pbLoader.visibility = View.GONE
            binding.bgLoading.visibility = View.GONE
            this.userList.clear()
            this.userList.addAll(userList.toMutableList())
            userAdapter.setUserDetail(userList)
            userAdapter.notifyDataSetChanged()
        }

        userViewModel.updateResponseData.observe(viewLifecycleOwner) { updateData->
            binding.pbLoader.visibility = View.GONE
            userList[updateData.first] = updateData.second!!
            userAdapter.setUserDetail(userList)
            userAdapter.notifyItemChanged(updateData.first)
        }

        userViewModel.createdUser.observe(viewLifecycleOwner) { newUser ->
            userList.add(userList.lastIndex + 1, newUser)
            userAdapter.setUserDetail(userList)
            userAdapter.notifyItemInserted(userList.lastIndex + 1)
        }

        userViewModel.deleteUserSuccess.observe(viewLifecycleOwner) { position ->
            binding.pbLoader.visibility = View.GONE
            this.userList.removeAt(position)
            userAdapter.setUserDetail(this.userList)
            userAdapter.notifyDataSetChanged()
        }

        userViewModel.searchedUsers.observe(viewLifecycleOwner) { newUserList ->
            binding.pbLoader.visibility = View.GONE
            this.userList = newUserList
            userAdapter.setUserDetail(this.userList)
            userAdapter.notifyDataSetChanged()
        }

        userViewModel.showUser.observeEvent(viewLifecycleOwner) { userData ->
            UserProfile(userData).show(childFragmentManager, "User Profile")
            binding.pbLoader.visibility = View.GONE
        }

        userViewModel.volleyResponse.observe(viewLifecycleOwner) { userList ->
            this.userList.clear()
            this.userList.addAll(userList)
            userAdapter.setUserDetail(userList.toMutableList())
            userAdapter.notifyDataSetChanged()
        }

        userViewModel.okHttpResponse.observe(viewLifecycleOwner) { userList ->
            this.userList.clear()
            this.userList.addAll(userList)
            userAdapter.setUserDetail(userList.toMutableList())
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
    }  */

    /** Do Practice on Volley API Calling */
    @SuppressLint("NotifyDataSetChanged")
    private fun getDataThroughVolley() {
        val queue = Volley.newRequestQueue(context)
        userViewModel.getDataThroughVolley(queue, "student")
    }

    /** RecyclerView Prepare */
    private fun prepareRecyclerView()  {
        binding.pbLoader.visibility = View.VISIBLE
        binding.bgLoading.visibility = View.VISIBLE
        userAdapter = GetUserAdapter(this::editUser, this::deleteUser, this::seeUserDetail)
        binding.rvMovies.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(context)
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
        }.show(childFragmentManager, "Edit User")
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
    }

}