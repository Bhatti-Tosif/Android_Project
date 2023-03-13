package com.example.android_practice.kotlinPractice.classes

import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    var array = IntArray(5)
    array.forEach { print(it) }
    var number = IntArray(5) { it * 1 }
    number.forEach { print(it) }
    val asc = Array(5) { i -> (i*i).toString() }
    asc.forEach { print(it) }
    println(asc::class.java.typeName)
    var x = intArrayOf(3, 6, 10)
    x.forEach { print(it) }
    fun demo(x: Any) {
        if (x !is String) {
            println("Print this is not String")
        }
        if (x is IntArray) {
            println("This is IntArray")
        }
    }
    when(x) {
        is IntArray -> println(x+1)
        //is  String-> println("This is string")
    }
    demo(x);
    var y = null
    var str: String? = y as String?
    //safe cast operator
    var str2: String? = y as? String
    print(str2)
}