package com.example.android_practice.recerseKtScreen.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.android_practice.recerseKtScreen.dataModel.WalkingData

class WalkingDetailCallBack(private val oldList: ArrayList<WalkingData>, val newList: ArrayList<WalkingData>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemPosition == newItemPosition
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemPosition == newItemPosition
    }
}