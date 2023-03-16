package com.example.android_practice.newpractices

inline fun myInlineTwo(myFunctionOne: (String) -> Unit , myFunctionTwo: (Int, Int) -> Int) {
    myFunctionOne("Hello")
    println( myFunctionTwo(10,20))
}
fun main() {
    myInlineTwo( { str: String ->  println(str) }, { a: Int, b: Int ->  a + b
        })
}