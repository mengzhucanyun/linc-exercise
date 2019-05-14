package sort

import java.util.*
import kotlin.random.Random

/**
 *  Created by linc on 2019/4/14.
 */
object MergeSort {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = IntArray(1000000)
        val random = Random
        for (i in 0..999999)
            array[i] = random.nextInt(10000000)
        val start: Long = System.currentTimeMillis()
        MergeSort.sort(array)
        val end: Long = System.currentTimeMillis()
        print("use time: ${end - start}")
        for (x in 1..100)
            println(array[x])
    }

    fun sort(array: IntArray) {
        doSort(array,0,array.size-1)
    }

   private fun doSort(array:IntArray,l:Int,r:Int){
        if (l==r) return
        val m=(r-l)/2 + l
        doSort(array,l,m)
        doSort(array,m+1,r)
        merge(array,l,m,r)
    }

    private fun merge(array: IntArray, l: Int, m: Int, r: Int) {
        var li = l
        var ri = m + 1
        val size = r - l + 1
        val bArray: IntArray = IntArray(size)
        for (n in 0 until size) {
            when {
                li > m -> bArray[n] = array[ri++]
                ri > r -> bArray[n] = array[li++]
                array[li] > array[ri] -> bArray[n] = array[ri++]
                else -> bArray[n] = array[li++]
            }
        }
        for (m in 0 until size)
            array[l + m] = bArray[m]
    }
}