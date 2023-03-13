package com.example.android_practice.newpractices

data class User(val firstName: String, val lastName: String) {
    val userName = "${firstName}@${lastName}"
}
fun User.authentication() {
    println("Authenticated user: ${userName}")
}
fun main() {
    val tosif = User("tosif", "bhatti")
    tosif.authentication()
}