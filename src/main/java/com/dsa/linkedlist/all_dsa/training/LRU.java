package com.dsa.linkedlist.all_dsa.training;

public class LRU {

    Node head = null;

    public static void main(String[] args) {
        int[] a = {10,20,30,20,10,40,50,60,20};
        LRU lru = new LRU();

        for(int x: a){
            System.out.println("\nAccess: " +x);
            lru.access(x);
            lru.disp();
        }


    }

    void access(int k){
        Node x = head;
        if(x  == null){
            head  = new Node(k);
            return;
        }

        if(head.data == k)
            return;

        Node prev = null;

        while(x!=null){
            if(x.data == k)
                break;
            prev = x;
            x = x.next;
        }

        if(x!=null){
            prev.next = x.next;
        }else{
            x = new Node(k);
        }
        x.next = head;
        head = x;
    }

    void disp(){
        Node n1 = head;
        while(n1!=null){
            System.out.print(n1.data+ " -> ");
            n1 = n1.next;
            }
    }


    class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
}
