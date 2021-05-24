package com.devx.tree;

/**
 * @author I348618
 * @since 5/24/2021
 */
public class ThreadedBinaryTree {
    private Node root;

    static class Node {
        int data;
        Node left, right;
        boolean isRightThread;
        public Node(int d) {
            data = d;
        }
        public Node(int d, boolean isRight, Node right) {
            data = d;
            isRightThread = isRight;
            this.right = right;
        }
    }

    Node getLeftMostNode(Node node) {
        if(node == null)
            return null;
        while(node.left!=null) {
            node = node.left;
        }
        return node;
    }

    void inorderWithoutRecursionAndStack() {
        Node curr = getLeftMostNode(root);
        while(curr!=null) {
            System.out.print(curr.data + ", ");
            if(curr.isRightThread)
                curr = curr.right;
            else
                curr = getLeftMostNode(curr.right);
        }
    }

    public static void main(String[] args) {
        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        tree.root = new Node(6);
        tree.root.left = new Node(3);
        tree.root.left.left = new Node(1, true, tree.root.left);
        tree.root.left.right = new Node(5, true, tree.root);
        tree.root.right = new Node(8);
        tree.root.right.left = new Node(7, true, tree.root.right);
        tree.root.right.right = new Node(11);
        tree.root.right.right.left = new Node(9, true, tree.root.right.right);
        tree.root.right.right.right = new Node(13);
        System.out.print("Inorder traversal is: ");
        tree.inorderWithoutRecursionAndStack();
    }
}
