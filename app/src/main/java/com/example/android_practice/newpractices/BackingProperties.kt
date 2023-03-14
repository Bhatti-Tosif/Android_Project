package com.example.android_practice.newpractices

class Student {
    private val _hobbies = mutableListOf<String>("tosif", "harsh")
    var hobbies: List<String> = mutableListOf("a")
        get() = _hobbies


    fun addHobby(hobbie: String) {
        _hobbies.add(hobbie)
    }
}
fun main() {
    val tosif = Student()
    println(tosif.hobbies)
    tosif.addHobby("parth")
    tosif.addHobby("ruchit")
    println(tosif.hobbies)
}