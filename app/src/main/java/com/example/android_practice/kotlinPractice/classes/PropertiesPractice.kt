package com.example.android_practice.kotlinPractice.classes

class PropertiesPractice {
}
class Address {
    var name: String = "My Villa"
    var street: String = "Alka park"
    var zip = 363310
}
fun copyAddress(address: Address): Address {
    println("${address.zip} ${address.name}")
    val ans = Address()
    ans.name = "New Vilaa"
    ans.street = "Muskan park"
    ans.zip = address.zip
    return ans
}
class Rectangles {
    val width = 10
    val height = 5
    var area: Int = 0
        get() = width * height
    var customeSetter: Int
        get() = this.area
        set(value) {
            this.area = value
    }
}

fun main() {
    println("========Address Object ==========")
    val address = Address()
    val  result = copyAddress(address)
    println("${result.name} , ${result.street} , ${result.zip}")
    println("========Getter setter try=====")
    val areas = Rectangles()
    println("Area is: ${areas.area}")
    areas.customeSetter = 10
    println("${areas.area}")
    var no: Int?
    no = null
}