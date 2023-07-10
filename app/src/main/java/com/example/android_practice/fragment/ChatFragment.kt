package com.example.android_practice.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_practice.databinding.FragmentChatBinding
import com.example.android_practice.recycler_view.RvAdapter

class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding

    private lateinit var rvAdapter: RvAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(layoutInflater)

//        rvAdapter = container?.let { RvAdapter(Constant.getData(), it.context) }!!
//        binding.rvRestaurant.layoutManager = LinearLayoutManager(container.context)
//        binding.rvRestaurant.adapter = rvAdapter

        return binding.root
    }

}