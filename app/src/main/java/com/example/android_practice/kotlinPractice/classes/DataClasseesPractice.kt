package com.example.android_practice.kotlinPractice.classes

data class User(val name: String, val age: Int) {
    var gender: String = ""
    constructor(name: String, age: Int, gender: String): this(name, age) {
        this.gender = gender
    }
}
fun main() {
    val user1 = User("ruchit", 21)
    val user2 = User("parth", 23)
    val user3 = User("ruchit",21)
    user3.copy()
    user1.gender = "male"
    user3.gender = "female"
    println("Compare user1==user2 : ${user1 == user2}")
    println("Compare user1==user3 : ${user1 == user3}")
    println("Person1 gender ${user1.name}: ${user1}")
    println("Person2 gender: ${user2}")
    val jack = User("jeck", 34)
    val olderJack = jack.copy(name = "tosif")
    val jeck2 = jack.copy(name = "ruchit")
    println(jeck2)
    println(olderJack.toString())
    println("===========data class secondary constructor=====")
    val secondary = User(name = "parth", age = 25, gender = "male")
    println(secondary)
    println("====Data class Distructive Declaration=======")
    val (name, age) = jack
    println("I am $name and my age is $age")
}