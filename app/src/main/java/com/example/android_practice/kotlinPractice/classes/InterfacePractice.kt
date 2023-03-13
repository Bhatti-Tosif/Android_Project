package com.example.android_practice.kotlinPractice.classes

class InterfacePractice {
}
interface Needed {
    var specialNo: String
    fun foo() {
        println("This is interface foo")
    }
    var name: String
        get() = this.specialNo
    set(value) {
        this.specialNo = value
    }
}
class Interface: Needed {
    override var specialNo = "a"
        get() = field
        set(value) {
            field = value
        }

    override fun foo() {
        println("This is class foo")
        super.foo()
    }

    override var name: String
        get() = super.name
        set(value) {}
}

fun main() {
    var need = Interface()
    need.foo()
    need.name = "tosif"
    println(need.name)
}