package com.dsa.stack.all_dsa.self;
import java.util.Arrays;
import java.util.Stack;

public class NextGreater {

    public static void main(String[] args) {
        int[] a = {5, 15, 10, 8, 6, 12, 9, 18};
        Stack<Integer> st = new Stack<>();
        st.push(a[a.length-1]);
        int[] output = new int[a.length];
        output[a.length-1] = -1;
        for(int i=a.length-2;i>=0;i--){
            while(!st.isEmpty() && st.peek()<= a[i])
                st.pop();
            int e = st.isEmpty()?-1:st.peek();
            output[i]= e;
            st.push(a[i]);
        }

        System.out.print(Arrays.toString(output));
    }
}
