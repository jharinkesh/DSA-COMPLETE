package com.dsa.arrays.all_dsa.gayle.arrays_strings.practice;

public class _2_StringIsPermutation {

    public static void main(String[] args) {

        System.out.println(isPermutation("abcde","dcebb"));


    }

    static boolean isPermutation(String a, String b){
        if(a.length()!=b.length()) return false;

        int[] t = new int[128];
        for(char ch:a.toCharArray())
            t[ch]++;

        for(char ch:b.toCharArray()) {
            t[ch]--;
            if(t[ch]<0)
                return false;
        }

        return true;
    }

}
