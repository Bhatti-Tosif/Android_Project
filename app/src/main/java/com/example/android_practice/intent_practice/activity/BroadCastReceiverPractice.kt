package com.example.android_practice.intent_practice.activity

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android_practice.databinding.ActivityBroadCastRecieverPracticeBinding

class BroadCastReceiverPractice : AppCompatActivity() {

    private lateinit var binding: ActivityBroadCastRecieverPracticeBinding

    private lateinit var receiver: AirPlaneChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBroadCastRecieverPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        receiver = AirPlaneChangeReceiver()

        binding.btnBroadCast.setOnClickListener {
            IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
                Toast.makeText(this, "Register Receiver", Toast.LENGTH_SHORT).show()
                registerReceiver(receiver,it)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}