package com.example.android_practice.example.classes

data class Counter(val dayIndex: Int) {
    operator fun plus(increment: Int): Counter {
        return Counter(dayIndex + increment)
    }
}

fun main() {
    val plusOverload = Counter(30)
    println(plusOverload + 10)
}