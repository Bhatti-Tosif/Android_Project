package com.example.android_practice.recerseKtScreen.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.android_practice.recerseKtScreen.dataModel.SysData

class SysUtilCallBack(private val oldList: ArrayList<SysData>, private val newList: ArrayList<SysData>): DiffUtil.Callback() {
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