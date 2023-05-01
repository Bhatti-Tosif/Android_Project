package com.example.android_practice.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.android_practice.R

class BankEcLaunchScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_bank_ec_launch_screen)
        Handler().postDelayed({
            val i = Intent(this, BankWelcomeScreen::class.java)
            startActivity(i)
            finish()
        }, 500)
    }
}