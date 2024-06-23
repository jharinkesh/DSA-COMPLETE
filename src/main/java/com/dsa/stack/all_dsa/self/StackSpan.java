package com.dsa.stack.all_dsa.self;

import java.util.Stack;

public class StackSpan {

    public static void main(String[] args) {
        int[] a = {13, 15, 12, 14, 16, 8, 6, 4, 10 , 30};

        Stack<Integer> st = new Stack<>();

        st.push(0);
        System.out.print(1 +" ");
        for(int i =1;i<a.length;i++){
            while(!st.isEmpty() && a[st.peek()]<=a[i])
                        st.pop();
            int span = st.isEmpty()?i+1:i-st.peek();
            System.out.print(span+" ");
            st.push(i);
        }

    }

}
