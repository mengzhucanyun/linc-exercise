package simple;

/**
 * Created by linc on 2018/10/8.
 */
public class Exe23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int index = 0;
        ListNode head = null;
        ListNode current = null;
        while (index >= 0) {
            index = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (index < 0) {
                    index = i;
                    continue;
                }
                if (lists[index].val > lists[i].val) {
                    index = i;
                }
            }
            if (index >= 0) {
                ListNode node = new ListNode(lists[index].val);
                lists[index]=lists[index].next;
                if (head == null) {
                    head=node;
                    current=node;
                }else {
                    current.next=node;
                    current=node;
                }
            }
        }
        return head;
    }

    public static void main(String args[]){

    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}


