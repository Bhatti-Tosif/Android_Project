package com.example.android_practice.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.android_practice.R

class BankECLaunchScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_bank_eclaunch_screen)
        Handler().postDelayed({
            val i = Intent(this, WelcomeScreenEC::class.java)
            startActivity(i)
            finish()
        }, 3000)
    }
}