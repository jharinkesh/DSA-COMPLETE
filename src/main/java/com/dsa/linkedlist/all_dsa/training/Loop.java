package com.dsa.linkedlist.all_dsa.training;

public class Loop {

    public static void main(String[] args) {
        Node head = new Node(0);
        Node n1 = new Node(1);
        head.next = n1;
        Node n2 = new Node(2);
        n1.next = n2;
        Node n3 = new Node(3);
        n2.next = n3;
        Node n4 = new Node(4);
        n3.next = n4;
        Node n5 = new Node(5);
        n4.next = n5;
        //n5.next = head;
        System.out.println(hasCycle(head));
    }

    static boolean hasCycle(Node head){
        Node s = head, f = head;
        while(s!=null && f!= null && f.next != null){
            s = s.next;
            f = f.next.next;
            if(s == f)
                return true;
        }
        return false;
    }

    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
}
