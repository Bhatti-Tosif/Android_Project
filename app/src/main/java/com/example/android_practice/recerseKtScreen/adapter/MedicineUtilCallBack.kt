package com.example.android_practice.recerseKtScreen.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.android_practice.recerseKtScreen.dataModel.MedicineData

class MedicineUtilCallBack(private val oldList: ArrayList<MedicineData>, private val newList: ArrayList<MedicineData>): DiffUtil.Callback() {

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