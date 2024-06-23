package com.dsa.arrays.all_dsa.gayle.arrays_strings.practice;

import common.Utl;

public class _8_ZeroMatrix {

    public static void main(String[] args) {
        int a[][] = {
                {1,1,5},
                {2,0,6},
                {1,0,9},
                {7,8,0}
        };

        int rows = a.length, cols = a[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                    if(a[i][j] == 0){
                        for(int m = 0;m<rows;m++)
                            a[m][j] = 0;
                        for(int m=0;m<cols;m++)
                            a[i][m] = 0;
                    }
            }
        }

        Utl.print(a);
    }
}
