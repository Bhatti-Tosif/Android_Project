package com.example.android_practice.recycler_view_reverse_kt

import androidx.recyclerview.widget.DiffUtil
import com.example.android_practice.recycler_view_reverse_kt.data_modal.CommentDataModal

class CommentCallBack(private val oldList: ArrayList<CommentDataModal>, val newList: ArrayList<CommentDataModal>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.count()
    }

    override fun getNewListSize(): Int {
        return newList.count()
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemPosition == newItemPosition
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItemPosition == newItemPosition
    }
}