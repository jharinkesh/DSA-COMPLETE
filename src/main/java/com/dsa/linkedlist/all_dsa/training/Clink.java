package com.dsa.linkedlist.all_dsa.training;

public class Clink {

    Node head;

    public static void main(String[] args) {

        Clink cl = new Clink();
        cl.add(10).add(20).add(30).add(40).add(50);
        cl.disp();

    }

    Clink add(int data){
        Node n1=new Node(data);
        if(head == null){
            head = n1;
            head.next = n1;
        }else{
            Node n2 = head;
            while(n2.next != head){
                n2 = n2.next;
            }
            n1.next = head;
            n2.next = n1;
        }
        return this;
    }

    void disp(){
        Node n1 = head;
        while(n1.next != head){
            System.out.print(n1+" - ");
            n1 = n1.next;
        }
        System.out.println(n1);
    }

    class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }

        @Override
        public String toString(){
            return "["+data+"|"+next.data+"]";
        }
    }
}
