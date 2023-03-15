package com.example.android_practice.newpractices

fun foo() {
    listOf(1, 3, 5, 8).forEach A@ {
        if (it == 3) return@A
        println(it)
    }
}
fun main() {
    foo()
    var sum = fun Int.(x: Int, y: Int): Int =  x + y
    println(10.sum(10, 20))
    val sum2 = fun Int.(other: Int): Int = this + other
    var data: Int
    val s: (Int) -> Int = Ba@{a:Int ->
        data = a
        return@Ba  2
    data}
    println(s(3))
    println(10.sum2(20))
}