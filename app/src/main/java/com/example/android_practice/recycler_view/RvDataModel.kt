package com.example.android_practice.recycler_view

data class RvDataModel(var image: Int, var restaurant: String, var address: String)
data class ExpandDataModel(var image: Int, var restaurant: String, var address: String, var description: String, var isExpand: Boolean = false)

data class HotelData(var image: Int, var restaurant: String, var address: String, var typeOfView: Int, var headerText: String)