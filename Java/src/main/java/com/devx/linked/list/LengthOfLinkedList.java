package com.devx.linked.list;

/**
 * @author I348618
 * @since 5/23/2021
 */
public class LengthOfLinkedList {

    private Node head;

    class Node {
        int data;
        Node next;
        public Node(int d) {
            data = d;
        }
    }

    int lengthIterative() {
        int count=0;
        Node temp = head;
        while(temp!=null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    int lengthRecursive(Node temp) {
        if(temp==null)
            return 0;
        return lengthRecursive(temp.next) + 1;
    }

    public static void main(String[] args) {
        LengthOfLinkedList list = new LengthOfLinkedList();
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);
        System.out.println("Linked list: " + list.print());
        System.out.println("Iterative length: " + list.lengthIterative());
        System.out.println("Recursive length: " + list.lengthRecursive(list.head));
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
