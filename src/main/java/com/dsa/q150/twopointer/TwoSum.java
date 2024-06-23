package com.dsa.q150.twopointer;

public class TwoSum {

    public static void main(String[] args) {
        int[] a = {1,4,8,20,22};
        printTwoSum(a,29);
    }

    static void printTwoSum(int[] a, int t){
        int i=0,j=a.length-1;
        while(i<j){
            int sum = a[i] + a[j];
            if(sum == t){
                System.out.println((i+1) + " " + (j+1));
                break;
            }
            if(sum<t)
                i++;
            else
                j--;
        }
    }

}
