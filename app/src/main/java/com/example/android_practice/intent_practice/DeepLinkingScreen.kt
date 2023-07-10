package com.example.android_practice.intent_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice.databinding.ActivityDeepLinkingScreenBinding

class DeepLinkingScreen : AppCompatActivity() {

    private lateinit var binding: ActivityDeepLinkingScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeepLinkingScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val uri = intent.data
        if(uri != null) {
            binding.tvUriPath.text = uri.toString()
        }
    }
}