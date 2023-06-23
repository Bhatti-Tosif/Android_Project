package com.example.android_practice.intent_practice.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityFragmentChangerBinding
import com.example.android_practice.intent_practice.fragment.LeftDataHoldFragment
import com.example.android_practice.intent_practice.fragment.RightDataHoldFragment

class FragmentChangerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentChangerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentChangerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFragment1.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, LeftDataHoldFragment::class.java, null, "LeftDataHoldFragment")
                addToBackStack("LeftDataHoldFragment")
            }
            Log.d("LeftData", supportFragmentManager.backStackEntryCount.toString())
        }
        binding.btnFragment2.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, RightDataHoldFragment::class.java, null, "RightDataHoldFragment")
                addToBackStack("RightDataHoldFragment")
            }
            Log.d("Right Data", supportFragmentManager.backStackEntryCount.toString())
        }

    }
}