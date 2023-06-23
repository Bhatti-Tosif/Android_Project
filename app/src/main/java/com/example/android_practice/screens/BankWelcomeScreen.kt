package com.example.android_practice.screens

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.android_practice.databinding.ActivityBankWelcomeScreenBinding


class BankWelcomeScreen : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityBankWelcomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBankWelcomeScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnSignInAccount.setOnClickListener(this)
        binding.tvSignIn.setOnClickListener(this)
        closeKeyBoard()

        if (!binding.etEmailAddress.hasFocus()) {
            closeKeyBoard()
        }
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

    private fun closeKeyBoard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}