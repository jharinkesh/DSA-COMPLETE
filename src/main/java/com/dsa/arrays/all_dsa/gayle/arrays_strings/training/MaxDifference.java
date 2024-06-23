package com.dsa.arrays.all_dsa.gayle.arrays_strings.training;

public class MaxDifference {

    public static void main(String[] args) {
        int[] a = {8, 2, 9, 5, 1};
        System.out.println(maxDiff(a));
    }


    static int maxDiff(int[] a){
        int mx = a[0], mn = a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]>mx)
                mx = a[i];

            if(a[i]<mn)
                mn = a[i];
        }

        return mx - mn;
    }


}
