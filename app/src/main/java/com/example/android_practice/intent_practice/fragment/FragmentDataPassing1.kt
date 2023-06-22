package com.example.android_practice.intent_practice.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.example.android_practice.R
import com.example.android_practice.databinding.FragmentDataPassing1Binding
import com.example.android_practice.intent_practice.activity.FragmentToActivityDataPass

class FragmentDataPassing1 : Fragment() {

    private lateinit var binding: FragmentDataPassing1Binding
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onReceiveFromActivity()
        onReceivedData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDataPassing1Binding.inflate(inflater)

        binding.btnSendData.setOnClickListener {
            onSendData()
        }

        binding.btnSendDataToActivity.setOnClickListener {
            onSendToActivityClick()
        }
        return binding.root
    }
    private fun onReceivedData() {
        parentFragmentManager.setFragmentResultListener("dataFrom2", this) { _, result ->
            val data = result.getString("dataFragment2")
            binding.tvReceivedData.text = data
        }
    }

    private fun onReceiveFromActivity() {
        parentFragmentManager.setFragmentResultListener("dataFromActivity", this) { _, result ->
            val message = result.getString("userName")
            binding.tvReceivedData.text = message
        }
    }
    private fun onSendData() {
        val result = Bundle()
        result.putString("dataFragment1", binding.etFullName.text.toString())
        parentFragmentManager.setFragmentResult("dataFrom1", result)
        binding.etFullName.text.clear()
        parentFragmentManager.commit {
            replace(R.id.fragment_host, FragmentDataPass2::class.java, null)
            addToBackStack("Fragment ${count++}")
        }
    }

    private fun onSendToActivityClick() {
        val intent = Intent(activity, FragmentToActivityDataPass::class.java)
        intent.putExtra("userName", binding.etFullName.text.toString())
        startActivity(intent)
    }
}