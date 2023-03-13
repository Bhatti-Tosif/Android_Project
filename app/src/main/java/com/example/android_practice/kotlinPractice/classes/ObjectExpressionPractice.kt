package com.example.android_practice.kotlinPractice.classes

open class Number1(no1: Int) {
    open var width = no1
}
open class Number3 {
    open var data = "abc"
}
interface Number2 {
    var height: Int
}
interface A {
    fun funFromA() {}
}
interface B

class C {
    // The return type is Any. x is not accessible
    fun getObject() = object {
        val x: String = "x"
    }

    // The return type is A; x is not accessible
    fun getObjectA() = object: A {
        override fun funFromA() {}
        val x: String = "x"
    }

    fun getObjectB(): B = object: A, B {
        override fun funFromA() {}
        val x: String = "x"
    }
}

fun main() {
    val fullName = object {
        val firstName = "tosif"
        val lastName = "bhatti"
        override fun toString(): String = "$firstName $lastName"
    }
    println(fullName)
    println("=====Inheritance object anonymous class======")
    val ab = object : Number1(20), Number2 {
        override var height: Int = 10
    }
    println("height: ${ab.height}  width: ${ab.width}")
    val c = C()
    println(c.getObjectA().funFromA())
    println(c.getObjectB())
}