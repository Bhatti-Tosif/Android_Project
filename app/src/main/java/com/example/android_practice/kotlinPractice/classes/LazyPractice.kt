package com.example.android_practice.kotlinPractice.classes

import kotlin.properties.Delegates

class LazyPractice {
    val name: String by lazy {
        println("This is first time intialization")
        "tosif"
    }
    var surname = lazy {
        println("This is second lazy type")
        "harsh"
    }
}
class UserDelegation {
    var string: String by Delegates.observable("tosif") {
        property, oldValue, newValue ->
        println("$oldValue -> $newValue")
        println(property)

    }
}

fun main() {
    println("=========Lazy Practice==========")
    val lazyObj = LazyPractice()
    println(lazyObj.name)
    println(lazyObj.name)
    println(LazyPractice().surname.value)
    val secondLazy = LazyPractice()
    secondLazy.surname = lazy {
        println("Second time assign")
        "rahul"
    }
    println(secondLazy.surname.value)
    println("==========Observable Practice========")
    val userDelegate = UserDelegation()
    println(userDelegate.string)
    userDelegate.string = "parth"
    userDelegate.string = "ruchit"
    println(userDelegate.string)
}