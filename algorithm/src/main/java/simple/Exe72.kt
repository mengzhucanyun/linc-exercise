package simple

/**
 *  Created by linc on 2020/3/31.
 */
object Exe72 {
    @JvmStatic
    fun main(args: Array<String>) {
        minDistance("plasma", "altruism")
    }

    fun minDistance(word1: String, word2: String): Int {
        val map = Array(word1.length + 1) { IntArray(word2.length + 1) }
        map[0][0] = 0
        for (i in 1..word1.length) map[i][0] = i
        for (i in 1..word2.length) map[0][i] = i
        for (i in 1..word1.length) {
            for (j in 1..word2.length) {
                map[i][j] = minOf(map[i - 1][j] + 1, map[i][j - 1] + 1, map[i - 1][j - 1] + if (word1[i - 1] == word2[j - 1]) 0 else 1)
            }
        }
        println(map)
        return map[word1.length][word2.length]
    }
}