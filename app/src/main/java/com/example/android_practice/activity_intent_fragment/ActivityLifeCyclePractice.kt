package com.example.android_practice.activity_intent_fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.android_practice.R
import com.example.android_practice.activity_intent_fragment.intent.ExplicitIntent
import com.example.android_practice.databinding.ActivityLifeCyclePracticeBinding

class ActivityLifeCyclePractice : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLifeCyclePracticeBinding

    companion object {
        private const val TAG = "Main Activity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate")

        binding = ActivityLifeCyclePracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnActivityLifecycle.setOnClickListener(this)
        binding.btnIntent.setOnClickListener(this)
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_activity_lifecycle -> {
                val intent = Intent(this, SecondLaunchActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_intent -> {
                val intent = Intent(this, ExplicitIntent::class.java)
                startActivity(intent)
            }
        }
    }
}