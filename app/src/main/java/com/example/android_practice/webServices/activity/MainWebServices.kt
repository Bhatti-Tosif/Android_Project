package com.example.android_practice.webServices.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android_practice.databinding.ActivityMainWebServicesBinding

class MainWebServices : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainWebServicesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainWebServicesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUserDetail.setOnClickListener(this)
        binding.btnMovieDetail.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnUserDetail.id -> {
                val intent = Intent(this, GetUserDetailActivity::class.java)
                startActivity(intent)
            }
            binding.btnMovieDetail.id -> {
                val intent = Intent(this, PopularMovies::class.java)
                startActivity(intent)
            }
        }
    }
}