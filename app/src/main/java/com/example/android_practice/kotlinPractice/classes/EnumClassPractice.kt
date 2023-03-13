package com.example.android_practice.kotlinPractice.classes


enum class Day(val number: Int) {
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY( 6),
    SATURDAY(7);
    fun printDay() {
        println("Day is: $this")
    }
}

fun main() {
    val day = Day.SUNDAY
    println(day)
    for (i in Day.values()) {
        println(i)
    }
    day.printDay()
}