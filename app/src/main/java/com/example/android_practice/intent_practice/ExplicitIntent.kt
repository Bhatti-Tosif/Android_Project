package com.example.android_practice.intent_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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