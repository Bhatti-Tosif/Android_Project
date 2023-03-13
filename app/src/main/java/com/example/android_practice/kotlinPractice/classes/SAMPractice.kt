package com.example.android_practice.kotlinPractice.classes

import com.example.android_practice.kotlinPractice.classes.FunctionalInterface


fun  interface FunctionalInterface {
    fun check(i: Int): Boolean
}
typealias IntPredict = (i: Int) -> Boolean
val  isEve:IntPredict = { it % 2 == 0}
fun main() {
    println("THis is typealias: ${isEve(22)}")
    //First method
    val isOdd = object : FunctionalInterface {
        override fun check(i: Int): Boolean {
            return i % 2 == 0
        }
    }
    println( isOdd.check(33))
    //USing functional interfaces
    val isEven = FunctionalInterface { it % 2 == 0 }
    println(isEven.check(2))
}