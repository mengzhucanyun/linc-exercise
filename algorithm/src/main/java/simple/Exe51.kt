package simple

/**
 *  Created by linc on 2020/2/17.
 *  先列出所有组合，然后筛选出符合条件的
 *
 *  每个位置，只有两种情况，要么有王后，要么没有，处理每一个格子的这两种情况，列出所有的组合
 */
object Exe51 {
    var finalResult = ArrayList<List<String>>()

    data class Node(val x: Int, val y: Int)

    @JvmStatic
    fun main(args: Array<String>) {
        val i = Exe51.solveNQueens(4)
        println(i)
    }

    fun solveNQueens(n: Int): List<List<String>> {
        finalResult = ArrayList<List<String>>()
        doSolveQueens(0, emptyList(), n)
        return finalResult
    }


    fun doSolveQueens(i: Int, list: List<Node>, n: Int) {
        if (i == n * n) return
        if (!canAttack(i, list, n)) {
            if (list.size == n - 1) {
                finalResult.add(convert(list.plus(Node(i % n, i / n)), n))
            } else {
                doSolveQueens(i + 1, list.plus(Node(i % n, i / n)), n)
            }
        }
        doSolveQueens(i + 1, list, n)
    }

    fun convert(list: List<Node>, n: Int): List<String> {

        val result = Array(n) { CharArray(n) { '.' } }
        for (node in list) {
             result[node.y][node.x]= 'Q'
        }
        return result.map { String(it) }
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