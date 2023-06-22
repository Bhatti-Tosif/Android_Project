package com.example.android_practice.webServices.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.android_practice.R
import com.example.android_practice.databinding.FragmentDiscriptionBinding

class DescriptionFragment : Fragment() {

    private lateinit var binding: FragmentDiscriptionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDiscriptionBinding.inflate(layoutInflater)

        binding.btnFirst.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_descriptionFragment_to_meetingFragment2)
        }
        return binding.root
    }

}