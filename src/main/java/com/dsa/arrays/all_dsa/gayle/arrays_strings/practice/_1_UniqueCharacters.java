package com.dsa.arrays.all_dsa.gayle.arrays_strings.practice;

public class _1_UniqueCharacters {

    public static void main(String[] args) {
        System.out.println(isUnique("abcfd02 34"));
    }

    static boolean isUnique(String s){
        if(s.length()>128) return false;

        boolean[] t = new boolean[128];

        for(char ch:s.toCharArray()){
            if(t[ch])
                return false;
            t[ch] = true;
        }

        return true;
    }
}
