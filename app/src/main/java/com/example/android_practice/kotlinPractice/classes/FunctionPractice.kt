package com.example.android_practice.kotlinPractice.classes

open class CheckDefault {
    open fun foo(bar: Int = 20, baz: Int, lmd: () -> Unit) {
        print(bar)
    }
}
class CheckParameter: CheckDefault() {
    override fun foo(bar: Int, baz: Int, lmd: () -> Unit) {
        print("$bar and $baz\n")
    }
}
fun variableArgument(vararg string: String) {
    string.forEach { println(it) }
}
fun printHello(name: String?): Unit {
    if(name != null) {
        println("Hello $name")
    } else {
        println("Hello")
    }
}
fun singleExpressionFun(number: Int): Int = number * 2
fun <T> asList(vararg lists: T): List<T> {
    var result = ArrayList<T>()
    for(list in lists) {
        result.add(list)
    }
    return result
}
infix fun Int.shl(number: Int) : Int {
    return number
}


fun main() {
    val obj = CheckParameter()
    obj.foo(baz = 30, lmd = {println("Hello") } )
    variableArgument(string = arrayOf("tosif", "ruchit", "parth"))
    printHello(null)
    println(singleExpressionFun(3))
    val data = asList(3, 4, 5, 1)
    println(data)
    println(data::class.simpleName)
    val newElement = arrayOf(34, 56, 76)
    val newData = asList(3, 4, 5, *newElement, 34, 10)
    println(newData)
    println(1 shl 2)


}