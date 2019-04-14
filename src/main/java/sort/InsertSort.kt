package sort

import kotlin.random.Random

/**
 *  Created by linc on 2019/4/12.
 */
object InsertSort {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = IntArray(10000)
        val random = Random
        for (i in 0..9999)
            array[i] = random.nextInt(10000)
        val start: Long = System.currentTimeMillis()
        InsertSort.sort(array)
        val end: Long = System.currentTimeMillis()
        print("use time: ${end - start}")
        for (x in 1..100)
            println(array[x])
    }

   private fun sort(array: IntArray) {
        for (i in 1 until array.size) {
            val target = findIndex(i, array)
                insert(i, target, array)
        }
    }

   private fun findIndex(i: Int, array: IntArray): Int {
        for (j in i - 1 downTo 0) {
            if (array[j] <= array[i])
                return j + 1
        }
        return 0
    }

   private fun insert(i: Int, target: Int, array: IntArray) {
        if (i <= target)
            return
        val temp: Int = array[i]
        for (j in i downTo target + 1)
            array[j] = array[j - 1]
        array[target] = temp
    }
}