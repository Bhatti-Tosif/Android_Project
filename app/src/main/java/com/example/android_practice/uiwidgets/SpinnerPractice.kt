package com.example.android_practice.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.android_practice.R
import com.example.android_practice.databinding.ActivitySpinnerPracticeBinding

class SpinnerPractice : AppCompatActivity() {

    private lateinit var binding: ActivitySpinnerPracticeBinding

    var players = arrayListOf("Ms Dhoni", "Kohali", "Rohit", "Rahul", "abc", "Rahul")

    private var countryList = arrayListOf(CountryDataSource(R.drawable.all_countries,"All Country"), CountryDataSource(R.drawable.india,"India"), CountryDataSource(R.drawable.united_kingdom,"UK") )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySpinnerPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item, players)
        binding.playersSpinner.adapter = arrayAdapter


        setupCustomSpinner()
        binding.playersSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(applicationContext, "Selected: " + players[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) { }
        }

        //AutoComplete textView Adapter
        val autoAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, players)
        binding.autoComplete.setAdapter(autoAdapter)

//        val dropdownList = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, players)
//        binding.materialSpinner.setAdapter(dropdownList)
    }

    private fun setupCustomSpinner() {

        val adapter = CountryArrayAdapter(this, countryList)
        binding.customSpiner.adapter = adapter
    }
}