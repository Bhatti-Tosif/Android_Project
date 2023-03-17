package com.example.android_practice.accessesModifier

open class SimpleAccessModifier {
    private fun privateFun() {

    }
    protected open fun protectedFun() {

    }
    public open fun publicFun() {

    }
    internal open fun internalFun() {

    }
}
class Derived: SimpleAccessModifier() {
    //override fun privateFun()
    override fun protectedFun() {
        println("Protected fun")
    }

    override fun publicFun() {
        println("Public fun")
    }

    override fun internalFun() {
        println("Internal fun")
    }
}

internal fun topLevelInternal() {
    println("top level internal")
}
private fun topLevelPrivate() {
    println("top level internal")
}
fun topLevelProtected() {
    println("top level internal")
}
public fun topLevelPublic() {
    println("top level internal")
}

fun main() {
    val derived = Derived()
    derived.internalFun()
    derived.publicFun()
}