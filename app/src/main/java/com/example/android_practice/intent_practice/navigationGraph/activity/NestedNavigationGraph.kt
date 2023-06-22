package com.example.android_practice.intent_practice.navigationGraph.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice.databinding.ActivityNestedNavigationGraphBinding

class NestedNavigationGraph : AppCompatActivity() {

    private lateinit var binding: ActivityNestedNavigationGraphBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNestedNavigationGraphBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAcceptPrivacy.setOnClickListener {
            Intent(this, PrivacyPolicyChange::class.java).apply {
                putExtra("privacyResult", true)
                startActivity(this)
            }
        }
        binding.btnDeniedPrivacy.setOnClickListener {
            Intent(this, PrivacyPolicyChange::class.java).apply {
                putExtra("privacyResult", false)
                startActivity(this)
            }
        }
        binding.btnNestedGraph.setOnClickListener {

        }
    }
}