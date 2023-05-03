package com.example.android_practice.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android_practice.R
import com.google.android.material.appbar.MaterialToolbar

class TopAppBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_app_bar)

//        val materialToolBar: MaterialToolbar = findViewById(R.id.material_toolBar)
//
//        materialToolBar.setOnMenuItemClickListener {
//            when(it.itemId) {
//                R.id.favorite -> {
//                    Toast.makeText(this, "Favorite Clicked", Toast.LENGTH_SHORT).show()
//                    true
//                }
//                R.id.search -> {
//                    Toast.makeText(this,"Search Clicked", Toast.LENGTH_SHORT).show()
//                    true
//                }
//                else -> false
//            }
//        }
    }
}