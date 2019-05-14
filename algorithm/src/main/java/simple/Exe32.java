package simple;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by linc on 2018/11/8.
 */
public class Exe32 {
    public int longestValidParentheses(String s) {

        char[] c = s.toCharArray();
        char pre = '(';
        char end = ')';
        int max = 0, curent = 0, endNum = 0, index = 0, startIndex = 0, endIndex = 0;
        List<Node> nodes = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        boolean b = true;
        while (index < c.length) {
            if (c[index] == pre) {
                stack.push(index);
            } else {
                if (!stack.isEmpty()) {
                    startIndex = stack.pop();
                    endIndex = index;
                    if (!nodes.isEmpty()) {
                        Node last = ((LinkedList<Node>) nodes).getLast();
                        while (startIndex < last.start && index > last.end) {
                            nodes.remove(last);
                            if (nodes.isEmpty())
                                break;
                            last = ((LinkedList<Node>) nodes).getLast();
                        }
                    }

                    nodes.add(new Node(startIndex, index));
                }
            }
            index++;
        }
        for (Node node : nodes) {
            if (node.start == endNum + 1) {
                curent = curent + node.end - node.start + 1;
            } else {
                if (max < curent) {
                    max = curent;
                }
                curent = node.end - node.start + 1;
            }
            endNum = node.end;
        }
        if (max < curent) {
            max = curent;
        }
        return max;

    }

    class Node {
        int start;
        int end;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        new Exe32().longestValidParentheses(")(())(()()))(");
    }
}
