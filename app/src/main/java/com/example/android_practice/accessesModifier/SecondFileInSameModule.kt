package com.example.android_practice.accessesModifier

class SecondFileInSameNodule: SimpleAccessModifier() {
    override fun protectedFun() {
        super.protectedFun()
    }

    override fun internalFun() {
        super.internalFun()
    }

    override fun publicFun() {
        super.publicFun()
    }

}


fun main() {
    val obj2 = SecondFileInSameNodule()
    obj2.internalFun()
    obj2.publicFun()
    topLevelInternal()
}