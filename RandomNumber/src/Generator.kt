import java.lang.System.*
import java.util.*

object Generator {
    val input = Scanner(`in`)
    var a: Int? = 0
    var b: Int? = 0

    @JvmStatic
    fun main(args: Array<String>) {
        val num = Regex("[0-9]+")
        println("Hello, this is your everyday, everyman random number generator!\nLet's get started!\n")
        while (true) {
            print("Pick a number range (no less than 0, no greater than 1,000,000; ex. 1-25): ")
            val range = input.nextLine()
            val result: Sequence<MatchResult>? = num.findAll(range)

            if (Regex("^[nN]").containsMatchIn(range))
                break

            result?.let {
                a = it.elementAtOrNull(0)?.value?.toInt()
                b = it.elementAtOrNull(1)?.value?.toInt()
            }

            if (!compute()) break
        }
    }

    fun compute(): Boolean {
        println("Computing...\n")

        if (a != null && b != null) {
            println("\nThe number is ${Compute(a as Int, b as Int).next()}\n")
            //println("\nThe number is ${Compute(a as Int, b as Int).genList}\n")

            //Asks whether to go again, or quit the program
            print("Ask again? (Y/n) ")
            if (Regex("^[nN]").containsMatchIn(input.nextLine()))
                return false

            //Asks whether to use same number range, or ask a new range
            print("Same range? (Y/n) ")
            if (Regex("^[yY]").containsMatchIn(input.nextLine()))
                compute()
            else return true
        }
        else {
            println("Invalid")
            return true
        }
        return false
    }

}
