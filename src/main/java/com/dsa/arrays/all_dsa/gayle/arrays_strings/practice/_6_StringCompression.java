package com.dsa.arrays.all_dsa.gayle.arrays_strings.practice;

public class _6_StringCompression {

    public static void main(String[] args) {

        String input = "aabccccaaa";
        System.out.println(compress(input));
    }


    static String compress(String str){
        StringBuilder sb = new StringBuilder();
        char[] c = str.toCharArray();
        char prev = c[0];
        int count = 1, i =1;
        for(;i<c.length;i++){
            if(c[i]!= prev){
                sb.append(prev).append(count);
                prev = c[i];
                count = 1;
            }else{
                count++;
            }
        }

        if(c[i-1]!= prev){
            sb.append(c[i-1]).append(1);
        }else{
            sb.append(prev).append(count);
        }

        return sb.length()<str.length()?sb.toString():str;
    }


}
