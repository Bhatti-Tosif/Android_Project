package com.example.android_practice.recycler_view_reverse_kt.data_modal

import android.graphics.drawable.Drawable

sealed class MultiViewType {
    abstract val viewType: ViewType
    data class SimpleItem(val profileImage: Drawable?, val userName: String) : MultiViewType() {
        override val viewType = ViewType.SimpleView
    }

    data class HorizontalItem(val postImages: ArrayList<Int>) : MultiViewType() {
        override val viewType = ViewType.HorizontalView
    }

    data class DropdownItem(val profileImage: Drawable?, val userName: String, val commentModal: ArrayList<CommentDataModal>, var isExpand: Boolean = false) : MultiViewType() {
        override val viewType = ViewType.DropDownView
    }
}
enum class ViewType {
    SimpleView,
    HorizontalView,
    DropDownView
}
