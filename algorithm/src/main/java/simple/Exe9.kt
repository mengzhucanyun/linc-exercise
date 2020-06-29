package simple

/**
 *  Created by linc on 2020/6/10.
 */
object Exe9 {



    fun isPalindrome(x: Int): Boolean {

        val str = x.toString()
        if (str.length==1) return true
        var left = 0
        var right = str.length - 1
        while (left<right){
            if (str[left]==str[right]){
                left++
                right--
            }else{
                return false
            }
        }
        return true
    }
}