package com.devx.tree;

/**
 * @author I348618
 * @since 5/30/2021
 */
public class MaxHeight {

    private Node root;
    private int maxHeight;

    static class Node {
        int val;
        Node left, right;
        public Node(int d) {
            val = d;
        }
    }

    int height(Node node) {
        if(node == null)
            return -1;
        if(node.left == null && node.right == null)
            return 0;

        int height = Math.max(height(node.left), height(node.right)) + 1;
        maxHeight = Math.max(maxHeight, height);
        return height;
    }

    public static void main(String[] args) {
        MaxHeight tree = new MaxHeight();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.height(tree.root);
        System.out.println("Max height of the tree: " + tree.maxHeight);
    }
}
