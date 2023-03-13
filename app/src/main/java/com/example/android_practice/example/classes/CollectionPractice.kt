package com.example.android_practice.example.classes

import kotlinx.coroutines.internal.artificialFrame

data class Person(val name: String, val age: Int)
open class  check {
    var x = 10
}

fun main() {
    val list = List<Int>(5, { it * 2})
    println(list)
    val arraylist = ArrayList<Int>(5)
    val arraylist2 = ArrayList<Int>(5)
    println("Compare arrayList: ${arraylist == arraylist2}")
    arraylist.addAll(arrayOf(0, 2, 4, 6, 8))
    println(arraylist)
    val array = Array<Int>(5,{it * 2})
    val array2 = Array<Int>(5,{it * 2})
    println("Compare array: ${array == array2}")
    array.forEach { print(it) }
    println(list == array)
    println(array == arraylist)

    val strList = listOf("one", "two", "three", "four")
    val strSet = setOf("one", "two", "three", "four", "five")
    val strMap = mapOf(1 to  "one", 2 to "two", 3 to "three")
    println("$strList \b set: $strSet \b map: $strMap")
    println("======Comparison ========")
    val bob = Person("Bob", 30)
    val person1 = listOf(Person("adam", 20), bob, bob)
    val person2 = listOf(Person("adam", 20), Person("Bob", 30), bob)
    println(person2 == person1)
    println("Both are refer to same object: ${person1 === person2}")
}