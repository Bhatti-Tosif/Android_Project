package com.example.android_practice.activity_intent_fragment.intent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice.R
import com.example.android_practice.activity_intent_fragment.ActivityLifeCyclePractice
import com.example.android_practice.databinding.ActivityExplicitIntentBinding

class ExplicitIntent : AppCompatActivity() {

    private lateinit var binding: ActivityExplicitIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExplicitIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnExplicit.setOnClickListener {
            val intent = Intent(this, ExplicitIntentDataPassing::class.java)
            startActivity(intent)
        }

        binding.btnImplicit.setOnClickListener {
            val intent = Intent(this, ImplicitIntentType::class.java)
            startActivity(intent)
        }
    }
}