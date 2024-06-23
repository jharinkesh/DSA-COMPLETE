//package stack;

import java.util.Stack;

public class Minstack {

    public static void main(String[] args) {
        Minstack ms = new Minstack();
        ms.push(4);
        ms.push(2);
        ms.push(1);
        ms.push(9);
        ms.push(7);
//        ms.disp();
        ms.pop();
        ms.pop();
        ms.pop();
        ms.disp();

    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    void push(int x){
        stack1.push(x);
        if(stack2.isEmpty())
            stack2.push(x);
        else if(x<=stack2.peek())
            stack2.push(x);
    }

    void pop(){
        if(!stack1.isEmpty()){
            int x = stack1.pop();
            if(x == stack2.peek())
                stack2.pop();
        }
    }

    void disp(){
        System.out.println();
        for(int x:stack1)
            System.out.print(x+" , ");
        System.out.println();
        for(int x:stack2)
            System.out.print(x+" , ");
        System.out.println();
    }




}
