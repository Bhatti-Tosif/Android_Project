package com.example.android_practice.intent_practice.navigationGraph.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android_practice.databinding.FragmentPrivacyBinding


class PrivacyFragment : Fragment() {

    private lateinit var binding: FragmentPrivacyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPrivacyBinding.inflate(inflater)
        binding.tvPrivacy.setOnClickListener {
            val action = PrivacyFragmentDirections.actionGlobalUnSecureFragment2()
            findNavController().navigate(action)
        }
        return binding.root
    }

}