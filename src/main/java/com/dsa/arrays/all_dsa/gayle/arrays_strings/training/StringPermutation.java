package com.dsa.arrays.all_dsa.gayle.arrays_strings.training;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringPermutation {

    public static void main(String[] args) {

        System.out.println(permutation2("abcde", "cbdae"));
        System.out.println(permutation2("abccde", "cbdae"));

    }

    static boolean permutation2(String s1, String s2){
        if(s1.length()!=s2.length()) return false;
        int[] data = new int[128];
        for(int i=0;i<s1.length();i++)
            data[s1.charAt(i)]++;
        for(int j=0;j<s2.length();j++){
            int ch = s2.charAt(j);
            data[ch]--;
            if(data[ch]<0)
                return false;
        }
        return true;
    }

    static boolean permutation(String s1, String s2){
        if(s1.length()!=s2.length())
            return false;
        String s11 = sort(s1);
        String s22 = sort(s2);
        return s11.equals(s22);
    }

    static String sort(String s){
        char[] data = s.toCharArray();
        Arrays.sort(data);
        return new String(data);
    }
}
