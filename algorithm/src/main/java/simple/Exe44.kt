package simple

/**
 *  Created by linc on 2019/4/22.
 */
object Exe44 {

    @JvmStatic
    fun main(args: Array<String>) {
        val b = doMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb"
                , "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb")
        println(b)
    }

    fun doMatch(s: String, p: String): Boolean {

        println(s.length)
        if (s.isBlank() && p.isBlank()) return true
        if (!s.isBlank() && p.isBlank()) return false
        if (s.isBlank() && isAllStar(p)) return true

        val head = parsingExpression(p)
        return head.match(s, 0)==1
    }

    fun isAllStar(p: String): Boolean {
        return p.filter { it == '*' }.length == p.length
    }

    fun parsingExpression(exp: String): Node {
        var i = exp.length - 1
        var next: Node = EndNode()
        while (i >= 0) {
            if (exp[i] == '?') {
                next = QuestionNode(next)
                i--
            } else if (exp[i] == '*') {
                if (next is StarNode) {
                    //合并*节点
                } else {
                    next = StarNode(next)
                }
                i--
            } else {
                next = CharNode(exp[i], next)
                i--
            }
        }
        return next
    }


    interface Node {
        fun match(str: String, index: Int): Int
    }


    class EndNode() : Node {
        override fun match(str: String, index: Int): Int {
            return if (str.length == index) 1 else 0

        }

    }

    class CharNode(
            private val value: Char,
            private val next: Node
    ) : Node {
        override fun match(str: String, index: Int): Int {
            return when {
                str.length == index -> 0
                value == str[index] -> next.match(str, index + 1)
                else -> 0
            }
        }

    }

    class QuestionNode(
            private val next: Node
    ) : Node {
        override fun match(str: String, index: Int): Int {
            return if (str.length == index) 0
            else next.match(str, index + 1)
        }
    }

    class StarNode(val next: Node) : Node {
        private var matchNumber: Int = 0
        override fun match(str: String, index: Int): Int {
            var result = next.match(str, index + matchNumber)
//当后续有*节点返回失败时，直接快速失败。不用再尝试匹配更多字符了
            while (true) {
                if (result==1) return 1
                if (result == 2) return 2
                if (str.length == index + matchNumber) {
                    matchNumber = 0
                    return 2
                }
                matchNumber++
                result = next.match(str, index + matchNumber)

            }
        }
    }
}