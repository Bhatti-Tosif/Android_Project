package com.example.android_practice.kotlinPractice.classes

import java.text.FieldPosition

sealed class Tile
class Red(val type: String, val points: Int) : Tile()
class Blue(val points: Int) : Tile()

sealed class ReadResult {
    data class Number(val value: Int): ReadResult()
    data class Text(val value: String): ReadResult()
    //data object EndOfFile: ReadResult()
}


fun main() {
    val tile: Tile = Red("Mashroom", 25 )
    val tile2 = Red("Fire", 30)
    //println("${tile.points} and ${tile.type}")
    var points = when(tile) {
        is Red -> tile.points * 2
        is Blue -> tile.points * 4
    }
    println(points)

    println("=====data Object =========")
    println(ReadResult.Number(1)) // Number(value=1)
    println(ReadResult.Text("Foo")) // Text(value=Foo)
    //println(ReadResult.EndOfFile) // EndOfFile
}
