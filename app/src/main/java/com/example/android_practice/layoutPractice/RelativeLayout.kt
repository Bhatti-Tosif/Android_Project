package com.example.android_practice.layoutPractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice.databinding.ActivityRelativeLayoutBinding

class RelativeLayout : AppCompatActivity() {

    private var _binding: ActivityRelativeLayoutBinding? = null
    private  val  binding  get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityRelativeLayoutBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        binding.signUp.setOnClickListener {
            var intent = Intent(this, ConstraintLayout::class.java)
            startActivity(intent)
        }

    }
}