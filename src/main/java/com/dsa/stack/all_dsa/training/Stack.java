package com.dsa.stack.all_dsa.training;

public class Stack {

    public static void main(String[] args) {
        Stack s = new Stack(4);
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        s.disp();

        s.pop();
        s.pop();

        System.out.println();
        s.disp();

        System.out.println("peek: " + s.peek());

    }

    int[] a;
    int top, capacity;

    Stack(int c){
        this.capacity = c;
        this.a = new int[capacity];
        top = -1;
    }

    void push(int e){
        if(top<capacity-1)
            a[++top] = e;
    }

    int pop(){
        if(top>-1){
            return a[top--];
        }
        return -1;
    }

    int peek(){
        return a[top];
    }

    void disp(){
        if(top>-1){
            System.out.println();
            for(int i=top;i>-1;i--){
                System.out.println(a[i]);
            }
        }
    }


}
