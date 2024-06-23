package com.dsa.graph;

public class DisjointSet {

    int n;
    int[] arr;

    DisjointSet(int n){
        this.n = n;
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i;
        }
    }

    int find(int x){
        return arr[x];
    }

    void union(int x, int y){
        int xset = find(x);
        int yset = find(y);

        arr[yset] = xset;
    }

    void print(){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(5);
        ds.union(0, 2);
        ds.union(4, 2);
        //ds.union(3, 1);
        ds.print();
    }

}
