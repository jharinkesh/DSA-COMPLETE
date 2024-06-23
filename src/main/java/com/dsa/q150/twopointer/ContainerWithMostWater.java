package com.dsa.q150.twopointer;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,8};
        printMaxWater(a);
    }

    static void printMaxWater(int[] a){
        int i = 0, j = a.length -1, m = 0;
        while(i<j){
            int w = (j-i)*Math.min(a[i],a[j]);
            m = Math.max(m,w);
            if(a[i]<a[j])
                i++;
            else
                j--;
        }
        System.out.println(m);
    }
}
