package offer

/**
 *  Created by linc on 2020/6/10.
 */
object Offer14 {
    fun reOrder(array: IntArray, func: Function): IntArray {
        var left = 0
        var right = array.size - 1
        while (left < right) {
            while (func.inFront(array[left]) && left < right)
                left++
            while (!func.inFront(array[right]) && left < right)
                right--

            if (left < right) {
                val temp = array[left]
                array[left] = array[right]
                array[right] = temp
            }
        }
        return array
    }

    interface Function {
        fun inFront(int: Int): Boolean
    }
}