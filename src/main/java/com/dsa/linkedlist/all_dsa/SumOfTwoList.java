package com.dsa.linkedlist.all_dsa;

public class SumOfTwoList {

    public static void main(String[] args) {
        Node n1 = new Node(7,1,6);
        Node n2 = new Node(5,9,2);
        n1.traverse();
        System.out.println();
        n2.traverse();
        System.out.println();
        getSum(n1, n2).traverse();
    }


    static Node getSum(Node n1, Node n2){
        Node last = null;
        int carry = 0;
        while(n1 !=null && n2 !=null){
            int sum = n1.data + n2.data + carry;
            Node n = new Node(sum%10);
            carry = sum /10;
            n.next = last;
            last = n;
            n1 = n1.next;
            n2 = n2.next;
        }

        last = padList(n1, last, carry);
        last = padList(n2, last, carry);
        return last;
    }

    static Node padList(Node nx, Node last, int carry){
        while(nx!=null){
            int sum = nx.data + carry;
            carry = sum/10;
            Node n = new Node(sum%10);
            n.next = last;
            last = n;
            nx = nx.next;
        }

        if(carry>0){
            Node n = new Node(carry);
            n.next = last;
            last = n;
        }
        return last;
    }



}
