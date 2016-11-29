package main

import java.lang.System.*
import java.util.*

object Generator {
    @JvmStatic
    fun main(args: Array<String>) {
        val input = Scanner(`in`)
        val num = Regex("[0-9]+")
        println("Hello, this is your everyday, everyman random number generator!\nLet's get started!")
        while (true) {
            print("Pick a number range (no less than 0, no greater than 1,000,000; ex. 1-25): ")
            val range = input.nextLine()
            val result : Sequence<MatchResult>? = num.findAll(range)

            var a: Int? = 0
            var b: Int? = 0
            result?.let {
                a = it.elementAtOrNull(0)?.value?.toInt()
                b = it.elementAtOrNull(1)?.value?.toInt()
            }

            println("Computing...\n")
            val rand: Random = Random()
            if (a != null && b!= null) {
                val diff = b as Int - a as Int + 1
                print("The number is ${rand.nextInt(diff) + a as Int} ")
            }
            else
                print("Invalid... ")
            print("Ask again? (Y/n) ")
            if (input.nextLine().toLowerCase().contains("n")) break
            //print("Same range? ")
        }
    }
}

