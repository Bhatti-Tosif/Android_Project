package com.example.android_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android_practice.databinding.ActivityStartBinding
import com.example.android_practice.screens.BankEcLaunchScreen
import com.example.android_practice.uiwidgets.AllWidgets

class StartActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnScreens.setOnClickListener(this)
        binding.btnUiComponents.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnScreens.id -> {
                val intent = Intent(this, BankEcLaunchScreen::class.java)
                startActivity(intent)
            }

            binding.btnUiComponents.id -> {
                val intent = Intent(this, AllWidgets::class.java)
                startActivity(intent)
            }
        }
    }
}