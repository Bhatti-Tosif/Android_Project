package com.example.android_practice.kotlinPractice.classes

open class Shape {
    open fun draw() {}
    fun fill(){}
    open lateinit var name: String
}
class Circle: Shape() {
    override fun draw() {
        println("This is Circle")
    }
    fun fill(i: Int) {
        println("This is fill function $i")
    }
    override var name = "Circle"
}
open class Rectangle: Shape() {
    override fun draw() {
        println("This is an Rectangle")
    }
}
interface Poly {
    fun draw() { println("This is an Polygone") }

}
class Square: Rectangle(), Poly {
    override fun draw() {
        super<Rectangle>.draw()
        super<Poly>.draw()
    }
}

fun main() {

    val circle = Circle()
    circle.fill(1);
    circle.draw()
    println("=========Square==========")
    val square = Square()
    square.draw()
}