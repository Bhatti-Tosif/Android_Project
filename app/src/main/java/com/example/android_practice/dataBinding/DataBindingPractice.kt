package com.example.android_practice.dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityDataBindingPracticeBinding

class DataBindingPractice : AppCompatActivity() {

    private lateinit var binding: ActivityDataBindingPracticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_practice)

        binding.user = "tosif"
    }
}