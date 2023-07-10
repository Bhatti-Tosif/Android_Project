package com.example.android_practice.webServices.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.android_practice.databinding.FragmentDialogForMeetingBinding


class DialogFragmentForMeeting : DialogFragment() {

    private lateinit var binding: FragmentDialogForMeetingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDialogForMeetingBinding.inflate(layoutInflater)

        binding.btnCancel.setOnClickListener {
            dismiss()
        }

        binding.btnSubmit.setOnClickListener {
            val selectedRb = binding.rgCallType.checkedRadioButtonId
            val selectedRadioButton = binding.root.findViewById<RadioButton>(selectedRb)
            Toast.makeText(context, selectedRadioButton.text.toString(), Toast.LENGTH_SHORT).show()
            dismiss()
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
    }
}