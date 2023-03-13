package com.example.android_practice.kotlinPractice.classes

interface Aof {
    fun printData() {
        println("Tosif of A")
    }
}
interface Bof {
    fun printData() {
        println("Tosif of B")
    }
}
class Cof: Aof, Bof{
    override fun printData() {
        super<Aof>.printData()
        super<Bof>.printData()
    }
}

open class AData: Aof {
    override fun printData() {
        println("Tosif from AData")
    }
    private var onlyForThis = "Private var"
}
class CData: AData(), Aof {
    override fun printData() {
        super<Aof>.printData()
        super<AData>.printData()
    }
}

fun interface Sum {
    fun addition(a: Int, b: Int): Int
}
object MyName {
    val aData = AData()
}
val <T> List<T>.lastIndex: Int
    get() = size - 2
val CData.lastName: Int
    get() = 1

fun main() {
    val cof = Cof()
    cof.printData()
    val data = CData()
    data.printData()
    var add: Sum = Sum { a, b -> a + b }
    println(add.addition(3,6))
    MyName.aData.printData()
    val list = mutableListOf<Int>(3, 6, 10, 8, 34)
    println( list.lastIndex)

    fun CData.printDetail() {
        println("Hello folk")
    }
    data.printDetail()
    data.lastName

    println("=======lambada========")
    val arr = arrayOf(1, 4, 10)

    val myLambada  = { a: Int, b: Int ->
        a + b
    }
    println(myLambada(3, 4))

    println("=========Extension=======")
    fun AData.detail() {
        println("Detail from extension function")
    }
    val extension = AData()
    extension.detail()
}
