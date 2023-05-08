package com.example.android_practice.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivityBottomNavigationPracticeBinding
import com.example.android_practice.fragment.BottomDownloadFragment
import com.example.android_practice.fragment.BottomHomeFragment
import com.example.android_practice.fragment.BottomProfileFragment

class BottomNavigationPractice : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavigationPracticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavigationPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(BottomHomeFragment())

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> replaceFragment(BottomHomeFragment())
                R.id.download -> replaceFragment(BottomDownloadFragment())
                R.id.profile -> replaceFragment(BottomProfileFragment())
            }

            return@setOnItemSelectedListener false
        }
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()

    }
}