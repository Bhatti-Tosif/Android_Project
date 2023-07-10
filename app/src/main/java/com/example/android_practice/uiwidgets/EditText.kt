package com.example.android_practice.uiwidgets

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
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

        //PasswordSetCall
        passwordSet()
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when(v?.id) {
            binding.checkedTextView.id -> {
                if(binding.checkedTextView.isChecked) {
                    binding.checkedTextView.text = "Checked"
                    binding.checkedTextView.isChecked = false
                    binding.checkedTextView.setCheckMarkDrawable(R.drawable.heart_shape)
                } else {
                    binding.checkedTextView.text = "UnChecked"
                    binding.checkedTextView.isChecked = true
                    binding.checkedTextView.checkMarkDrawable = null
                }
            }
        }
    }
    private fun passwordSet() {
//        binding.passwordError.setEndIconOnClickListener() {
//            print("end Icone Click")
//        }
        binding.passwordTextEditText.doOnTextChanged { text, start, before, count ->
            if(text!!.length > 12) {
                binding.passwordError.error = "Too Long"
            } else if (text!!.length < 10) {
                binding.passwordError.error = null
            }
        }

    }
}