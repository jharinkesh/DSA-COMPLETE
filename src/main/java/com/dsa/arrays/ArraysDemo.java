package com.dsa.arrays;

import java.util.*;

public class ArraysDemo {

    public static void main(String[] args){

        // int[] a = {1,2,3,4,5};
        // reverse(a);
        // System.out.println(Arrays.toString(a));

        int[][] a = {
                {1,2,3},
                {4,5,6}
        };

        int[][] b = transpose(a);
        print(b);

    }

    static void print(int[][] a){
        for(int i=0;i<a.length;i++)
            System.out.println(Arrays.toString(a[i]));
    }

    static int[][] transpose(int[][] a){
        int rows = a.length;
        int cols = a[0].length;
        int[][] b = new int[cols][rows];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                b[j][i] = a[i][j];
            }
        }
        return b;
    }

    static void reverse(int[] a){
        int i =0;
        int j = a.length - 1;
        while(i<j){
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
            i++;
            j--;










        }
    }

}
