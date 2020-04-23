package simple

import com.sun.xml.internal.fastinfoset.util.StringArray

/**
 *  Created by linc on 2020/4/2.
 */
object Exe76 {

    @JvmStatic
    fun main(args:Array<String>){
        minWindow("ADOBECODEBANC","ABC")
    }
    fun minWindow(s: String, t: String): String {
        val location = LinkedHashMap<Char, Int>()
        var start = -1
        var end = -1
        var current = ""
        for (i in s.indices) {
            if (t.indexOf(s[i]) == -1) continue
            location[s[i]] = i
            if (location.size == t.length) {
                if (start == -1 || (start < location.values.first() && location.values.max()!! - location.values.min()!! + 1 < current.length)) {
                    start = location.values.min()!!
                    end = location.values.max()!!
                    current = s.substring(start, end+1)
                }
            }
        }
        return current
    }
}