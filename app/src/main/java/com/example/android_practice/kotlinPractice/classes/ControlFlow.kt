package com.example.android_practice.kotlinPractice.classes

fun main() {
    val a = 2
    val b = 5
    var max = 0
    if (a > b) {
        max = a
    } else {
        max = b
    }
    if (a < b) max = b
    if (a > b) a else b
    println(max)

    val maxLimit = 1
    val highest = if (maxLimit > a) maxLimit else if (a > b) a else b
    println(highest)
    
    val highest2 = if (a > b) {
        print("a is highest: ")
        a
    } else {
        print("b is highest: ")
        b
    }
    print(highest2)

    val colorObj = ColorEnum.GREEN
    println(colorObj)
    println("==========When practices=========")
    var x = 1
    when(x) {
        2, 3 -> print("1 or 2")
        //for range we use in or in!
        is Int -> print("This is String")
        //!is Long -> print("This is Long")
        in 1..5 -> print(" it is in inside the range")
        !in 6..10 -> print("it is outside the range")
        else -> print(" This is else")
    }
    println("========For loop Practice========")
    var languages = listOf<String>("java", "C++", "Kotlin", "Swift")
    var numbers = listOf<Int>(30, 67, 45, 78);
    println(languages)
    println(numbers)
    for (language in languages) {
        println(language)
    }
    println(languages[2])
    for (i in 1..3) {
        print(i)
    }
    for (i in 6 downTo 0 step 2) {
        print(i)
    }
    for (i in languages.indices) {
        print(languages[i])
    }
    for ((index, value) in languages.withIndex()) {
        println("$index : $value")
    }
    while (max > 1) {
        print("Max is: $max")
        max--
    }
    do {
        print("Do Max: $max")
        max--
    } while (max > 0)
    println("==========Labels Break Continue=========")
    loop@ for(i in 1..5) {
        for(j in 1..5) {
            if(j == 3) break@loop
            print(j)
        }
    }
    throw java.lang.Exception("Hi there")
}