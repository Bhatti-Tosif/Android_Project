package com.example.android_practice.screens

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityBankSignInScreenBinding
import com.example.android_practice.databinding.ActivityBankWelcomeScreenBinding

class BankSignInScreen : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityBankSignInScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBankSignInScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvSignUp.setOnClickListener(this)
        binding.btnSignInAccount.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.tvSignUp.id -> {
                val intent = Intent(this, BankWelcomeScreen::class.java)
                startActivity(intent)
            }
            binding.btnSignInAccount.id -> {
                val intent = Intent(this, SummaryScreen::class.java)
                startActivity(intent)
            }
        }
    }
}