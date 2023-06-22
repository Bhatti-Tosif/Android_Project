package com.example.android_practice.webServices.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.android_practice.R
import com.example.android_practice.databinding.FragmentChatingBinding

class ChattingFragment : Fragment() {

    private lateinit var binding: FragmentChatingBinding

    private val args: ChattingFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentChatingBinding.inflate(inflater)

        val data = args.fragmentName
        val name = args.nameOf
        if (data == null || name == null) {
            binding.tvFrgChatting.text = "No Data Are there"
        } else {
            binding.tvFrgChatting.text = data
        }

        binding.tvFrgChatting.setOnClickListener {
            findNavController().navigate(R.id.navigateToMeetingFragment)
        }

        binding.btnBottomSheet.setOnClickListener {
            findNavController().navigate(R.id.action_chattingFragment_to_bottomSheetDialogFragmentPractice)
        }

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_chattingFragment_to_musicFragment)
        }
        return binding.root
    }

}