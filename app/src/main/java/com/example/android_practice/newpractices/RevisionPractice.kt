package com.example.android_practice.newpractices

class AforPractice {
    fun name(x: Int) {
        println("$x and")
    }
    var s: String = ""
        get() = "tosif"
}
inline fun data(name: (Int) -> Int): Int {
    return 10
}
fun main() {
    val a: AforPractice = AforPractice()
    val s = a::name
    s(10)
    println(a.s)
    fun foo() {
        val s = data{ a ->
            a
        }
        println(s)
    }
    println(foo())
}