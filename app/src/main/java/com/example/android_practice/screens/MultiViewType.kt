package com.example.android_practice.screens

sealed class MyItem {
    abstract val viewType: Int

    data class SimpleItem(val data: String) : MyItem() {
        override val viewType: Int = 0
    }

    data class HorizontalItem(val data: List<String>) : MyItem() {
        override val viewType: Int = 1
    }

    data class DropdownItem(val options: List<String>) : MyItem() {
        override val viewType: Int = 2
    }
}
