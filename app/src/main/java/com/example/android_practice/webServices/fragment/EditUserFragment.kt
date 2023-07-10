package com.example.android_practice.webServices.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_practice.databinding.FragmentEditUserBinding
import com.example.android_practice.webServices.model.UserModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class EditUserFragment(private val userDetail: UserModel, private val updateClick: (UserModel) -> Unit) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentEditUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentEditUserBinding.inflate(inflater)

        binding.etName.editText?.setText(userDetail.name)
        binding.etEmail.editText?.setText(userDetail.emailId)

        binding.btnDismiss.setOnClickListener {
            this.dismiss()
        }

        binding.btnUpdateUser.setOnClickListener {
            val user = UserModel(userDetail.createdAt, name = binding.etUserName.text.toString(), userDetail.avatar ,
                emailId = binding.etEmailID.text.toString(), userDetail.id)
            updateClick(user)
            dismiss()
        }

        return binding.root
    }
}