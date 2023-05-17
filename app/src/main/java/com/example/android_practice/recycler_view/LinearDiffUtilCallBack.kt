package com.example.android_practice.recycler_view

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.DiffResult

class LinearDiffUtilCallBack(private val oldList: List<RvDataModel>, private val newList: List<RvDataModel>): DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].restaurant == newList[newItemPosition].restaurant
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].restaurant != newList[newItemPosition].restaurant -> false
            oldList[oldItemPosition].image != newList[newItemPosition].image -> false
            oldList[oldItemPosition].address != newList[newItemPosition].address -> false
            else -> true
        }
    }
}