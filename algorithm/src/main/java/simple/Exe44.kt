package simple

/**
 *  Created by linc on 2019/4/22.
 */
object Exe44 {

    @JvmStatic
    fun main(args: Array<String>) {
        val b = isMatch("mississippi"
                , "m??*ss*?i*pi")
        print(b)
    }

    fun isMatch(s: String, p: String): Boolean {
        if (s.isBlank() && p.isBlank()) return true
        if (!s.isBlank() && p.isBlank()) return false
        if (s.isBlank()) return isAllXin(p, 0)

        return doMatch(s, p, 0, 0)
    }

    fun isAllXin(p: String, from: Int): Boolean {
        for (i in from until p.length)
            if (p[i] != '*') return false
        return true
    }


    fun doMatch(s: String, p: String, si: Int, pi: Int): Boolean {
        if (pi == p.length) return false
        if (si == s.length) return isAllXin(p, pi) && '*' == p[pi]
        when (p[pi]) {
            '?' -> {
                if (si == s.length - 1 && pi == p.length - 1) return true
                return doMatch(s, p, si + 1, pi + 1)
            }
            '*' -> {
                if (pi == p.length - 1) return true
                for (i in si until s.length)
                    if (doMatch(s, p, i, pi + 1)) return true
                return false
            }
            s[si] -> {
                if (si == s.length - 1 && pi == p.length - 1) return true
                return doMatch(s, p, si + 1, pi + 1)
            }
            else -> return false
        }
    }

}