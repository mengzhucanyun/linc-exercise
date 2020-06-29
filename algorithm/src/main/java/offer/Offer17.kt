package offer

import java.lang.RuntimeException

/**
 *  Created by linc on 2020/6/10.
 */
object Offer17 {

    fun printNumbers(n: Int): IntArray {
        if (n <= 0) return IntArray(0)
        if (n > 9) throw RuntimeException("n 太大了")
        var max = 0
        for (i in 1..n) {
            max = max * 10 + 9
        }
        val result = IntArray(max)
        for (i in 1..max)
            result[i - 1] = i
        return result
    }
}