package sort

import kotlin.random.Random

/**
 *  Created by linc on 2019/4/16.
 */
object HeapSort {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = IntArray(1000000)
        val random = Random
        for (i in 0..999999)
            array[i] = random.nextInt(10000000)
        val start: Long = System.currentTimeMillis()
        HeapSort.sort(array)
        val end: Long = System.currentTimeMillis()
        print("use time: ${end - start}")
        for (x in 1..100)
            println(array[x])
    }

    fun sort(a:IntArray){
        val heap=MaxHeap(a.size)
        for (i in a)
            heap.insert(i)
        for (j in a.size-1 downTo 0)
            a[j]=heap.deleteMax()
    }
}