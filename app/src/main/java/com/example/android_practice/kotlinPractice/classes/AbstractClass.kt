package com.example.android_practice.kotlinPractice.classes

abstract class AbstractClass {
    val name: String = "harsh"
    abstract fun access(): String
}
class AbstractOverride: AbstractClass() {
    override fun access(): String {
        return name
    }
}
open class Polygon {
    open fun draw() {
        println("This is Polygon default Value: ")
    }
}
abstract class takeNonAbstract: Polygon() {
    override fun draw() {
        super.draw()
    }
}

fun main() {
    val abstractData = AbstractOverride()
    print("deatail :${abstractData.access()}")
}