package com.example.android_practice.layoutPractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityCoordinatorlayoutBinding
import com.google.android.material.snackbar.Snackbar

class CoordinatorLayout : AppCompatActivity() {

    private lateinit var binding: ActivityCoordinatorlayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCoordinatorlayoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.fabLock.setOnClickListener {
            Snackbar.make(view, "Coordinator Layout", Snackbar.LENGTH_SHORT).show()
        }
    }
}