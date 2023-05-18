package com.example.android_practice.screens.tagB.dataModel

import com.example.android_practice.recycler_view.RvAdapter
import com.example.android_practice.recycler_view.RvDataModel


data class RentalModel(val rentalID: String, val facility: String, val ReservationType: ReservationType, val entryDate: String, val ExitDate: String, var price: Int, val entryTime: String, val exitTime: String, var rating: Double?, var isRented: Boolean)



