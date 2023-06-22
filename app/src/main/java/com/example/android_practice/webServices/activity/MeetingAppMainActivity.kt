package com.example.android_practice.webServices.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityMeetingAppMainBinding

class MeetingAppMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMeetingAppMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMeetingAppMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = findNavController(R.id.fragmentContainerView)
        binding.bottomNavBar.setupWithNavController(navController)

    }
}