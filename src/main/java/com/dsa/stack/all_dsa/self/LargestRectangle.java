package com.dsa.stack.all_dsa.self;

public class LargestRectangle {

    public static void main(String[] args) {


    }


    public static void main2(String[] args) {
        int[] a = {6, 2, 5, 4, 1, 5, 6};
        int max = 0;

        for(int i = 0;i<a.length;i++){
            int h = a[i];
            int sum = 0;
            for(int j=i;j<a.length;j++){
              if(a[j] < h){
                  h = a[j];
                  sum = sum-(j-i)*h + h;
              }else {
                  sum += h;
              }
              max = Math.max(sum, max);
            }
        }

        System.out.println(max);
    }
}
