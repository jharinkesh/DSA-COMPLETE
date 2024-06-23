package com.dsa.arrays.all_dsa.gayle.arrays_strings.practice;

import java.util.Arrays;

public class _7_RotateMatrix {

    public static void main(String[] args) {

        int[][] a = {
                {1,2,3,4},
                {5,6,7,8},
                {4,4,4,4}
        };

        int r = a.length, c = a[0].length;
        int[][] b = new int[c][r];
        int row = 0, col = 0;
        for(int j = 0;j<c; j++){
            for(int i = r-1;i>=0;i--){
                b[row][col] = a[i][j];
                if(col == (r-1)){
                    row++;
                    col = 0;
                }else{
                    col++;
                }
            }
        }

        System.out.println(Arrays.deepToString(b));

    }
}
