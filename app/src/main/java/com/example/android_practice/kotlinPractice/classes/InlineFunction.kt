package com.example.android_practice.kotlinPractice.classes


inline fun <reified T> myExample(name: T) {
    println("Name of your website -> "+name)
    println("Type of myClass: ${T::class.java}")
}
//crossinline means when we need lambada access into inside another function
inline fun f(crossinline body: () -> Unit) {
    val f = object : Runnable {
        override fun run() = body()
        // ...
    }
}
fun main() {

    myExample<String>("www.tutorialspoint.com")
    myExample<Int>(100)
    myExample<Long>(1L)

    f { println("data") }

}