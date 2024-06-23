package com.dsa.arrays.all_dsa.gayle.arrays_strings.training;

public class Palidrome {


    public static void main(String[] args) {

//        System.out.println(isPalindorme("MALAAYAALAM"));
        System.out.println(isPerm("CARRACER"));

    }


    static boolean isPerm(String s ){
        int a[] = new int[128];
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i);
            a[c]++;
        }

        boolean oddFound = false;

        for(int i=0;i<128;i++){
            if(a[i]%2 !=0){
                if(oddFound)
                    return false;
                oddFound = true;
            }
        }

        return true;
    }


    static boolean isPalindorme(String s){

        int i = 0, j = s.length()-1;
        while(i<j){
            if(s.charAt(i) == s.charAt(j))
            {
                i++; j--;
            }else{
                return false;
            }
        }
        return true;
    }

}
