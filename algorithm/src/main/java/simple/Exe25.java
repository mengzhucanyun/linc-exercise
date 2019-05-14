package simple;

/**
 * Created by linc on 2018/10/9.
 */
public class Exe25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        int length = getLength(head);
        if (length < k) {
            return head;
        }
        int loop = length / k;
        ListNode newHead = null;
        ListNode newEnd = null;
        ListNode current = head;
        ListNode currentEnd = null;
        for (int i = 0; i < loop; i++) {
            ListNode temp = null;
            ListNode temp1 = null;
            for (int j = i * k; j < (i + 1) * k; j++) {
                if (temp == null) {
                    temp = current;
                    current=current.next;
                    currentEnd = temp;
                } else {
                    temp1 = current.next;
                    current.next = temp;
                    temp = current;
                    current = temp1;
                }
            }
            if (newHead == null) {
                newHead = temp;
                newEnd = currentEnd;
            } else {
                newEnd.next = temp;
                newEnd = currentEnd;
            }
        }
        newEnd.next = current;
        return newHead;
    }


    private int getLength(ListNode head) {
        int i = 0;
        ListNode current = head;
        while (current != null) {
            i++;
            current = current.next;
        }
        return i;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
