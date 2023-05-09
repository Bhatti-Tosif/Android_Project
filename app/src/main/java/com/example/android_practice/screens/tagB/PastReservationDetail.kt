package com.example.android_practice.screens.tagB

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_practice.R
import com.example.android_practice.adapter.RentalAdapter
import com.example.android_practice.databinding.ActivityPastReservationDetailBinding
import com.example.android_practice.databinding.PastReservationItemBinding
import com.example.android_practice.screens.tagB.dataModel.Data
import com.example.android_practice.screens.tagB.dataModel.RentalModel

class PastReservationDetail : AppCompatActivity() {

    private lateinit var binding: ActivityPastReservationDetailBinding
    private lateinit var adapter: RentalAdapter
    private lateinit var rentalData: ArrayList<RentalModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPastReservationDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rentalData = Data.getRentalData()
        adapter = RentalAdapter(rentalData)
        binding.prDetailRv.layoutManager = LinearLayoutManager(this)
        binding.prDetailRv.adapter = adapter
    }
}