package sort

import java.util.*
import kotlin.random.Random

/**
 * Created by linc on 2019/4/11.
 */
object ChoseSort {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = IntArray(10000)
        val random = Random
        for (i in 0..9999)
            array[i] = random.nextInt(10000)
        val start: Long = System.currentTimeMillis()
        ChoseSort.sort(array)
        val end: Long = System.currentTimeMillis()
        print("use time: ${end - start}")
        for (x in 1..100)
            println(array[x])
    }

   private fun sort(array: IntArray) {
        var temp: Int
        for (i in 0 until array.size) {
            temp = i
            for (j in i until array.size) {
                if (array[j] < array[temp])
                    temp = j
            }
            exchange(i, temp, array)
        }
    }

    private fun exchange(index1: Int, index2: Int, array: IntArray) {
        if (index1 >= array.size || index2 >= array.size || index1 < 0 || index2 < 0)
        throw RuntimeException("bad param")
        val temp: Int = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }
}
