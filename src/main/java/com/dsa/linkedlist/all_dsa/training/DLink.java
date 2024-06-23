package com.dsa.linkedlist.all_dsa.training;

public class DLink {
    Node head;

    public static void main(String[] args) {
        DLink d = new DLink();
        d.add(40).add(50).add(60).add(70);
//        d.insertFirst(30);
        d.reverse();
        d.disp();
    }

    void reverse(){
        Node n1 = head;
        while(n1!=null){
            head = n1;
            Node t = n1.next;
            n1.next = n1.prev;
            n1.prev =t;
            n1 = t;
        }
    }

    void insertFirst(int data){
        Node n1 = new Node(data);
        if(head == null)
            head = n1;
        else{
            n1.next = head;
            head.prev = n1;
            head = n1;
        }
    }

    void disp(){
        Node n1 = head;
        while(n1!=null){
            System.out.print(n1.data + "<->");
            n1 = n1.next;
        }
    }

    DLink add(int data){
        Node n1 = new Node(data);
        if(head == null)
            head = n1;
        else {
            Node n2 = head;
            while (n2.next !=null){
                n2 = n2.next;
            }

            n1.prev = n2;
            n2.next = n1;
        }
        return this;
    }


    class Node {
        int data;
        Node prev, next;
        Node(int data){
            this.data = data;
        }
    }
}
