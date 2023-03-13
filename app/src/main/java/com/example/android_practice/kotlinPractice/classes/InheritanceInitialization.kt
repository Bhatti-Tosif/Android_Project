package com.example.android_practice.kotlinPractice.classes

class InheritanceInitialization {
}
open class Base(name: String = "a".also { println("Argument for base class $it") }) {
    open val size: Int = name.length.also { println("Initializing size in base class") }
    init {
        println("Base class initialization")
    }
}
class Derived(name: String, lastName: String): Base(name.replaceFirstChar { it.uppercase() }.also { println("Argument for derived class: $it") }) {
    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in derived Class") }
    init {
        println(super.size)
        println("Initializing Derived Class ")
    }
}
class square: Shape()

fun main() {
    Derived( "" , "Bhatti")
}