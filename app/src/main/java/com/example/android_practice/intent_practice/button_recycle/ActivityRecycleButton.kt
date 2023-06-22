package com.example.android_practice.intent_practice.button_recycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.android_practice.databinding.ActivityRecycleButtonBinding

class ActivityRecycleButton : AppCompatActivity() {

    private lateinit var binding: ActivityRecycleButtonBinding

    private lateinit var adapter: ButtonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycleButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ButtonAdapter(Helper.getButtonData())
        binding.rvButton.adapter = adapter
    }


    override fun onStop() {
        super.onStop()
        Log.d("Main", "onStop: Main")
    }
}