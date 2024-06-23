package com.dsa.linkedlist.all_dsa;

import java.util.Stack;

public class ReverseList {

    public static void main(String[] args) {

        Node n1 = new Node(1,2,2,1);
        System.out.println(isPal(n1));
    }

    static boolean isPal(Node n1){
        Stack<Node> st = new Stack<Node>();
        Node n2 = n1;
        while (n2!=null){
            st.push(n2);
            n2 = n2.next;
        }

        n2 = n1;
        while (n2!=null){
            if(st.pop().data != n2.data)
                return false;
            n2 = n2.next;
        }

        return true;
    }
}
