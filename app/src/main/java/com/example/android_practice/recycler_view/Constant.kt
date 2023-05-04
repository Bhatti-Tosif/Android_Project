package com.example.android_practice.recycler_view

import com.example.android_practice.R

object Constant {
    private lateinit var dataList: ArrayList<RvDataModel>
    fun getData(): ArrayList<RvDataModel> {
        dataList = ArrayList<RvDataModel>()
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree", "Ahmedabad If content is more than increase the size of card"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree\n\n\n\n\n Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree\n\n\n\n\n Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree\n\n\n\n\n\n\n\n Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree", "Ahmedabad If content is more than increase the size of card"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree\n\n\n\n\n Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree\n\n\n\n\n Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.restaurant2, "Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.restaurant2, "Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.restaurant2, "Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.restaurant2, "Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.restaurant2, "Double Tree", "Ahmedabad"))


        return dataList
    }
}