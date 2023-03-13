package com.example.android_practice.kotlinPractice.classes

class  ConstructorTry {
    init {
        println("Constructor class init Call")
    }
    constructor() {
        println("Secondary Construct call ")
    }
}
class InitOrderDemo(val name: String) {
    var x: String = "First initializer $name".also { println() }
    constructor() : this(name = "a") {
        println("This is secondary constructor called")
    }
    init {
        println("First Initializer name: $name")
    }
    val y = "Second Property $name".also { println("Also run $name") }
    init {
        println("nothing is")
    }
    init {
        println("Second init called name: $name and $y")
    }
    var z = name
}

fun main() {
    //val initDemo = InitOrderDemo("tosif")
    val initDemo2 = InitOrderDemo()
    println("============Constructor Claaa ==========")
    val construct = ConstructorTry()
}