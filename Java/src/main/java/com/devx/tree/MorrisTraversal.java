package com.devx.tree;

/**
 * @author I348618
 * @since 5/24/2021
 */
public class MorrisTraversal {
    private Node root;

    static class Node {
        int data;
        Node left, right;
        public Node(int d) {
            data = d;
        }
    }

    void inorderWithoutRecursionAndStack() {
        Node curr = root;
        while(curr != null) {
            if(curr.left == null) {
                System.out.print(curr.data + ", ");
                curr = curr.right;
            } else {
                Node pre = curr.left;
                while(pre.right!=null && pre.right!=curr)
                    pre = pre.right;
                if(pre.right == curr) {
                    System.out.print(curr.data + ", ");
                    pre.right = null;
                    curr = curr.right;
                } else {
                    pre.right = curr;
                    curr = curr.left;
                }
            }
        }
    }

    public static void main(String[] args) {
        MorrisTraversal tree = new MorrisTraversal();
        tree.root = new Node(6);
        tree.root.left = new Node(3);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(5);
        tree.root.right = new Node(8);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(11);
        tree.root.right.right.left = new Node(9);
        tree.root.right.right.right = new Node(13);
        System.out.print("Inorder traversal is: ");
        tree.inorderWithoutRecursionAndStack();
    }
}
