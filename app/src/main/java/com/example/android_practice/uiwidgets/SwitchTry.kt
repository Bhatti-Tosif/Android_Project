package com.example.android_practice.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivitySwitchTryBinding

class SwitchTry : AppCompatActivity() {
    private lateinit var binding: ActivitySwitchTryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwitchTryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.customSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.editTextNumber.isEnabled = !isChecked
        }

    }
}