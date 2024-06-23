package com.dsa.stack.all_dsa.training;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {

        MinStack ms = new MinStack();
        ms.push(2);
        ms.push(5);
        ms.push(6);
        ms.push(1);
        ms.push(3);

        System.out.println(ms.min());

        ms.pop();
        ms.pop();

        System.out.println(ms.min());
    }

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void push(int e){
        s1.push(e);
        if(s2.isEmpty())
            s2.push(e);
        else if(e<=s2.peek())
            s2.push(e);
    }

    int pop(){
        int e = s1.pop();
        if(e == s2.peek())
            s2.pop();
        return e;
    }

    int min(){
        return s2.peek();
    }

}
