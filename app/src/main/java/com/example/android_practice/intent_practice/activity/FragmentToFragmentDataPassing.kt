package com.example.android_practice.intent_practice.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityFragmentToFragmentDataPassingBinding
import com.example.android_practice.intent_practice.fragment.FragmentDataPass2
import com.example.android_practice.intent_practice.fragment.FragmentDataPassing1

class FragmentToFragmentDataPassing : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentToFragmentDataPassingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentToFragmentDataPassingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace(R.id.fragment_host, FragmentDataPassing1::class.java, null)
        }
        binding.btnFragment1.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragment_host, FragmentDataPassing1::class.java, null)
            }
        }
        binding.btnFragment2.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragment_host, FragmentDataPass2::class.java, null)
            }
        }

    }
}