package com.example.android_practice.intent_practice.navigationGraph.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.android_practice.R
import com.example.android_practice.databinding.FragmentMusicBinding


class MusicFragment : Fragment() {

    private lateinit var binding: FragmentMusicBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicBinding.inflate(layoutInflater)
        binding.btnNext.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_musicFragment_to_videoChatFragment)
        }
        binding.tvFrgChatting.setOnClickListener {
            val navGraph = binding.root.findNavController().navInflater.inflate(R.navigation.nav_unsecure_graph)
//            val destination = navGraph.startDestinationId
//            navGraph.setStartDestination(destination)
            binding.root.findNavController().graph = navGraph
        }
        return binding.root
    }
}