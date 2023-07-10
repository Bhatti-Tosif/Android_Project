package com.example.android_practice.intent_practice.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice.databinding.ActivityIntentFilterPracticeBinding

class IntentFilterPractice : AppCompatActivity() {

    private lateinit var binding: ActivityIntentFilterPracticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentFilterPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataThroughImplicitIntent()

        binding.btnSendText.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra("text", binding.etSendText.text.toString())
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Choose msg App"))
        }

        receiveData()
        binding.btnSetWallpaper.setOnClickListener {
            onSetWallpaper()
        }
    }

    private fun receiveData() {
        val data = intent.extras?.getString("text")
        binding.tvReceive.text = data
    }

    private fun getDataThroughImplicitIntent() {
        val intent = intent
        val data = intent.getStringExtra("text")
        binding.tvDataReceiver.text = data
    }

    private fun onSetWallpaper() {
        val intent = Intent(Intent.ACTION_SET_WALLPAPER)
        startActivity(intent)
    }
}