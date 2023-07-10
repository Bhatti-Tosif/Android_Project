package com.example.android_practice.intent_practice.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.example.android_practice.databinding.ActivityImplicitIntentPracticeBinding
import com.example.android_practice.screens.BankWelcomeScreen

class ImplicitIntentPractice : AppCompatActivity() {

    private lateinit var binding: ActivityImplicitIntentPracticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImplicitIntentPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOpenImage.setOnClickListener {
            imageChooser()
        }
        binding.btnPickVideo.setOnClickListener {
            videoChooser()
        }
        binding.btnCallDial.setOnClickListener {
            openDial()
        }
        binding.btnSendMsg.setOnClickListener {
            openSms()
        }
        binding.btnOpenMap.setOnClickListener {
            openMap()
        }

        getNotification()
    }

    private fun getNotification() {
        if (intent.extras?.getBoolean("from_notification") == true) {
            Intent(this, BankWelcomeScreen::class.java).apply {
                startActivity(this)
            }
        }
    }

    private fun imageChooser() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        getContent.launch("image/*")
    }

    private fun videoChooser() {
        val intent = Intent()
        intent.type = "video/*"
        intent.action = Intent.ACTION_PICK
        takeVideo.launch(intent)
    }

    private fun openDial() {
        val intent = Intent()
        intent.action = Intent.ACTION_DIAL
        intent.data = Uri.parse("tel:" + binding.etNumber.text.toString())
        startActivity(intent)
    }

    private fun openSms() {
        val uri = Uri.parse("smsto:" + binding.etSmsTo.text.toString())
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra("sms_body", binding.etSmsMsg.text.toString())
        startActivity(intent)
    }
    @SuppressLint("QueryPermissionsNeeded")
    private fun openMap() {
        val gmmIntentUri = Uri.parse("geo:23.028140337846654,72.49925695668618")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }

    private val takeVideo =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data

                if (data == null) {
                    Log.d("TAG", "Video Data is null")
                    return@registerForActivityResult
                }

                val videoUri = data.data
                binding.videoPicker.setVideoURI(videoUri)
                binding.videoPicker.start()
            }

        }
    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) {
        binding.ivPickImage.setImageURI(it)
    }
}