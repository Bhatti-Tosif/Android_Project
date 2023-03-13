package com.example.android_practice.kotlinPractice.classes

private class PracticeCompanion {
    val no1 = 30
    companion object detail {
        fun create() = PracticeCompanion
    }
}

fun main() {
    val instance = PracticeCompanion.create()
    println(instance.create())
}