package com.dsa.q150.arrays;

import java.util.HashMap;
import java.util.*;

public class Anagram {
    public static void main(String[] args) {
//        System.out.println(isAna("ca","rac"));
//        System.out.println(isAna("malayalam","amlayalam"));
//        System.out.println(isAna("malayalam","malayamam"));
        groupAnagram(new String[]{"aba","cbc","aab"});
    }


    static void groupAnagram(String[] strs){
        Map<String, List> m = new HashMap<>();
        for(String s:strs){
            Integer[] k = new Integer[26];
            Arrays.fill(k,0);
            for(int j=0;j<s.length();j++)
                k[s.charAt(j)-97] += 1;

            String K = Arrays.toString(k);
            if(m.containsKey(K)){
                m.get(K).add(s);
            }else{
                List l = new ArrayList();
                l.add(s);
                m.put(K, l);
            }
        }
//        System.out.println(m);
        for(List ls: m.values()){
            System.out.print(ls +" ");
        }
    }

    static boolean isAna(String a, String b){
        if(a.length()!=b.length())
            return false;
        int[] m = new int[26];
        for(int i=0;i<a.length();i++){
            int y = a.charAt(i)-97;
            m[y] += 1;
        }
        for(int j=0;j<b.length();j++){
            int y = b.charAt(j) - 97;
            m[y] -= 1;
            if(m[y]<0)
                return false;
        }
        return true;
    }
}
