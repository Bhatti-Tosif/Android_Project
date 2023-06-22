package com.example.android_practice.intent_practice.navigationGraph.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice.databinding.ActivityPrivacyPolicyChangeBinding

class PrivacyPolicyChange : AppCompatActivity() {

    private lateinit var binding: ActivityPrivacyPolicyChangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrivacyPolicyChangeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}