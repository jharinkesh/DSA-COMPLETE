package com.dsa.linkedlist.all_dsa;

public class Intersection {

    public static void main(String[] args) {

        Node n1 = new Node(1, 2, 3, 4, 5, 6, 7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        n8.next = n9;
        n9.next = n10;
        n10.next = n1.next.next;

        System.out.println(getIn(n1, n8));


    }

    static Node getIn(Node n1, Node n2){
        int l1 = length(n1), l2 = length(n2);
        Node small = n1, big = n2;
        if(l1>l2) {
            small = n2;
            big = n1;
        }

        int skip = Math.abs(l1-l2);

        while (skip>0){
            big = big.next;
            skip--;
        }

        while (small!=null && big != null){
            if(small.data == big.data)
                return small;
            small = small.next;
            big = big.next;
        }
        return null;
    }

    static int length(Node n1){
        if(n1 == null)
            return 0;
        return 1 + length(n1.next);
    }


}
