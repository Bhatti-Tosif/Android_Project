package com.example.android_practice.kotlinPractice.classes

interface BaseInterface {
    fun printMessage()
    fun printMessageLine();
}
class BaseImplementation(val x: Int = 0): BaseInterface {
    override fun printMessage() {
        print("This is an baseImp print $x")
    }

    override fun printMessageLine() {
        println("This is amn baseImp println $x")
    }
}
class DerivedDelegation(val b: BaseInterface) : BaseInterface by b {
    override fun printMessageLine() {
        println("This is  derived Class Method")
    }
}

interface Greet {
    fun printGreet()
    var message: String
}
class GreetImp(val msg: String): Greet {
    override fun printGreet() {
        println("Hello, $msg")
    }

    override var message: String = "GreetImp msg = $msg"
}

class DerivedGreet(greet: Greet): Greet by greet {
    override var message: String = "Derived Greet msg"
}


fun main() {
    val b = BaseImplementation()
    DerivedDelegation(b).printMessageLine()
    DerivedDelegation(b).printMessage()
    println("\n========Greet Example=========")
    val baseObj = GreetImp("tosif")
    val derivedObj = DerivedGreet(baseObj)
    derivedObj.printGreet()
    println(derivedObj.message)
}