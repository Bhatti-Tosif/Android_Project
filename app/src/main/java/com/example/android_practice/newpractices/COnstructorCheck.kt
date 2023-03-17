package com.example.android_practice.newpractices

class Primary {
    constructor(i: Int) {
        var x = i
        println(i)
    }
}
class ConstructorCheck(name: String) {
    constructor(name1: String, name2: String) : this(name1) {
        println("Data1")
    }
    constructor(name3: String, name4: String, name5: String) : this(name3, name4) {
        val name3 = name3
    }
}

fun main() {
    val primary = Primary(2)
}