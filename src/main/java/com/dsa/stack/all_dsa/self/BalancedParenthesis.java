package com.dsa.stack.all_dsa.self;
import java.util.Stack;

public class BalancedParenthesis {

    public static void main(String[] args) {
        System.out.println(isBalanced("{{{}}}"));

    }

    static boolean isBalanced(String s){
        char[] ch = s.toCharArray();
        Stack<Character> st = new Stack<>();

        for(char c: ch){
            if(c == '(' || c == '{' || c == '[')
                st.push(c);
            else{
                if(st.isEmpty())
                    return false;

                char d = st.peek();
                if((c == ')' && d == '(')
                    || (c == '}' && d == '{')
                    || (c == ']' && d == '['))
                    st.pop();
            }
        }

        return st.isEmpty();
    }
}
