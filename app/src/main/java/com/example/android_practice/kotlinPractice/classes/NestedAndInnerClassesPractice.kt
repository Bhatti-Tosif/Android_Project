package com.example.android_practice.kotlinPractice.classes

class Outer {
    private var bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}
class OuterClass {
    class InnerClass
    interface InnerInterface
}

class OuterA {
    private val name: String = "Tosif"
    inner class InnerA {
        fun foo() = name
    }
}

fun main() {
    val demo = Outer.Nested().foo()
    println(demo)
    println("========Inner Class Practice======")
    val inner = OuterA().InnerA().foo()
    println(inner)

}