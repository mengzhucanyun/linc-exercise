package simple

/**
 *  Created by linc on 2020/6/9.
 */
object Exe46 {

    fun translateNum(num: Int): Int {
        if (num<=9) return 1
        val lastTwo=num%100
        return if (lastTwo<=9||lastTwo>=26)
             translateNum(num/100)
        else translateNum(num/100)+ translateNum(num/10)
    }
}