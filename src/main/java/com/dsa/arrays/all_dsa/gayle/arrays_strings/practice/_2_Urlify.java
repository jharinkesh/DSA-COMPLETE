package com.dsa.arrays.all_dsa.gayle.arrays_strings.practice;

public class _2_Urlify {

    public static void main(String[] args) {
        char[] ch = "My Name is Joker      ".toCharArray();
        urlify(ch);
        System.out.println(ch);
    }

    // the input char array has enough whitespace
    // replace whitespace with '%20'
    static void urlify(char[] ch){
        int i = ch.length-1;
        while(i>=0){
            if(ch[i]!=' ')
                break;
            i--;
        }

        char[] ch2 = new char[ch.length];
        int j = 0, k =0;
        while(j<=i){
            if(ch[j] == ' '){
                ch2[k++] = '%';
                ch2[k++] = '2';
                ch2[k++] = '0';
            }else{
                ch2[k++] = ch[j];
            }
            j++;
        }

        for(j=0;j<ch.length;j++){
            ch[j] = ch2[j];
        }
    }


}
