package com.example.android_practice.intent_practice.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityFragmentDatapassingBinding
import com.example.android_practice.intent_practice.fragment.FragmentDataPassing1
import com.example.android_practice.intent_practice.navigationGraph.modal.ActivityDataHolder

class ActivityFragmentDataPassing : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentDatapassingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentDatapassingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSendData.setOnClickListener {
            sendData()
        }
        binding.btnSendDataToActivity.setOnClickListener {
            sendToActivity()
        }
    }

    private fun sendToActivity() {
        val user = ActivityDataHolder(binding.etFullName.text.toString())
        Intent(this, FragmentToActivityDataPass::class.java).apply {
            putExtra("name", user)
            startActivity(this)
        }
    }

    private fun sendData() {
        val result = Bundle()
        result.putString("userName", binding.etFullName.text.toString())
        supportFragmentManager.setFragmentResult("dataFromActivity", result)
        supportFragmentManager.commit {
            replace(R.id.fragment_host, FragmentDataPassing1::class.java, result)
        }
    }
}