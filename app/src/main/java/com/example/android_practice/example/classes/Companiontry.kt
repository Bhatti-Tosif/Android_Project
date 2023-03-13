package com.example.android_practice.example.classes

class User(name: String) {
    var name = "Tosif"
    lateinit var fName: String
    companion object abcd {
        var fname = "parth"
    }
}
class A {
    var user: User? = User("ruchit")
}

fun main() {
    var a = A()
    println(User.fname)
}