package offer

import java.util.*

/**
 *  Created by linc on 2020/6/10.
 */
object Offer31 {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        var pushedIndex = 0
        val stack = Stack<Int>()
        for (i in popped.indices) {
            if (!stack.empty()&&stack.peek() == popped[i]) stack.pop()
            else {
                while (pushedIndex < pushed.size && pushed[pushedIndex] != popped[i]){
                    stack.push(pushed[pushedIndex])
                    pushedIndex++
                }
                if (pushedIndex < pushed.size) pushedIndex++
                else return false
            }
        }
        return true
    }
}