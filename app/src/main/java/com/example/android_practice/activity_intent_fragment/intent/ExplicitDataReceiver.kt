package com.example.android_practice.activity_intent_fragment.intent

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityExplicitDataReceiverBinding

class ExplicitDataReceiver : AppCompatActivity() {

    private lateinit var binding: ActivityExplicitDataReceiverBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExplicitDataReceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameOfUser: String? = intent.getStringExtra("name")
        val surnameOfUser: String? = intent.getStringExtra("surname")
        binding.tvReceiveDataPrevious.text = "${nameOfUser} , ${surnameOfUser}"

        binding.btnSendBack.setOnClickListener {
            val userName = "${nameOfUser}${surnameOfUser}@gmail.com"
            val resultIntent = Intent()
            resultIntent.putExtra("result", userName)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}