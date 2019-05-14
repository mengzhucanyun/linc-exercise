package sort

import kotlin.random.Random

/**
 *  Created by linc on 2019/4/14.
 */
object FastSort {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = IntArray(1000000)
        val random = Random
        for (i in 0..999999)
            array[i] = random.nextInt(10000000)
        val start: Long = System.currentTimeMillis()
        FastSort.sort(array)
        val end: Long = System.currentTimeMillis()
        print("use time: ${end - start}")
        for (x in 1..100)
            println(array[x])
    }

    fun sort(array: IntArray) {
        doThreePartSort(array, 0, array.size - 1)
    }

    fun doSort(array: IntArray, l: Int, r: Int) {
        if (r <= l) return
        val mid = split(array, l, r)
        doSort(array, l, mid - 1)
        doSort(array, mid + 1, r)
    }

    fun doThreePartSort(array: IntArray, l: Int, r: Int) {
        if (r <=l) return
        var li = l
        var ri = r
        val v = array[l]
        var m = l + 1
        while (m <= ri) {
            when {
                array[m] > v -> exchange(m, ri--, array)
                array[m] < v -> exchange(m++, li++, array)
                else -> m++
            }
        }
        doThreePartSort(array, l, li-1)
        doThreePartSort(array, ri+1, r)
    }

    fun split(array: IntArray, l: Int, r: Int): Int {
        var li = l
        var ri = r
        val v = array[l]
        while (ri > li) {
            while (li < ri) {
                if (array[ri] < v) break
                else ri--
            }
            while (li < ri) {
                if (array[li] > v) break
                else li++
            }

            if (li < ri) exchange(li, ri, array)
        }
        exchange(li, l, array)
        return li
    }

    private fun exchange(index1: Int, index2: Int, array: IntArray) {
        if (index1 >= array.size || index2 >= array.size || index1 < 0 || index2 < 0)
            throw RuntimeException("bad param")
        val temp: Int = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }
}