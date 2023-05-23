package com.example.android_practice.recycler_view_reverse_kt.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.android_practice.recycler_view_reverse_kt.data_modal.MultiViewType

class MultiViewCallBack(private val oldList: ArrayList<MultiViewType>, val newList: ArrayList<MultiViewType>): DiffUtil.Callback() {
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