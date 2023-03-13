package com.example.android_practice.kotlinPractice.classes

import android.graphics.Color

enum class ColorEnum {
    RED, BLUE, GREEN;

    fun getColor(d: ColorEnum) {
        when(d) {
            RED -> print("Red color")
            BLUE -> print("Blue Color")
            GREEN -> print("Green color")
        }
    }
}