package com.example.android_practice.uiwidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityAllWidgetsBinding

class AllWidgets : AppCompatActivity() {

    private var _binding: ActivityAllWidgetsBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityAllWidgetsBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        binding.btnTextView.setOnClickListener {
            val intent = Intent(this, textView::class.java)
            startActivity(intent)
        }

        binding.buttonPractice.setOnClickListener {
            val intent = Intent(this, ButtonPractice::class.java)
            startActivity(intent)
        }

    }
}