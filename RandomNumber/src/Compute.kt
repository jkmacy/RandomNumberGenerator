import java.util.*

/**
 * Created by jacob on 12/2/16.
 */
class Compute(val a: Int, val b: Int) {
    val diff = b - a + 1
    val rand = Random()
    val genList: MutableList<Int>

    init {
        genList = mutableListOf(a,b)
        genList.removeAll { it is Int }
        addRand(8192)
    }

    fun next(): Int {
        return pickRand(genList)
    }

    private fun addRand(times: Int) {
        for (t in 0.rangeTo(times))
            genList.add(rand.nextInt(diff) + a)
    }

    private fun pickRand(list: MutableList<Int>): Int {
        if (list.size == 1)
            return list[0] //if list size is one, just return the number
        val pickList = listOf(pickRand( list.subList( 0,list.size/2 ) ), pickRand( list.subList( list.size/2, list.size ) )) //picks two random numbers from the list
        return pickList[rand.nextInt(2)] // picks one or the other
    }
}