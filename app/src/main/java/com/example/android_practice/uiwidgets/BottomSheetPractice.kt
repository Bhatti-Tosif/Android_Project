package com.example.android_practice.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_practice.databinding.ActivityBottomSheetpracticeBinding
import com.example.android_practice.fragment.BottomSheetFragment

class BottomSheetPractice : AppCompatActivity() {

    private lateinit var binding: ActivityBottomSheetpracticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomSheetpracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOpenBottomSheet.setOnClickListener {
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)

        }
    }
}