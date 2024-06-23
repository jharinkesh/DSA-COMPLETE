package com.dsa.q150.stack;

import java.util.*;

public class Minstack {

    List<Integer> s1 = new ArrayList<>();
    List<Integer> s2 = new ArrayList<>();

    void push(int e){
        s1.add(e);
        if(s2.isEmpty())
            s2.add(e);
        else{
            int t = s2.get(s2.size()-1);
            if(e <= t)
                s2.add(e);
        }
    }

    int pop(){
        int x = s1.remove(s1.size()-1);
        int t = s2.get(s2.size()-1);
        if(x == t)
            s2.remove(s2.size()-1);
        return x;
    }

    int getMin(){
        return s2.get(s2.size()-1);
    }

    void disp(){
        System.out.println("Elements are");
        System.out.println(s1.toString());
        System.out.println(s2.toString());
    }



    public static void main(String[] args) {
        Minstack ms = new Minstack();
        ms.push(8);
        ms.push(5);
        ms.push(9);
        //ms.disp();
        ms.push(1);
        ms.push(23);

        ms.pop();
        ms.pop();


        System.out.println(ms.getMin());

    }
}
