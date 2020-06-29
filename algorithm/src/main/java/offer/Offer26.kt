package offer

/**
 *  Created by linc on 2020/6/10.
 */
object Offer26 {

    fun isSubStructure(A: TreeNode?, B: TreeNode?): Boolean {
        if (A == null || B == null) return false
        if (A.`val` == B.`val` && doIsSub(A, B)) return true
        return isSubStructure(A.left, B) || isSubStructure(A.right, B)
    }

    fun doIsSub(a: TreeNode?, b: TreeNode?): Boolean {
        if (b == null) return true
        if (a == null) return false
        if (a.`val` != b.`val`) return false
        return doIsSub(a.left,b.left)&& doIsSub(a.right,b.right)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}