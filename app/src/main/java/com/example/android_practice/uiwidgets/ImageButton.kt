package com.example.android_practice.uiwidgets

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android_practice.databinding.ActivityImageButtonBinding

class ImageButton : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityImageButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityImageButtonBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.imageButton.setOnClickListener(this)
        binding.imageViewScaleType.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {

        when(v?.id) {
            binding.imageButton.id -> {
                binding.txtForImageButton.text = "Image Button tapped"
            }
            binding.imageViewScaleType.id -> {
                binding.textViewScale.text = "ImageView Tapped"
            }
        }
    }
}