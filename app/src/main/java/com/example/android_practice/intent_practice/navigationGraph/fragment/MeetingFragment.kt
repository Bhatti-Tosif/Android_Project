package com.example.android_practice.intent_practice.navigationGraph.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android_practice.R
import com.example.android_practice.databinding.FragmentMeetingBinding
import com.example.android_practice.intent_practice.navigationGraph.modal.SimpleModal


class MeetingFragment : Fragment() {

    private lateinit var binding: FragmentMeetingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeetingBinding.inflate(inflater)
        binding.tvFrgMeeting.setOnClickListener {
            val action = MeetingFragmentDirections.navigateToChattingFragment(null, SimpleModal(
                String()
            ))
            findNavController().navigate(action)
        }

        binding.btnOpenDialog.setOnClickListener {
            findNavController().navigate(R.id.action_meetingFragment2_to_dialogFragmentForMeeting2)
//            val openDialog = DialogFragmentForMeeting()
//            val fm = parentFragmentManager
//            openDialog.show(fm, "Simple Dialog")
        }
        return binding.root
    }

}