package problem

import org.junit.jupiter.api.Test

class HanotaTest {
    @Test
    fun testHanota() {
        val origin = mutableListOf<Int>(1, 2, 3, 4)
        val middle = mutableListOf<Int>()
        val target = mutableListOf<Int>()

        val hanota = Hanota()
        hanota.solveHanota(origin, middle, target)
    }
}