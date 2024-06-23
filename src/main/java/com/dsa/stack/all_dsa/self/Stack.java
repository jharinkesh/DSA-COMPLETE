package com.dsa.stack.all_dsa.self;

import java.util.EmptyStackException;

public class Stack {
    int top = -1;
    int capacity;
    int[] data;


    public static void main(String[] args) {
        Stack s =  new Stack(5);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        //s.disp();
        s.pop();
        s.disp();


    }


    Stack(int capacity){
        this.capacity = capacity;
        data = new int[capacity];
    }

    void push(int e){
        if(top < capacity-1){
            data[++top] = e;
        }
    }

    Integer pop(){
        if(top >-1){
            int e = data[top];
            top--;
            return e;
        }
        return null;
    }

    void disp(){
        for(int i=top;i>=0;i--){
            System.out.println(data[i]);
        }
    }
}
