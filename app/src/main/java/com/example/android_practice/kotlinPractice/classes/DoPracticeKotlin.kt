package com.example.android_practice.kotlinPractice.classes

fun main() {
    println("Tosif")
    fun sum(a: Int, b: Int): Int {
        return a + b
    }
    println(sum(20, 30))

    fun add(a: Int, b: Int) = a + b
    println(add(20, 56))

    //Return type omitted
    fun omit(a: Int, b: Int): Unit {
        println("Sum of $a and $b : ${a + b}")
    }
    omit(20, 40)
    //Variable Practice
    val number1: Int = 1
    var number2 = 2
    println(number1 + number2)
    number2 = 60
    print(number2)

    println("===========literal Constant==========")
    val oneMillion = 1_000_000
    val ceditCard = 1234_3456_6578_8785L
    val hex_Byte = 0xFF_EC

    //Nullable reference
    var a: Int = 100
    var numberA: Int? = a
    var anotherNumberA: Int? = a

    var b: Int = 200000
    var numberB: Int? = b
    var anotherNumberB: Int? = b
    println(numberB === anotherNumberB)
    println(numberA === anotherNumberA)

    if (numberA === anotherNumberA) {
        println("Both a are same")
    }
    if (numberB === anotherNumberB) {
        println("Both b are sam")
    }

    println("=======Number Conversion========")
    var no1: Int? = 1
    var no2: Long? = no1?.toLong()
    print(no2)
    println("==========Special Character==========")
    println("tosif \t parth")
    println("tosif \b parth")
    println("tosif \n parth")
    println("tosif \r parth")
    println("tosif \' parth")
    println("tosif \" parth")
    println("tosif \\ parth")
    println("tosif \$ parth")
    println("\uFF00")

    println("====== String =======")
    val name = "tosif bhatti"
    for (char in name) {
        print(char)
    }
    println("\n=======Raw String======")
    val text = """
       |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()
    println(text)
}