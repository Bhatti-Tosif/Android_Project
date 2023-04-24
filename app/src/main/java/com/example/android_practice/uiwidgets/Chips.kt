package com.example.android_practice.uiwidgets

import android.content.res.ColorStateList
import android.graphics.Color
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityChipsBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable

class Chips : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityChipsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChipsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.actionChip.setOnCloseIconClickListener(this)
        binding.defaultChip.setOnCloseIconClickListener(this)

        binding.iconChip.setOnCloseIconClickListener {
            binding.iconChip.visibility = View.GONE
        }

        binding.typeofChipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            when(checkedIds) {
                binding.defaultChip -> {
                    binding.defaultChip.chipBackgroundColor
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            binding.defaultChip.id -> {
                binding.defaultChip.setBackgroundColor(Color.BLACK)
            }
        }
    }
}