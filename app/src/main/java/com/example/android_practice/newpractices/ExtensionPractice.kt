package com.example.android_practice.newpractices

class Extension {
    internal var x = 20
}
interface abstractInterface {
    //final var x: Int
    //final not applicable inside the interface
}
abstract class abstract {
    final var x = 20
}
class D: abstract() {
    //override var x = 10
}
var Extension.y: Int
    get() = 23
    set(value) {
        x = value
    }
object abc {

}
fun abc.data() {
    println("data")
}
fun data() {
    var x = 24
}
fun main() {
    val ex = Extension()
    println(ex.y)
    ex.y = 24
    var array = arrayOf(10, 20, 30)
    println(ex.x)
}