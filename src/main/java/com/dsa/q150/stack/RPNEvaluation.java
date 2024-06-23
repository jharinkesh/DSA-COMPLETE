package com.dsa.q150.stack;

import java.util.*;

public class RPNEvaluation {

    public static void main(String[] args) {

        String str[]= {"4","13","5", "/","+"};
        Stack<Integer> st = new Stack<>();
        List<String> op = Arrays
                .asList(new String[]{"+","-","*","/"});
        for(String s:str){
            if(!op.contains(s))
                st.push(Integer.valueOf(s));
            else{
                int x = st.pop();
                int y = st.pop();
                if(s == "+")
                    st.push(y+x);
                else if(s == "-")
                    st.push(y-x);
                else if(s == "*")
                    st.push(y*x);
                else
                    st.push(y/x);
            }
        }

        System.out.println(st.pop());

    }
}
