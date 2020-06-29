package offer

/**
 *  Created by linc on 2020/6/10.
 */
object Offer18 {
    fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) return null
        var current=head!!
        var next = head.next
        if (head.`val` == `val`) {
            head.next = null
            return next
        }
        while (next!=null){
            if (next.`val`==`val`){
               current.next=next.next
                next.next=null
                return head
            }else{
                current=next
                next=next.next
            }
        }
        return head
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}