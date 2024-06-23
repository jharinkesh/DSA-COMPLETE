package com.dsa.q150.arrays;

import java.util.*;

public class TopKFrequent {

        public static void main(String[] args) {
        int[] a= {1,2,2,3,3,3,3,4,4,4};
        int k = 2;
        Map<Integer, Integer> m = new HashMap();
        for(int x:a){
            if(m.containsKey(x))
                m.put(x, m.get(x)+1);
            else
                m.put(x, 1);
        }

        List<Integer> ls = new ArrayList<>(m.keySet());
        ls.sort((x,y)->m.get(y)-m.get(x));

        for(int i=0;i<k;i++)
            System.out.print(ls.get(i) +" ");

    }
}
