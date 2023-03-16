package com.example.android_practice.newpractices

class Vehicle {
    var x: String = ""
        get() = field
        set(value) {
            field = value
        }
    var y: String
    init{
        y = x
    }
}
fun main() {
    var name: String? = null
    println("name is : ${name?.length}")
    println(Vehicle().x)
}