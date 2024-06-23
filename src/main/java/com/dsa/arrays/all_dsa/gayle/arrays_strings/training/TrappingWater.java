package com.dsa.arrays.all_dsa.gayle.arrays_strings.training;

public class TrappingWater {

    public static void main(String[] args) {

//        int[] a = {4,1,0,2,3};
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(getWater(a));

    }

    static int getWater(int[] a){
        int w = 0;
        int[] lmax = new int[a.length];
        int[] rmax = new int[a.length];
        for(int i = 1;i<a.length;i++){
            lmax[i] = Math.max(a[i-1], lmax[i-1]);
        }

        for(int j=a.length-2;j>=0;j--)
            rmax[j] = Math.max(a[j+1], rmax[j+1]);


        for(int i=0;i<a.length;i++){
            int m = Math.min(lmax[i], rmax[i]);
            if(m>a[i])
                w = w + (m-a[i]);
        }

        return w;
    }
}
