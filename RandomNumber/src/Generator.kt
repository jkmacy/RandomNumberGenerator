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
            val result : Sequence<MatchResult>? = num.findAll(range)

            if (Regex("^[nN]").containsMatchIn(range))
                break

            result?.let {
                a = it.elementAtOrNull(0)?.value?.toInt()
                b = it.elementAtOrNull(1)?.value?.toInt()
            }

            compute()
        }
    }

    fun compute() {
        //println("Computing...\n")
        val rand: Random = Random()

        if (a != null && b != null) {
            val diff = b as Int - a as Int + 1
            println("The number is ${rand.nextInt(diff) + a as Int}\n")

            print("Ask again? (Y/n) ")
            if (Regex("^[nN]").containsMatchIn(input.nextLine()))
                return

            print("Same range? (Y/n) ")
            if (Regex("^[yY]").containsMatchIn(input.nextLine()))
                compute()
        }
        else {
            println("Invalid")
            return
        }
    }
}

