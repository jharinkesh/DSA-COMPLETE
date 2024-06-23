package com.dsa.q150.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {

        int[] a = {-1,1,0,-3,3};
        int n= a.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = a[0];
        right[n-1] = a[n-1];
        for(int i=1;i<n;i++){
            left[i] = left[i-1]*a[i];
        }
        for(int j=n-2;j>=0;j--){
            right[j] = right[j+1] * a[j];
        }
        int[] ans = new int[n];

        for(int i=0;i<n;i++){
            if(i==0)
                ans[i] = right[i+1];
            else if(i==n-1)
                ans[i] = left[i-1];
            else
                ans[i] = left[i-1] * right[i+1];
        }

        System.out.println(Arrays.toString(ans));

    }


}
