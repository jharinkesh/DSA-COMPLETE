package com.dsa.graph.self;

import java.util.*;

public class BFS {

    public static void main(String[] args) {
        Graph g = new Graph(6);
//        0----2----4
//        |    |
//        1----3----5
        g.addUEdge(0, 1);
        g.addUEdge(0, 2);
        g.addUEdge(1, 3);
        g.addUEdge(2, 3);
        g.addUEdge(2, 4);
        g.addUEdge(3, 5);
        g.print();
        bfs(g, 0);
    }

    static void bfs(Graph g, int s){
        boolean[] visited = new boolean[g.n];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u+" ");
            for(Node v : g.list[u]){
                if(!visited[v.vertex]){
                    visited[v.vertex] = true;
                    q.add(v.vertex);
                }
            }
        }
    }
}
