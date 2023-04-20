package com.example.android_practice.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityButtonPracticeBinding

class ButtonPractice : AppCompatActivity() {
    private var _binding: ActivityButtonPracticeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityButtonPracticeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
}