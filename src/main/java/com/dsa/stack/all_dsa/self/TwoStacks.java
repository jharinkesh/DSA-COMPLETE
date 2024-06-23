package com.dsa.stack.all_dsa.self;


public class TwoStacks {
    int top1, top2, cap;
    int[] data;


    public static void main(String[] args) {
        TwoStacks t = new TwoStacks(5);
        t.push1(1);
        t.push1(2);
        System.out.println(t.pop1());
        t.push2(10);
        t.push2(20);
        t.push2(30);
        t.push2(40);
        System.out.println(t.pop2());
    }

    TwoStacks(int cap){
        data = new int[cap];
        this.cap = cap;
        top1 = -1;
        top2 = cap;
    }

    void push1(int e){
        if(top1<top2-1){
            data[++top1] = e;
        }
    }

    void push2(int e){
        if(top2>top1+1){
            data[--top2] = e;
        }
    }

    Integer pop1(){
        if(top1>=0)
            return data[top1--];
        return null;
    }

    Integer pop2() {
        if (top2 < cap)
            return data[top2++];
        return null;
    }

}
