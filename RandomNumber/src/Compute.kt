import java.util.*

/**
 * Created by jacob on 12/2/16.
 */
class Compute(val a: Int, val b: Int) {
    val diff = b - a + 1
    val rand = Random(diff.toLong())
    val genList: MutableList<Int>

    init {
       genList = mutableListOf(a,b)
       genList.removeAll { it is Int }
    }

    fun next(): Int {
        addRand(100)
        return rand.nextInt(diff) + a;
    }

    private fun addRand(times: Int) {
        var t = times - 2
        while (t-- > 0)
            genList.add(rand.nextInt(diff) + a)
    }

    //private fun pickRand()
}