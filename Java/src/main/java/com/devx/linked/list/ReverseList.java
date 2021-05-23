package com.devx.linked.list;

/**
 * @author I348618
 * @since 5/23/2021
 */
public class ReverseList {

    private Node head;

    class Node {
        int data;
        Node next;
        public Node(int d) {
            data = d;
        }
    }

    void reverseIterative() {
        Node prev=null, next;
        Node current = head;
        while(current!=null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    Node reverseRecursive(Node head) {
        if(head == null || head.next==null)
            return head;
        Node rest = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static void main(String[] args) {
        ReverseList list = new ReverseList();
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);
        System.out.println("Linked list: " + list.print());
        list.reverseIterative();
        System.out.println("After reverse: " + list.print());
        list.head = list.reverseRecursive(list.head);
        System.out.println("After reverse: " + list.print());
    }

    void push(int d) {
        Node temp = new Node(d);
        temp.next = head;
        head = temp;
    }

    String print() {
        Node temp = head;
        String result = "[";
        while (temp != null) {
            result += temp.data + ", ";
            temp = temp.next;
        }
        return result + "]";
    }
}
