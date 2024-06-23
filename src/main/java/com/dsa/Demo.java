package com.dsa;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        Demo d = new Demo();
        int[][] board = new int[][]{{-1,-1,-1,-1,-1,-1},
                                    {-1,-1,-1,-1,-1,-1},
                                    {-1,-1,-1,-1,-1,-1},
                                    {-1,35,-1,-1,13,-1},
                                    {-1,-1,-1,-1,-1,-1},
                                    {-1,15,-1,-1,-1,-1}};
        System.out.println(d.snakesAndLadders(board));
    }


    HashMap<Integer, Integer[]> mp = new HashMap<>();
    public int snakesAndLadders(int[][] board) {
        int count = 1, n = board.length;
        for(int i=n-1;i>=0;i--){
            if(i%2!=0){
                for(int j=0;j<board.length;j++){
                    mp.put(count++, new Integer[]{i,j});
                }
            }else{
                for(int j=n-1;j>=0;j--){
                    mp.put(count++, new Integer[]{i,j});
                }
            }
        }
        return dfs(board, 1, 0);
    }

    int dfs(int[][] b, int p, int f){
        int n = b.length;
        if(p>n*n || f>n*n)
            return -1;
        if(p == n*n){
            return f;
        }

        Integer[] c = mp.get(p);
        int v = b[c[0]][c[1]];
        if(v!=-1){
            p = v;
        }
        int min = dfs(b, p+1, f+1);;
        for(int i=2;i<=6;i++){
            int x = dfs(b, p+i, f+1);
            if(x!=-1){
                min = Math.min(min, x);
            }
        }
        return min;
    }
}