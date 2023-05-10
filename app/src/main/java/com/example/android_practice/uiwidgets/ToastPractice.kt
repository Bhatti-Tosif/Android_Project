package com.example.android_practice.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityToastPracticeBinding

class ToastPractice : AppCompatActivity() {

    private lateinit var binding: ActivityToastPracticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToastPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSimpleToast.setOnClickListener {
            Toast.makeText(this, "Simple Toast", Toast.LENGTH_SHORT).show()
        }

        binding.btnCenterToast.setOnClickListener {
            val toast = Toast.makeText(this, "Center Toast", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER_HORIZONTAL,0, 0)
            toast.show()
        }

        binding.btnCustomToast.setOnClickListener {
            val view = LayoutInflater.from(layoutInflater.context).inflate(R.layout.custom_toast, findViewById(R.id.customToastContainer))
            val toast = Toast.makeText(this, "Custom Toast", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER_HORIZONTAL,20,20)
            toast.view = view
            toast.show()
        }
    }
}