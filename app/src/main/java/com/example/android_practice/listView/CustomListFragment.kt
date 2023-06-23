package com.example.android_practice.listView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_practice.R
import com.example.android_practice.databinding.FragmentCustomeListBinding
import com.example.android_practice.recycler_view.Constant

class CustomListFragment : Fragment() {

    private lateinit var binding: FragmentCustomeListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCustomeListBinding.inflate(inflater, container, false)
        val inflate = inflater.inflate(R.layout.fragment_custome_list, container, false)

        binding.simpleList.adapter = AdapterCustomList(requireContext(), Constant.getUserData())
        return binding.root
    }

}