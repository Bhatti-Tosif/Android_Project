package com.example.android_practice.kotlinPractice.classes

data class WithExample(var name: String, var surname: String) {
    fun printData() {
        println("Print data class function call")
    }

}
class SealedTry: Tile()
fun main() {
    val data: WithExample? = WithExample("r", "j")//null
    val data2 = WithExample("r", "j")
    println(data?.equals(data2))
    println(data.hashCode())
    println("=========With Example========")
    val x = with(data2) {
        name = "Tosif"
        surname = "bhatti"
        printData()
        name
    }
    println(x)
    println("=========apply Practice======")
    val applyReturn = data?.apply {
        name = "parth"
        println(surname)
        printData()
        println(name)
    }
    println(applyReturn)
    println(applyReturn?.equals(data))

    println("=========let practice========")
    val lateReturn = data?.let {
        it.printData()
        it.name = "rahul"
        println(it.name)
        "let last expression"
    }
    println(data?.name)
    println(lateReturn)

    println("=======Run Practice==========")
    val runReturn = data. run {
        println(this?.name)
        this?.name = "harsh"
        "name change to harsh"
    }
    println(runReturn)
}
