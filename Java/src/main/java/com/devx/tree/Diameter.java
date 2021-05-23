package com.devx.tree;

/**
 * @author I348618
 * @since 5/23/2021
 */
public class Diameter {
    static class Node  {
        int data;
        Node left;
        Node right;
        public Node(int d) {
            data = d;
        }
    }
    static int diameter = 0;

    static int height(Node root) {
        if (root == null)
            return 0;

        int lh = height(root.left);
        int rh = height(root.right);
        diameter = Math.max(diameter, lh + rh + 1);
        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        height(root);
        System.out.println("Diameter is " + diameter);
    }
}
