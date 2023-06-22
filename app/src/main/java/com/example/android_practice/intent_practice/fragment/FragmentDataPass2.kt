package com.example.android_practice.intent_practice.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.example.android_practice.R
import com.example.android_practice.databinding.FragmentFragmrntDataPass2Binding

class FragmentDataPass2 : Fragment() {

    private lateinit var binding: FragmentFragmrntDataPass2Binding
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onReceivedData()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFragmrntDataPass2Binding.inflate(inflater)

        binding.btnSendBack.setOnClickListener {
            onSendData()
        }
        return binding.root
    }

    private fun onReceivedData() {
        parentFragmentManager.setFragmentResultListener(
            "dataFrom1",
            this
        ) { _, result ->
            val data = result.getString("dataFragment1")
            binding.tvReceivedData.text = data
        }
    }

    private fun onSendData() {
        val result = Bundle()
        result.putString("dataFragment2", binding.etGenerateEmail.text.toString())
        parentFragmentManager.setFragmentResult("dataFrom2", result)
        binding.etGenerateEmail.text.clear()
        parentFragmentManager.commit {
            replace(R.id.fragment_host, FragmentDataPassing1::class.java, null)
            addToBackStack("Fragment ${count++}")
        }
    }

}