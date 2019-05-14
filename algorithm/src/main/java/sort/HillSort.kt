package sort

import kotlin.random.Random

/**
 *  Created by linc on 2019/4/12.
 */
object HillSort {
    @JvmStatic
    fun main(args: Array<String>) {
        val array = IntArray(1000000)
        val random=Random
        for (i in 0..999999)
            array[i]=random.nextInt(10000000)
        val start:Long=System.currentTimeMillis()
        HillSort.sort(array)
        val end:Long=System.currentTimeMillis()
        print(end-start)
        for (x in 1..100)
            println(array[x])
    }

   private fun sort(array: IntArray) {
        val stepArray=sedgewick(array.size)
        val reversed=stepArray.reversed()
        for (step in reversed) {
            for (i in step until array.size) {
                val target = findIndex(i, array, step)
                insert(i, target, array, step)
            }
        }

    }

   private fun findIndex(i: Int, array: IntArray, step: Int): Int {
        for (j in i - 1 downTo 0 step step) {
            if (array[j] <= array[i])
                return j + 1
        }
        return i % step
    }

   private fun insert(i: Int, target: Int, array: IntArray, step: Int) {
        if (i <= target)
            return
        val temp: Int = array[i]
        for (j in i downTo target + step step step)
            array[j] = array[j - step]
        array[target] = temp
    }

    // 已知的最好步长序列是由Sedgewick提出的(1,5,19,41,109,...)
    // 塞奇威克(Sedgewick)步长序列函数,传入数组长度(最大分组个数不可超过数组长度)
    private fun sedgewick(length: Int): IntArray {
        // 不清楚步长的数组中的容量是多少
        // 但是如果使用容器还是需要转换的
        val arr = IntArray(length)
        var n: Int      //步长的总个数
        var i = 0  // 控制奇数位步长的值
        var j = 0  // 控制偶数位步长的值
        n = 0
        while (n < length) {
            // 偶数位上的值
            if (n % 2 == 0) {
                arr[n] = (9 * (Math.pow(4.0, i.toDouble()) - Math.pow(2.0, i.toDouble())) + 1).toInt()
                i++
            } else {
                // 偶数位上的值
                arr[n] = (Math.pow(2.0, (j + 2).toDouble()) * (Math.pow(2.0, (j + 2).toDouble()) - 3) + 1).toInt()
                j++
            }
            // 步长的最大值已经大于数组总长
            // 跳出循环
            if (arr[n] >= length) {
                break
            }
            n++
        }
        val a = IntArray(n)
        // 使用System.arraycopy复制数组
        // 仅仅复制有效步长，也就是n个有效的
        System.arraycopy(arr, 0, a, 0, n)
        return a
    }
}