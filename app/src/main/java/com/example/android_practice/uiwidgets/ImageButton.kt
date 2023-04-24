package com.example.android_practice.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.ViewUtils
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityImageButtonBinding
import com.example.android_practice.databinding.ActivitySwitchTryBinding

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