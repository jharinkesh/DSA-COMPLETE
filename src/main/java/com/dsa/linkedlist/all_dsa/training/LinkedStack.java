package com.dsa.linkedlist.all_dsa.training;

public class LinkedStack {

    Node head = null;

    public static void main(String[] args) {
        LinkedStack ls = new LinkedStack();
        ls.push(1);
        ls.push(2);
        ls.push(3);
        ls.disp();
        System.out.println("----------");
        ls.pop();
        ls.disp();
    }

    void push(int data){
        Node n1 = new Node(data);
        if(head == null){
            head = n1;
        }else{
            n1.next = head;
            head = n1;
        }
    }


    int pop(){

        if(head != null){
            int data = head.data;
            head = head.next;
            return data;
        }
        return -1;
    }

    void disp(){
        Node x = head;
        while(x!=null){
            System.out.println(x.data);
            x = x.next;
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
