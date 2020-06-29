package offer

import simple.Exe44
import java.lang.RuntimeException
import kotlin.math.abs

/**
 *  Created by linc on 2020/6/9.
 */
object Offer16 {

    @JvmStatic
    fun main(args: Array<String>) {
        val b = Offer16.myPow(2.00000, -2147483648)
    }

    fun myPow(x: Double, n: Int): Double {
        if (x == 0.00000 && n < 0)
            throw RuntimeException("bad x n value")
        if (x == 0.00000) return 0.00000
        if (x == 1.00000) return 1.00000
        return if (n == 0) {
            1.00000
        } else if (n > 0) {
            doMyPow(x, n)
        } else {
            if (n == Int.MIN_VALUE) {
                1 / (doMyPow(x, Int.MAX_VALUE) * x)
            } else
                1 / doMyPow(x, Math.abs(n))
        }


    }

    fun doMyPow(x: Double, n: Int): Double {
        return if (n == 1) x
        else if (n == 2) x * x
        else if (n == 3) x * x * x
        else if (n % 2 == 1) {
            val temp = doMyPow(x, (n - 1) / 2)
            temp * temp * x
        } else {
            val temp = doMyPow(x, n / 2)
            temp * temp
        }
    }
}