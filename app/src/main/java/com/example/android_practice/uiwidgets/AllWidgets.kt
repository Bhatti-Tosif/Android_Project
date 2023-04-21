package com.example.android_practice.uiwidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityAllWidgetsBinding

class AllWidgets : AppCompatActivity(), View.OnClickListener {

    private var _binding: ActivityAllWidgetsBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityAllWidgetsBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        binding.btnEditText.setOnClickListener(this)
        binding.btnTextView.setOnClickListener(this)
        binding.buttonPractice.setOnClickListener(this)

    }
    override fun onClick(v: View?) {
        when(v?.id) {
            binding.btnEditText.id -> {
                val intent = Intent(this,EditText::class.java)
                startActivity(intent)
            }
            binding.btnTextView.id -> {
                val intent = Intent(this, textView::class.java)
                startActivity(intent)
            }
            binding.buttonPractice.id -> {
                val intent = Intent(this, ButtonPractice::class.java)
                startActivity(intent)
            }
            else -> print("hello")
        }
    }
}