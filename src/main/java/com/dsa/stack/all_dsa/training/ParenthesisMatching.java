package com.dsa.stack.all_dsa.training;

import java.util.Stack;

public class ParenthesisMatching {

    public static void main(String[] args) {
        System.out.println(valid("[{)]"));
        System.out.println(valid("{{{}}}"));
        System.out.println(valid("[{}()[]]"));
        System.out.println(valid(""));
    }

    static boolean valid(String s){
        char[] ch = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for(char x: ch){
            if(x == '(' || x == '{' || x == '[')
                st.push(x);
            else{
                if(st.isEmpty())
                    return false;
                else{
                    int v = st.peek();
                    if((x == ')' && v == '(')
                     || (x== '}' && v == '{')
                        || (x == ']' && v =='['))
                        st.pop();
                    else
                        return false;
                }
            }
        }
        return st.isEmpty();
    }
}
