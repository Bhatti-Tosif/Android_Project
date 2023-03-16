package com.example.android_practice.newpractices

inline class Width(val width: Int)
inline class Height(val height: Int)

class RectangleTypesafe(width: Width, height: Height) {
    private val width: Width? = width
    private val height: Height? = height
    fun printAre() {
        println("Area is: ${this.width} and ${this.height}")
    }
}
class Area(var height: Int, val width: Int) {
    var area: Int
    get() = this.height * this.width
    set(value){
        height = value
    }
}
fun main() {
    val width = Width(100)
    val height = Height(10)
    val rectangle = RectangleTypesafe(width, height)
    rectangle.printAre()
    println(Area(10, 20).area)
}