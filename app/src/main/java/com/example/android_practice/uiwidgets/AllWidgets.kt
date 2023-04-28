package com.example.android_practice.uiwidgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import com.example.android_practice.databinding.ActivityAllWidgetsBinding

class AllWidgets : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityAllWidgetsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAllWidgetsBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        binding.btnEditText.setOnClickListener(this)
        binding.btnTextView.setOnClickListener(this)
        binding.buttonPractice.setOnClickListener(this)
        binding.btnRadioButton.setOnClickListener(this)
        binding.btnSwitch.setOnClickListener(this)
        binding.btnImageView.setOnClickListener(this)
        binding.btnChips.setOnClickListener(this)
        binding.btnSpinner.setOnClickListener(this)
        binding.btnProgress.setOnClickListener(this)
        binding.btnCalendarView.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when(v?.id) {
            binding.btnEditText.id -> {
                val intent = Intent(this,EditText::class.java)
                startActivity(intent)
            }
            binding.btnTextView.id -> {
                val intent = Intent(this, textView::class.java)
                startActivity(intent)
            }
            binding.buttonPractice.id -> {
                val intent = Intent(this, ButtonPractice::class.java)
                startActivity(intent)
            }
            binding.btnRadioButton.id -> {
                val intent = Intent(this, CheckBoxTry::class.java)
                startActivity(intent)
            }
            binding.btnSwitch.id -> {
                val intent = Intent(this, SwitchTry::class.java)
                startActivity(intent)
            }
            binding.btnImageView.id -> {
                val intent = Intent(this, ImageButton::class.java)
                startActivity(intent)
            }
            binding.btnChips.id -> {
                val intent = Intent(this, Chips::class.java)
                startActivity(intent)
            }
            binding.btnSpinner.id -> {
                val intent = Intent(this, SpinnerPractice::class.java)
                startActivity(intent)
            }
            binding.btnProgress.id -> {
                val intent = Intent(this, ProgressBarTry::class.java)
                startActivity(intent)
            }
            binding.btnCalendarView.id -> {
                val intent = Intent(this, CalendarView::class.java)
                startActivity(intent)
            }
            else -> print("Wrong")
        }
    }
}