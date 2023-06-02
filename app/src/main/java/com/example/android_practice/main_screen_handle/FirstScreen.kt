package com.example.android_practice.main_screen_handle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_practice.databinding.ActivityFirstScreenBinding

class FirstScreen : AppCompatActivity() {

    private lateinit var binding: ActivityFirstScreenBinding
    private lateinit var buttonAdapter: FirstScreenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        buttonAdapter = FirstScreenAdapter(ButtonList.getButtonList())
        binding.rvButtonList.layoutManager = LinearLayoutManager(this)
        binding.rvButtonList.adapter = buttonAdapter

    }
}