package com.dsa.graph.training;

import java.util.*;

public class WGraphDemo {

    public static void main(String[] args) {
//        WGraph g = new WGraph(5);
//        g.addUEdge(0, 1, 8);
//        g.addUEdge(0, 3, 10);
//        g.addUEdge(1, 2, 2);
//        g.addUEdge(2, 3, 4);
//        g.addUEdge(2, 4, 5);
//        g.addUEdge(3, 4, 1);

        WGraph g = new WGraph(4);
        g.addUEdge(0,1,50);
        g.addUEdge(0,2,100);
        g.addUEdge(1,2,30);
        g.addUEdge(1,3,200);
        g.addUEdge(2,3,20);
        g.dijkstra(0);

        //g.disp();
        //g.mst2();



    }
}

class WGraph {

    List<Node>[] data;
    int n;

    WGraph(int n) {
        this.n = n;
        data = new List[n];
        for(int i=0; i<n; i++) {
            data[i] = new ArrayList<>();
        }
    }



    void dijkstra(int s){
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        boolean b[] = new boolean[n];
        for(int count=0;count<n;count++){
            int u = -1;
            for(int i=0;i<n;i++){
                if(!b[i] && (u==-1 || dist[i]<dist[u])){
                    u = i;
                }
            }
            b[u] = true;
            for(Node node:data[u]){
                if(!b[node.vertex] && dist[node.vertex]>dist[u]+node.weight){
                    dist[node.vertex] = dist[u]+node.weight;
                }
            }
        }
        System.out.println(Arrays.toString(dist));
    }

    void mst2(){
        int res = 0;
        boolean mst[] = new boolean[n];
        int key[] = new int[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        for(int count=0;count<n;count++){
            int u = -1;
            for(int i=0;i<n;i++){
                if(!mst[i] && (u==-1 || key[i]<key[u])){
                    u = i;
                }
            }
            mst[u] = true;
            res+=key[u];
            for(Node node:data[u]){
                if(!mst[node.vertex] && node.weight<key[node.vertex]){
                    key[node.vertex] = node.weight;
                }
            }
        }


        System.out.println(res);
    }

    void mst(){
        int cost =0;
        List<Integer> mst = new ArrayList<>();
        List<Integer> nmst = new ArrayList<>();
        mst.add(0);
        for(int i=1;i<n;i++){
            nmst.add(i);
        }

        while(!nmst.isEmpty()){
            int min = Integer.MAX_VALUE;
            int v = -1;
            for(int i:mst){
                for(Node node:data[i]){
                    if(!mst.contains(node.vertex) && node.weight<min){
                        min = node.weight;
                        v = node.vertex;
                    }
                }
            }
            cost+=min;
            mst.add(v);
            nmst.remove(nmst.indexOf(v));
        }
        System.out.println(cost);
    }

    void addUEdge(int u, int v, int w) {
        data[u].add(new Node(v, w));
        data[v].add(new Node(u, w));
    }

    void addDEdge(int u, int v, int w) {
        data[u].add(new Node(v, w));
    }

    void removeUEdge(int u, int v) {
        data[u].remove(new Node(v, 0));
        data[v].remove(new Node(u, 0));
    }

    void removeDEdge(int u, int v) {
        data[u].remove(new Node(v, 0));
    }

    void disp() {
        for(int i=0; i<n; i++) {
            System.out.print(i + "|");
            for(Node node : data[i]) {
                System.out.print(" ->"+node.vertex + "(" + node.weight + ")");
            }
            System.out.println();
        }
    }
}

class Node {
    int vertex;
    int weight;

    Node(int v, int w) {
        this.vertex = v;
        this.weight = w;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(obj == this) return true;
        if(obj instanceof Node) {
            Node node = (Node) obj;
            return this.vertex == node.vertex;
        }
        return false;
    }
}