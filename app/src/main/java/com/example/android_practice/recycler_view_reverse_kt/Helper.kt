package com.example.android_practice.recycler_view_reverse_kt

import com.example.android_practice.R

object Helper {
    private lateinit var getMultiViewType: ArrayList<MultiViewType>

    fun getData(): ArrayList<MultiViewType> {
        getMultiViewType = arrayListOf()
        getMultiViewType.add(MultiViewType.SimpleItem(R.drawable.user5, "Parth"))
        getMultiViewType.add(MultiViewType.SimpleItem(R.drawable.user1, "Tosif"))
        getMultiViewType.add(MultiViewType.HorizontalItem(arrayListOf(R.drawable.user1, R.drawable.user8, R.drawable.user5)))
        getMultiViewType.add(MultiViewType.DropdownItem(R.drawable.user8, "Parth", "This is a best Song"))
        getMultiViewType.add(MultiViewType.SimpleItem(R.drawable.user5, "Parth"))
        getMultiViewType.add(MultiViewType.SimpleItem(R.drawable.user1, "Tosif"))
        getMultiViewType.add(MultiViewType.HorizontalItem(arrayListOf(R.drawable.user1, R.drawable.user8, R.drawable.user5)))
        getMultiViewType.add(MultiViewType.DropdownItem(R.drawable.user8, "Parth", "This is a best Song"))
        getMultiViewType.add(MultiViewType.SimpleItem(R.drawable.user5, "Parth"))
        getMultiViewType.add(MultiViewType.SimpleItem(R.drawable.user1, "Tosif"))
        getMultiViewType.add(MultiViewType.HorizontalItem(arrayListOf(R.drawable.user1, R.drawable.user8, R.drawable.user5)))
        getMultiViewType.add(MultiViewType.DropdownItem(R.drawable.user8, "Parth", "This is a best Song"))
        getMultiViewType.add(MultiViewType.SimpleItem(R.drawable.user5, "Parth"))
        getMultiViewType.add(MultiViewType.SimpleItem(R.drawable.user1, "Tosif"))
        getMultiViewType.add(MultiViewType.HorizontalItem(arrayListOf(R.drawable.user1, R.drawable.user8, R.drawable.user5)))
        getMultiViewType.add(MultiViewType.DropdownItem(R.drawable.user8, "Parth", "This is a best Song"))

        return getMultiViewType
    }
}