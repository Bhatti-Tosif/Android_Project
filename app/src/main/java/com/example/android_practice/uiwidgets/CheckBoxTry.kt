package com.example.android_practice.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.RadioButton
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityCheckBoxBinding

class CheckBoxTry : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCheckBoxBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCheckBoxBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnOrder.setOnClickListener(this)

    }

    fun onRadioButtonClick(view: View) {
        if (view is RadioButton) {
           val checked = view.isChecked

            when (view.id) {
                binding.rbPizza.id -> {
                    if (checked) {
                        binding.txtselectedRb.text = binding.rbPizza.text
                    }
                }
                binding.rbBurger.id -> {
                    if (checked)
                        binding.txtselectedRb.text = binding.rbBurger.text
                }
                binding.rbSandwich.id -> {
                    if (checked)
                        binding.txtselectedRb.text = binding.rbSandwich.text
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.btnOrder.id -> {
                val orderString = "Your Extra order is: " +
                        (if(binding.cbCheese.isChecked) "\ncheese" else "") +
                        (if(binding.cbOnion.isChecked) "\nonion" else "") +
                        (if(binding.cbSalad.isChecked) "\nsalad" else "")
                binding.txtAllOrder.text = orderString
            }
        }
    }
}