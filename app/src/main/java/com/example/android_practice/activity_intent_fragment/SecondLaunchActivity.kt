package com.example.android_practice.activity_intent_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.example.android_practice.R
import com.example.android_practice.databinding.SecondLaunchActivityBinding

class SecondLaunchActivity : AppCompatActivity() {

    private lateinit var binding: SecondLaunchActivityBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondLaunchActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}