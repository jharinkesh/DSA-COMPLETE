package com.dsa.arrays.all_dsa.gayle.arrays_strings.training;

import java.util.ArrayList;
import java.util.List;


public class UniqueCharacter {

    public static void main(String[] args) {

        System.out.println(isUnique2("rinkesh ja"));
        System.out.println(isUnique2("vinayaka y"));

    }


    static boolean isUnique(String s){
        List<Character> ls = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            Character ch = s.charAt(i);
            if(ls.contains(ch)){
                return false;
            }
            ls.add(ch);
        }
        return true;
    }

    static boolean isUnique2(String s){
        if(s.length()>128) return false;
        boolean t[] = new boolean[128];
        for(int i=0;i<s.length();i++){
            int v = s.charAt(i);
            if(t[v]){
                return false;
            }
            t[v] = true;
        }
        return true;
    }
}
