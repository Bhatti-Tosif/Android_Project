package com.example.android_practice.screens

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityBankWelcomeScreenBinding
import com.example.android_practice.databinding.ActivityStartBinding

class BankWelcomeScreen : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityBankWelcomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBankWelcomeScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnSignInAccount.setOnClickListener(this)
        binding.tvSignIn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnSignInAccount.id -> {
                val intent = Intent(this, BankSignInScreen::class.java)
                startActivity(intent)
            }

            binding.tvSignIn.id -> {
                val intent = Intent(this, BankSignInScreen::class.java)
                startActivity(intent)
            }
        }
    }
}