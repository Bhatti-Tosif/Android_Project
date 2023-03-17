package com.example.android_practice.newpractices

enum class CreditCardType {
    SILVER,
    GOLD,
    PLATINUM;
}
//we can not extend enum class
//data class A: CreditCardType() { }
interface CashBack {
    fun getCashBAck(): Float
    companion object {
        var name = "tosif"
    }
}
enum class CreditCard(color: String, val value: Int = 1000000): CashBack {
    SILVER("RED",199999) {
        override fun getCashBAck(): Float = 0.2f
    },
    GOLD("BLUE", 300000) {
        override fun getCashBAck(): Float = 0.4f
    },
    PLATINUM("GOLDEN", 10000000) {
        override fun getCashBAck(): Float = 0.6f
    };
}
fun main() {
    val value: CreditCardType = CreditCardType.GOLD
    println(value)
    println(CreditCardType.valueOf("GOLD"))
    println(CreditCardType.PLATINUM.ordinal)
    println(CreditCardType.GOLD.name)
    val all: Array<CreditCardType> = CreditCardType.values()
    all.forEach { println(it) }

    println("=======check========")
    val tosif = CreditCardType.GOLD
    when(tosif) {
        CreditCardType.SILVER -> {
            println("tosif have silver card")
        }
        CreditCardType.GOLD -> { println("tosif have gold card") }
        CreditCardType.PLATINUM -> {
            println("tosif have platinum card")
        }
    }
    println("========CreditCard Enum Class ==========")
    println(CreditCard.PLATINUM.getCashBAck())
    println(CreditCard.SILVER.name)
    println(CreditCardType.GOLD.ordinal)
    println(CreditCardType.SILVER.declaringClass)

}