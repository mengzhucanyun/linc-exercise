package simple

import kotlin.concurrent.fixedRateTimer

/**
 *  Created by linc on 2020/2/17.
 *
 */
object Exe57 {


    @JvmStatic
    fun main(args: Array<String>) {
        val b=Exe57.isNumber("+3. e04116")
        println(b)
    }

    fun isNumber(s: String): Boolean {
        return isEDouble(s.trim())
    }

    private fun isInteger(s: String): Boolean {
        if (s.isNullOrEmpty()) return false
        val s1=if (s[0]=='+'||s[0]=='-') s.substring(1) else s
        if (s1.isNullOrEmpty()) return false
        for (char in s1) {
            if (!char.isDigit()) return false
        }
        return true
    }

    private fun isPositiveInteger(s:String):Boolean{
        if (s.isNullOrEmpty()) return false
        for (char in s) {
            if (!char.isDigit()) return false
        }
        return true
    }

    private fun isPointDouble(s:String):Boolean{
        if (s.isNullOrEmpty()) return false
        val s1=if (s[0]=='+'||s[0]=='-') s.substring(1) else s
        if (s1.isNullOrEmpty()) return false
        val i=s1.indexOfFirst { it=='.' }
         if (i==-1) {return isInteger(s1)}
        else {
             val list=s1.split('.')
             if (list.size>2) return false
             val b1=isInteger(list[0])
             val b2=isPositiveInteger(list[1])
             return (list[0].isEmpty()&&b2)||(list[1].isEmpty()&&b1)||(b1&&b2)
         }
    }
    private fun isEDouble(s:String):Boolean{
        if (s.isNullOrEmpty()) return false
        val i=s.indexOfFirst { it=='e' }
        if (i==-1) {return isPointDouble(s)}
        else {
            val list=s.split('e')
            if (list.size>2) return false
            return isPointDouble(list[0]) && isInteger(list[1])
        }
    }


}