package com.example.android_practice.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.android_practice.R
import com.example.android_practice.adapter.AdapterForBottomNavigation
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

        val fragmentAdapter = AdapterForBottomNavigation(this, binding.bottomNavigation.menu.size())
        binding.viewPager2ForFragment.adapter = fragmentAdapter

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home ->  {
                    binding.viewPager2ForFragment.currentItem = 0
                    it.isChecked = true
                }
                R.id.download -> {
                    binding.viewPager2ForFragment.currentItem = 1
                    it.isChecked = true
                }
                R.id.profile -> {
                    binding.viewPager2ForFragment.currentItem = 2
                    it.isChecked = true
                }
            }
            return@setOnItemSelectedListener false
        }

        binding.viewPager2ForFragment.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
               binding.bottomNavigation.menu[position].isChecked = true
            }

        })
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()

    }
}