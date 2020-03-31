package simple

/**
 *  Created by linc on 2020/2/27.
 */
object Exe68 {
    @JvmStatic
    fun main(args: Array<String>) {
        val words = arrayOf("This", "is", "an", "example", "of", "test", "justification.")
        val list = fullJustify(words, 16)
        println(list)

    }

    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        var count = -1
        var line: ArrayList<String> = ArrayList()
        val lines: ArrayList<ArrayList<String>> = ArrayList()

        val result: ArrayList<String> = ArrayList()

        for (word in words) {
            if (count + word.length + 1 <= maxWidth) {
                count += word.length + 1
                line.add(word)
            } else {
                lines.add(line)
                line = ArrayList()
                line.add(word)
                count = word.length
            }
        }
        if (line.isNotEmpty())
            lines.add(line)


        for (i in 0 until lines.size - 1) {
            val line1 = lines[i]
            if (line1.size == 1) {
                result.add(line1[0] + numberOfSpace(maxWidth - line1[0].length))
                continue
            }
            val total = line1.map { it.length }.reduce { acc, s -> acc + s }
            val space1 = (maxWidth - total) / (line1.size - 1)
            var addcount = (maxWidth - total) % (line1.size - 1)
            var str = ""
            for (i in 1..line1.size) {
                val spaceNum = if (i == line1.size) 0 else (space1 + if (addcount > 0) 1 else 0)
                addcount--
                str = str + line1[i - 1] + numberOfSpace(spaceNum)
            }
            result.add(str)
        }
        var str = ""
        val line2 = lines[lines.size - 1]
        for (i in 1..line2.size) {
            val total = line2.map { it.length }.reduce { acc, s -> acc + s }
            val spaceNUm = if (i == line2.size) maxWidth - total - line2.size + 1 else 1
            str = str + line[i - 1] + numberOfSpace(spaceNUm)
        }
        result.add(str)
        return result
    }

    private fun numberOfSpace(i: Int): String {
        return if (i == 0) "" else String(CharArray(i) { ' ' })
    }


}