package com.dsa.q150.twopointer;

public class TrappinRainWater {

    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,3};
        capacity(a);
    }

    static void capacity(int[] h){
        int n = h.length;
        int[] lmax  = new int[n], rmax = new int[n];
        for(int i=1;i<n;i++)
            lmax[i] = Math.max(lmax[i-1], h[i-1]);
        for(int j=n-2;j>=0;j--)
            rmax[j] = Math.max(rmax[j+1], h[j+1]);
        int w = 0;
        for(int i=0;i<n;i++){
            int m = Math.min(lmax[i], rmax[i]);
            if(m>h[i]) {
                w = w + (m - h[i]);
            }
        }
        System.out.println("\n"+w);
    }
}
