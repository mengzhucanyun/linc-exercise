package simple

/**
 *  Created by linc on 2020/2/17.
 *  先列出所有组合，然后筛选出符合条件的
 *
 *  每个位置，只有两种情况，要么有王后，要么没有，处理每一个格子的这两种情况，列出所有的组合
 */
object Exe52 {



    @JvmStatic
    fun main(args: Array<String>) {
        val i = Exe52.totalNQueens(4)
        println(i)
    }

    var finalResult = 0
    data class Node(val x: Int, val y: Int)

    fun totalNQueens(n: Int): Int {
        finalResult = 0
        doSolveQueens(0, emptyList(), n)
        return finalResult
    }


    fun doSolveQueens(i: Int, list: List<Node>, n: Int) {
        if (i == n * n) return
        if (!canAttack(i, list, n)) {
            if (list.size == n - 1) {
                finalResult++
            } else {
                doSolveQueens(i + 1, list.plus(Node(i % n, i / n)), n)
            }
        }
        doSolveQueens(i + 1, list, n)
    }

    fun canAttack(i: Int, list: List<Node>, n: Int): Boolean {
        for (node in list) {
            val x = i % n
            val y = i / n
            if (x == node.x
                    || y == node.y
                    || (x - node.x) * (x - node.x) == (y - node.y) * (y - node.y)
            )
                return true
        }
        return false
    }
}