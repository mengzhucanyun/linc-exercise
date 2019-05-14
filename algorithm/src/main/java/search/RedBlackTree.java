package search;

import java.util.Random;

/**
 * Created by linc on 2019/4/24.
 */


public class RedBlackTree<K extends Comparable, V> {

    public static void main(String[] args) {
        RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();
        Random random = new Random();
        for (int i = 0; i < 10000; i++)
            tree.put(random.nextInt(1000000), i);

        tree.printNode(tree.head);
    }

    private void printNode(Node node) {
        if (node.left != null)
            printNode(node.left);
        System.out.println(String.format("key:%d   value:%d", node.key, node.value));
        if (node.right != null)
            printNode(node.right);
    }

    private Node<K, V> head = null;
    private int size = 0;

    public void put(K key, V value) {
        if (key == null) {
            throw new RuntimeException("Key can not be null");
        }
        head = put(key, value, head);
        head.red = false;
    }

    private Node put(K key, V value, Node node) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
            return node;
        } else if (cmp > 0) {
            node.right = put(key, value, node.right);
        } else {
            node.left = put(key, value, node.left);
        }
        return fixTree(node);
    }

    private Node fixTree(Node node) {
        if (isRed(node.right) && !isRed(node.left))
            node = rollLeft(node);
        if (isRed(node.left) && isRed(node.left.left))
            node = rollRight(node);
        if (isRed(node.left) && isRed(node.right))
            exchangeColor(node);
        return node;
    }

    public V get(K key) {
        if (head == null)
            return null;
        Node<K, V> node = find(key, head);
        if (key.compareTo(node.key) == 0) {
            return node.value;
        }
        return null;
    }

    private void exchangeColor(Node node) {
        node.red = true;
        node.left.red = false;
        node.right.red = false;
    }

    private Node rollLeft(Node node) {
        Node temp = node.right;
        node.right = temp.left;
        temp.left = node;
        temp.red = node.red;
        node.red = true;
        return temp;
    }

    private Node rollRight(Node node) {
        Node temp = node.left;
        node.left = temp.right;
        temp.right = node;
        temp.red = node.red;
        node.red = true;
        return temp;
    }

    private Node<K, V> find(K key, Node node) {
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) > 0) {
            if (node.right == null)
                return node;
            return find(key, node.right);
        } else {
            if (node.left == null)
                return node;
            return find(key, node.left);
        }
    }

    private boolean isRed(Node node) {
        if (node == null)
            return false;
        return node.red;
    }

    private class Node<K, V> {
        Node left = null;
        Node right = null;
        boolean red = true;
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
