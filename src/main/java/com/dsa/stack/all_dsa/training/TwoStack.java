package com.dsa.stack.all_dsa.training;

public class TwoStack {

    public static void main(String[] args) {

        TwoStack ts = new TwoStack(6);
        ts.push1(4);
        ts.push2(10);
        ts.push1(5);
        ts.push2(11);
        ts.disp();
        ts.push1(6);
        ts.push2(12);
        ts.push2(13);
        ts.disp();

        ts.pop2();
        ts.disp();
        ts.push1(7);
        ts.disp();
    }

    int[] a;
    int t1 , t2, cap;
    TwoStack(int cap){
        this.cap = cap;
        a = new int[cap];
        t1 = -1;
        t2 = cap;
    }

    void push1(int e){
        if(t2-t1>1)
            a[++t1] = e;
    }

    void push2(int e){
        if(t2-t1>1)
            a[--t2] = e;
    }

    int pop1(){
        if(t1>-1)
            return a[t1--];
        return -1;
    }

    int pop2(){
        if(t2<cap)
            return a[t2++];
        return -1;
    }

    void disp(){
        System.out.println();
        for(int i = 0;i<cap;i++){
            System.out.print(" " +a[i]);
            if(i == t1 || i == t2)
                System.out.print("*");
        }
    }

}
