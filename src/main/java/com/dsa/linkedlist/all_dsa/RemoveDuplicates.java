package com.dsa.linkedlist.all_dsa;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next  = new Node(4);
    }

}
