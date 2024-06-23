package com.dsa.linkedlist.all_dsa.training;
import java.util.*;


public class Slink {

    Node head = null;

    public static void main(String[] args) {
        Slink s1 = new Slink();
        Slink s2 = new Slink();

//        s.sampleList();

        s1.add(40).add(50).add(60).add(70);
        s2.add(30).add(45).add(55).add(90);

        Node head3 = s1.merge(s1.head, s2.head);
        s1.disp(head3);

        //s.disp(s.head);
        //s.addFirst(90);
//        s.removeFirst();
        //System.out.println(s.search(70));
//        s.removeLast();


      //s.insertPosition2(55, 3);
      //s.disp(s.head);
//        s.reverse();
//        s.disp(s.head);

    }

    Node merge(Node head1, Node head2){
        Node n1 = head1, n2 = head2;
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        Slink sl = new Slink();

        while(n1!=null && n2 !=null){
            if(n1.data <= n2.data){
                sl.add(n1.data);
                n1 = n1.next;
            }else{
                sl.add(n2.data);
                n2 = n2.next;
            }
        }

        while(n1!=null){
            sl.add(n1.data);
            n1 = n1.next;
        }

        while(n2!=null){
            sl.add(n2.data);
            n2 = n2.next;
        }

        return sl.head;
    }

    void reverse(){
        Node p = null;
        Node n1 = head;
        while(n1 != null){
            Node t = n1.next;
            n1.next = p;
            p  = n1;
            n1 = t;
        }
        head = n1;
    }

    void insertPosition2(int data, int p){
        Node n1 = head; int count = 1;
        while(n1!=null){
            if(count == p){
                Node n2 = new Node(data);
                int v = n1.data;
                n1.data = n2.data;
                n2.data = v;
                n2.next = n1.next;
                n1.next = n2;
                break;
            }
            n1 = n1.next;
            count++;
        }
    }

    void insertPosition(int data, int p){
        Node n1 = head; int count = 1;
        while(n1!=null){
            if(count == p-1){
                Node n2 = new Node(data);
                n2.next = n1.next;
                n1.next = n2;
                break;
            }
            n1 = n1.next;
            count++;
        }
    }


    void removeLast(){
        if(this.head.next == null)
            this.head = null;
        else{
            Node p = null, n1 = head;
            while(n1.next != null){
                p = n1;
                n1 = n1.next;
            }
            p.next = null;
        }
    }


    //////////////////////////



    void removeFirst(){
        head = head.next;
    }

    int search(int data){
        Node n1 = head;
        int count = 0;
        while(n1!=null){
            if(n1.data  == data)
                return count;
            count++;
            n1 = n1.next;
        }
        return -1;
    }


    void addFirst(int data){
        Node n1 = new Node(data);
        if(head == null)
            head = n1;
        else{
            n1.next = head;
            head = n1;
        }
    }

    Slink add( int data){
        Node n1 = new Node(data);
        if(head == null)
            head = n1;
        else{
            Node n2 = head;
            while(n2.next != null)
                n2 = n2.next;
            n2.next = n1;
        }
        return this;
    }

    void disp(Node head){
        Node n1 = head;
        while(n1 != null){
            System.out.print(n1.data +" ");
            n1 = n1.next;
        }
    }

    void sampleList(){
        Node head = new Node(40);
        Node n1 = new Node(50);
        head.next = n1;
        Node n2 = new Node(60);
        n1.next = n2;
        Node n3 = new Node(70);
        n2.next = n3;

        disp(head);

    }

    class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
}


