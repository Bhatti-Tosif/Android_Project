package com.example.android_practice.webServices.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.android_practice.databinding.FragmentBottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetDialogFragmentPractice : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetDialogBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentBottomSheetDialogBinding.inflate(layoutInflater)

        binding.tvForward.setOnClickListener {
            Toast.makeText(context, "Forwarded", Toast.LENGTH_SHORT).show()
        }
        binding.tvReply.setOnClickListener {
            Toast.makeText(context, "Replied", Toast.LENGTH_SHORT).show()
        }
        binding.tvReplyToAll.setOnClickListener {
            Toast.makeText(context, "Reply to All", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}