package sort

/**
 *  Created by linc on 2019/4/16.
 */
class MaxHeap(size: Int) {
    var a: IntArray = IntArray(size+1)
    var count = 0
    fun insert(v: Int) {
        a[++count] = v
        up(count)
    }

    fun getMax(): Int {
        return a[1]
    }

    fun deleteMax(): Int {
        val v = a[1]
        exchange(1, count--, a)
        down(1)
        return v
    }

    fun up(i: Int) {
        var index = i
        while (index > 1 && a[index] > a[index / 2]) {
            exchange(index, index / 2, a)
            index /= 2
        }
    }

    fun down(i: Int) {
        var index = i
        while (index < count/2) {



            if (a[index] >= a[index * 2] && a[index] >= a[index * 2 + 1]) break
            if (a[index * 2] > a[index * 2 + 1]) {
                exchange(index * 2, index, a)
                index *= 2
            } else {
                exchange(index * 2 + 1, index, a)
                index = index * 2 + 1
            }
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