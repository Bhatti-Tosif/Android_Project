package com.example.android_practice.newpractices

fun interface A {
    fun printData()
}
class BackingField {
    var age: Int = 0
        get() {
            println("age is : $field")
            return  field
        }
        set(value) {
        println("new value: $value")
        field = value
    }
}
fun main() {
    val back = BackingField()
    println(back.age)
    back.age = 21
    back.age
}