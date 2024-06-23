package com.dsa.linkedlist.all_dsa;

public class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }

    public String toString(){
        return "data = "+data;
    }

    Node(int ... data){
        this.data = data[0];
        Node n1 = this;
        for(int i=1;i<data.length;i++) {
            Node n2 = new Node(data[i]);
            n1.next = n2;
            n1 = n1.next;
        }
    }

    public void traverse(){
        Node n2 = this;
        while (n2!=null) {
            System.out.print(n2.data + " ");
            n2 = n2.next;
        }
    }
}
