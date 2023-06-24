package com.example.android_practice.webServices.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.android_practice.databinding.FragmentUserProfileBinding
import com.example.android_practice.webServices.model.UserModel

class UserProfile(private val userData: UserModel) : DialogFragment() {

    private lateinit var binding: FragmentUserProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentUserProfileBinding.inflate(inflater)

        setData()
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
    }

    private fun setData() {
        context?.let { Glide.with(it).load(userData.avatar).into(binding.ivUserPic) }
        binding.tvName.text = userData.name
        binding.tvEmailId.text = userData.emailId
    }
}