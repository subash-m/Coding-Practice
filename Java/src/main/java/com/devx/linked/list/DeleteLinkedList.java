package com.devx.linked.list;

import java.util.ArrayList;

/**
 * @author I348618
 * @since 5/23/2021
 */
public class DeleteLinkedList {
    private Node head;

    class Node {
        int data;
        Node next;
        public Node(int d) {
            data = d;
            next = null;
        }
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

    void deleteByKey(int key) {
        Node prev = head;
        if(prev!=null && prev.data==key) {
            head = prev.next;
            return;
        }

        while(prev!=null && prev.next!=null) {
            Node node = prev.next;
            if(node.data == key) {
                prev.next = node.next;
                break;
            }
            prev=prev.next;
        }
    }

    public static void main(String[] args) {
        DeleteLinkedList list = new DeleteLinkedList();
        list.push(2);
        list.push(1);
        list.push(3);
        list.push(5);
        System.out.println("Before delete: " + list.print());
        list.deleteByKey(2);
        System.out.println("After delete: " + list.print());
    }
}
