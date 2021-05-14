package com.devx.linked.list;

/**
 * @author I348618
 * @since 5/14/2021
 */
public class InsertLinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void push(InsertLinkedList list, int d) {
        Node temp = new Node(d);
        temp.next = list.head;
        list.head = temp;
    }

    public static void append(InsertLinkedList list, int d) {
        Node node = list.head;
        if(node==null) {
            list.head = new Node(d);
            return;
        }
        while(node.next!=null) {
            node = node.next;
        }
        node.next = new Node(d);
    }

    public static void insertAfter(Node prevNode, int d) {
        if(prevNode==null) {
            System.out.println("Insert after's previous node cannot be null");
            return;
        }
        Node next = prevNode.next;
        prevNode.next = new Node(d);
        prevNode.next.next = next;
    }

    public static String print(InsertLinkedList list) {
        Node temp = list.head;
        String result = "[";
        while (temp != null) {
            result += temp.data + ", ";
            temp = temp.next;
        }
        return result + "]";
    }

    public static void main(String[] args) {

        InsertLinkedList list = new InsertLinkedList();
        push(list, 2);
        push(list, 1);
        append(list, 3);
        append(list, 5);
        insertAfter(list.head.next.next, 4);
        System.out.println("Linked List: " + print(list));
    }
}
