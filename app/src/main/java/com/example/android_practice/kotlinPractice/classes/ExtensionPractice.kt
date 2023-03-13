package com.example.android_practice.kotlinPractice.classes

class ExtensionPractice {
    fun foo() {
        println("This is a class foo function")
    }
    var name: String = "Tosif"
}
fun ExtensionPractice.addFeature() {
    println("This is new feature")
}
fun ExtensionPractice.name(s: String) {
    this.name = "Bhatti tosif $s"

}
fun ExtensionPractice.foo() {
    println("This is a foo extension function")
}
fun MutableList<Int>.swap(index1: Int, index2: Int) {
    var temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

class Myclass {
    companion object { }
}
fun Myclass.Companion.printCompanion() {
    println("Companion")
}

class Host(val hostname: String) {
    fun printHostname() { print(hostname) }
}

class Connection(val host: Host, val port: Int) {
    fun printPort() { print(port) }

    fun Host.printConnectionString() {
        printHostname()   // calls Host.printHostname()
        print(":")
        printPort()   // calls Connection.printPort()
    }

    fun connect() {
        host.printConnectionString()
    }
}
fun main() {
    val detail = ExtensionPractice()
    detail.foo()
    detail.addFeature()
    detail.name("M")
    println(detail.name)
    var list = mutableListOf<Int>(12, 40, 53, 11)
    list.swap(1, 3)
    println(list)
    println("=======Extensions resolve Statically========")
    open class Shape
    class Rectangle: Shape()
    fun Rectangle.getName() = "Rectangle"
    fun Shape.getName() = "Shape"
    fun printClass(s: Shape) {
        println(s.getName())
    }
    printClass(Rectangle())

    println("==========Companion Object==========")
    Myclass.printCompanion()
    println("===========Declare extension as a member========")
    Connection(Host("kotl.in"), 443).connect()
}