package com.example.android_practice.kotlinPractice.classes


fun main() {
    var items = listOf(4, 6, 10, 56, 23)
    items.fold(0) { acc, i ->
        println("acc = $acc and i= $i")
        var result = acc + i
        println("Result = $result")
        result
    }
    val joinedToString = items.fold("Element", { acc, i -> acc + " " + i})
    val product = items.fold(1, Int::times)

    println("joinedToString = $joinedToString")
    println("production = $product")
    val repeatFun: String.(Int) -> String = {times -> this.repeat(times) }
    val twoParameter: (String, Int) -> String = repeatFun
    fun runTransformation(f: (String, Int) -> String) : String {
        return f("Hello", 3)
    }
    val result = runTransformation(repeatFun)
    println("Result = $result")

    println("========Lambada Practice=======")
    var takeLambada = {
        println("Hello ")
    }

    println(takeLambada())
}