package com.dsa.arrays.all_dsa.gayle.arrays_strings.training;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress("aaaaabaccccccccaa"));
    }

    static String compress(String s){
      StringBuilder sb = new StringBuilder();
      char p = s.charAt(0);
      int c = 1, i;
      for (i=1;i<s.length();i++){
          if(s.charAt(i) != p){
              sb.append(p).append(c);
              p = s.charAt(i);
              c= 1;
          }else{
              c++;
          }
      }

      if(s.charAt(i-1) != p){
          sb.append(s.charAt(i-1)).append(1);
      }else{
          sb.append(p).append(c);
      }

        System.out.println("sb: "+sb);

      return sb.length()>s.length()?s:sb.toString();
    }
}
