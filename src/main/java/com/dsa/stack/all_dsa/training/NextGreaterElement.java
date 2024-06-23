package com.dsa.stack.all_dsa.training;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] a = { 5, 15, 10, 8, 6, 12, 9, 18};
        int[] r = new int[a.length];
        Stack<Integer> st = new Stack<>();
        st.push(a[a.length-1]);
        r[a.length-1] = -1;
        for(int i=a.length-2;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=a[i])
                st.pop();
            if(!st.isEmpty())
                r[i] = st.peek();
            else
                r[i] = -1;
            st.push(a[i]);
        }

        for(int i=0;i<a.length;i++)
            System.out.print(" "+r[i]);
    }
}
