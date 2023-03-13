package com.example.android_practice.kotlinPractice.classes


class UserMap(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}

fun main() {
    val user = UserMap(mapOf(
        "name" to "John Doe",
        "age"  to 25
    ))
    println("========Map Stored Properties========")
    println(user.name)
    println(user.age)

}