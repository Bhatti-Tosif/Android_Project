package com.example.android_practice.webServices.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.android_practice.R
import com.example.android_practice.databinding.FragmentVideoChatBinding

class VideoChatFragment : Fragment() {

    private lateinit var binding: FragmentVideoChatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVideoChatBinding.inflate(layoutInflater)
        binding.btnNext.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_videoChatFragment_to_descriptionFragment)
        }
        return binding.root
    }
}