package com.example.android_practice.recycler_view_reverse_kt

sealed class MultiViewType {
    abstract val viewType: Int
    data class SimpleItem(val profileImage: Int, val userName: String) : MultiViewType() {
        override val viewType: Int = 1
    }

    data class HorizontalItem(val postImages: ArrayList<Int>) : MultiViewType() {
        override val viewType: Int = 2
    }

    data class DropdownItem(val profileImage: Int, val userName: String, val comment: String, var isExpand: Boolean = false) : MultiViewType() {
        override val viewType: Int = 3
    }
}
