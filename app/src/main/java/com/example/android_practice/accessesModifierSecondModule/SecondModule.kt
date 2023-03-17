package com.example.android_practice.accessesModifierSecondModule

import com.example.android_practice.accessesModifier.SimpleAccessModifier
import com.example.android_practice.accessesModifier.topLevelInternal

class SecondModule: SimpleAccessModifier()  {

    override fun protectedFun() {
        super.protectedFun()
    }

    override fun publicFun() {
        super.publicFun()
    }

    override fun internalFun() {
        super.internalFun()
    }
}

fun main() {
    val obj3 = SecondModule()
    obj3.internalFun()
    obj3.publicFun()
    topLevelInternal()
}