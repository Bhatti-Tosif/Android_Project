package com.example.android_practice.kotlinPractice.classes

data class WithExample(var name: String, var surname: String) {

}
fun main() {
    val data = WithExample("r", "j")
    with(data) {
        name = "Tosif"
        surname = "bhatti"
    }
    data.apply { name = "parth"
    }
    println(data.name)
}
