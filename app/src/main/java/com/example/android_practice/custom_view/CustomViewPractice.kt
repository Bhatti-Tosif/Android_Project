package com.example.android_practice.custom_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityCustomViewPracticeBinding

class CustomViewPractice : AppCompatActivity() {

    private lateinit var binding: ActivityCustomViewPracticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomViewPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setButton()
        binding.customView.setOnClickListener {
            binding.customView.setBackgroundResource(R.drawable.empty_button_stroke)
            binding.customView.showLoader()
            Handler().postDelayed({
                binding.customView.setText("SUCCESS")
                binding.customView.hideLoader()
                binding.customView.setBackgroundResource(R.drawable.bt_enable_bg)
            }, 5000)

        }
    }

    private fun setButton() {
        binding.customView.setBackgroundResource(R.drawable.empty_button_stroke)
        binding.customView.hideLoader()
    }
}