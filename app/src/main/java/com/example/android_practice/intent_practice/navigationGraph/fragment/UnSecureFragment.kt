package com.example.android_practice.intent_practice.navigationGraph.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.android_practice.R
import com.example.android_practice.databinding.FragmentUnSecureBinding

class UnSecureFragment : Fragment() {

    private lateinit var binding: FragmentUnSecureBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUnSecureBinding.inflate(inflater)
        binding.tvUnSecure.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_unSecureFragment2_to_bottom_nav_graph)
        }
        return binding.root
    }

}