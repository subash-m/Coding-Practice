package com.devx.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author I348618
 * @since 5/14/2021
 */
public class BinaryTreeBfsDfs {

    private Node root;

    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int d) {
            data = d;
        }
    }

    public static void printBfs(BinaryTreeBfsDfs tree) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(tree.root);
        String output= "[";
        while(!queue.isEmpty()) {
            Node tempNode = queue.poll();
            output += tempNode.data+", ";
            if(tempNode.left!=null)
                queue.add(tempNode.left);
            if(tempNode.right!=null)
                queue.add(tempNode.right);
        }
        System.out.println("GraphBFS of Binary tree: " + output + "]");
    }

    public static void inorderDfs(Node node) {
        if(node!=null) {
            if(node.left!=null)
                inorderDfs(node.left);
            System.out.print(node.data+", ");
            if(node.right!=null)
                inorderDfs(node.right);
        }
    }
    public static void preorderDfs(Node node) {
        if(node!=null) {
            System.out.print(node.data+", ");
            if(node.left!=null)
                preorderDfs(node.left);
            if(node.right!=null)
                preorderDfs(node.right);
        }
    }
    public static void postorderDfs(Node node) {
        if(node!=null) {
            if(node.left!=null)
                postorderDfs(node.left);
            if(node.right!=null)
                postorderDfs(node.right);
            System.out.print(node.data+", ");
        }
    }

    public static void main(String[] args) {
        BinaryTreeBfsDfs tree = new BinaryTreeBfsDfs();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        printBfs(tree);
        System.out.print("\nPreorder traversal: ");
        preorderDfs(tree.root);
        System.out.print("\nInorder traversal: ");
        inorderDfs(tree.root);
        System.out.print("\nPostorder traversal: ");
        postorderDfs(tree.root);

    }
}
