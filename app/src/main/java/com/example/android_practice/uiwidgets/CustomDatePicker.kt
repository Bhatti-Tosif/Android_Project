package com.example.android_practice.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityCustomDatePickerBinding

class CustomDatePicker : AppCompatActivity() {

    private lateinit var binding: ActivityCustomDatePickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCustomDatePickerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}