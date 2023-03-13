package com.example.android_practice.kotlinPractice.classes

interface Printable {
    fun printPretty()
}
@JvmInline
value class Name(val s: String): Printable {
    init {
        require(s.length > 0) { }
    }

    val length: Int
        get() = s.length

    fun greet() {
        println("Hello, $s")
    }

    override fun printPretty() {
        println("Good Wishes")
    }
}
 interface Delegation {
     fun bar()
     fun foo() = "foo"
 }
@JvmInline
value class MyInterfaceDelegation(val myInterfaceDelegation: Delegation): Delegation by myInterfaceDelegation

typealias NameTypeAlias = String
@JvmInline
value class NameInlineClass(val s: String)

fun acceptString(s: String) {}
fun acceptNameTypeAlias(n: NameTypeAlias) {}
fun acceptNameInlineClass(p: NameInlineClass) {}

fun main() {
    val name = Name("Kotlin")
    name.greet()
    name.printPretty()
    println(name.length)
    println("=========Inline and type alias=========")
    val nameAlias: NameTypeAlias = ""
    val nameInlineClass: NameInlineClass = NameInlineClass("")
    val string: String = ""

    acceptString(nameAlias)
    //acceptString(nameInlineClass)


    acceptNameTypeAlias(string)
    //acceptNameInlineClass(string)

    println("=========Delegation in inline ========")
    val my = MyInterfaceDelegation(object : Delegation {
        override fun bar() {
            println("This is bar function")
        }
    })
    println("foo: ${my.foo()} and bar: ${my.bar()}")
}
