package com.example.android_practice.recycler_view

import com.example.android_practice.R
import com.example.android_practice.listView.UserDetailData

object Constant {
    private lateinit var dataList: ArrayList<RvDataModel>
    private lateinit var userDetail: ArrayList<UserDetailData>
    private lateinit var expandData: ArrayList<ExpandDataModel>
    private lateinit var hotelDataList: ArrayList<HotelData>
    fun getData(): ArrayList<RvDataModel> {
        dataList = ArrayList<RvDataModel>()
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree", "Ahmedabad If content is more than increase the size of card"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Taj Hotel", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Hilton", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree\n\n\n\n\n Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Honest", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Double Tree\n\n\n\n\n Double Tree", "Ahmedabad"))
        dataList.add(RvDataModel(R.drawable.hotel1, "Mac D", "Ahmedabad"))
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

    fun getUserData(): ArrayList<UserDetailData> {
        userDetail = ArrayList<UserDetailData>()
        userDetail.add(UserDetailData("Parth","Hello Parth", R.drawable.hotel1))
        userDetail.add(UserDetailData("Parth","Hello Parth", R.drawable.hotel1))
        return userDetail
    }

    fun getExpandData(): ArrayList<ExpandDataModel> {
        expandData = ArrayList<ExpandDataModel>()
        expandData.add(ExpandDataModel(R.drawable.hotel1, "Taj Hotel", "Mumbai", "It is an 5 Start Hotel"))
        expandData.add(ExpandDataModel(R.drawable.hotel1, "Taj Hotel", "Mumbai", "It is an 5 Start Hotel"))

        return expandData
    }

    fun getHotelData(): ArrayList<HotelData> {
        hotelDataList = ArrayList<HotelData>()
        hotelDataList.add(HotelData(R.drawable.hotel1, "Taj Hotel", "Ahmedabad",1, "5 Star Hotel"))
        hotelDataList.add(HotelData(R.drawable.hotel1, "Taj Hotel", "Ahmedabad",0, "5 Star Hotel"))
        hotelDataList.add(HotelData(R.drawable.hotel1, "Taj Hotel", "Ahmedabad",0, "5 Star Hotel"))
        hotelDataList.add(HotelData(R.drawable.hotel1, "Taj Hotel", "Ahmedabad",0, "5 Star Hotel"))
        hotelDataList.add(HotelData(R.drawable.hotel1, "Taj Hotel", "Ahmedabad",0, "5 Star Hotel"))
        hotelDataList.add(HotelData(R.drawable.hotel1, "Taj Hotel", "Ahmedabad",1, "5 Star Hotel"))
        hotelDataList.add(HotelData(R.drawable.hotel1, "Taj Hotel", "Ahmedabad",0, "5 Star Hotel"))
        hotelDataList.add(HotelData(R.drawable.hotel1, "Taj Hotel", "Ahmedabad",0, "5 Star Hotel"))
        hotelDataList.add(HotelData(R.drawable.hotel1, "Taj Hotel", "Ahmedabad",1, "5 Star Hotel"))
        hotelDataList.add(HotelData(R.drawable.hotel1, "Taj Hotel", "Ahmedabad",0, "5 Star Hotel"))

        return hotelDataList
    }
}