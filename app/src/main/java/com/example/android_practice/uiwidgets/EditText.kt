package com.example.android_practice.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityEditTextBinding

class EditText : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityEditTextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditTextBinding.inflate(layoutInflater)
        val  view = binding.root
        setContentView(view)

        binding.checkedTextView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.checkedTextView.id -> {
                if(binding.checkedTextView.isChecked) {
                    binding.checkedTextView.text = "Checked"
                    binding.checkedTextView.setChecked(false)
                    binding.checkedTextView.setCheckMarkDrawable(R.drawable.heart_shape)
                } else {
                    binding.checkedTextView.text = "UnChecked"
                    binding.checkedTextView.setChecked(true)
                    binding.checkedTextView.setCheckMarkDrawable(null)
                }
            }
        }
    }
}