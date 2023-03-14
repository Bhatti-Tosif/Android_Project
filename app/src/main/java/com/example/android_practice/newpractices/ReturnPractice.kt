package com.example.android_practice.newpractices

fun foo() {
    listOf(1, 3, 5, 8).forEach A@ {
        if (it == 3) return@A
        println(it)
    }
}
fun main() {
    foo()
}