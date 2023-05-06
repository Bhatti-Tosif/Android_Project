package com.example.android_practice.recycler_view

data class RvDataModel(var image: Int, var restaurant: String, var address: String) {
}
data class ExpandDataModel(var image: Int, var restaurant: String, var address: String, var description: String, var isExpand: Boolean = false)