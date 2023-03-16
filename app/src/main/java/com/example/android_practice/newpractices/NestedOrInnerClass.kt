package com.example.android_practice.newpractices

class Outer {
    private var name = "tosif"
    fun detail() {
        println("This is a Outer: $name")
    }
    inner class Inner {
        fun detail() {
            println("This is an inner clas:")
        }
    }
}

fun main() {
    val outer = Outer()

    //Inner class call through outer class object only
    outer.Inner().detail()
    val inner = Outer().Inner()
    inner.detail()
}