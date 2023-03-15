package com.example.android_practice.newpractices

import com.example.android_practice.kotlinPractice.classes.Circle
import org.xml.sax.DTDHandler

sealed class Shape() {
    class Circle(var radius: Float): Shape() {
        fun area() {
            println("area: ${3.14 * radius * radius}")
        }
    }
    class Square(var side: Int): Shape()
}
class Rectangle(var length: Int, var width: Int): Shape()

fun checkShape(shape: Shape) {
    when(shape) {
        is Shape.Square -> println("area: ${shape.side * shape.side}")
        is Shape.Circle -> shape.area()
        is Rectangle -> println("${shape.length * shape.width}")
    }
}
fun main() {
    val rectangle = Rectangle(30,10)
    println(rectangle.length)
    val circle = Shape.Circle(10f)
    val square = Shape.Square(20)
    checkShape(circle)
    var name:String = "tosif"
}