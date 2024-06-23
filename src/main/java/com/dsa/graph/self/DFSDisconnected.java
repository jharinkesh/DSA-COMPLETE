package com.dsa.graph.self;

public class DFSDisconnected {
    public static void main(String[] args) {
        Graph g = new Graph(8);
//        0----2----4
//        |    |
//        1----3----5
//
//        6----7
        g.addUEdge(0, 1);
        g.addUEdge(0, 2);
        g.addUEdge(1, 3);
        g.addUEdge(2, 3);
        g.addUEdge(2, 4);
        g.addUEdge(3, 5);
        g.addUEdge(6, 7);
        g.print();
        dfs(g);
    }

    static void dfs(Graph g){
        boolean[] visited = new boolean[g.n];
        for(int i=0; i<g.n; i++){
            if(!visited[i]){
                dfsUtil(g, i, visited);
            }
        }
    }

    static void dfsUtil(Graph g, int s, boolean[] visited){
        visited[s] = true;
        System.out.print(s+" ");
        for(Node v : g.list[s]){
            if(!visited[v.vertex]){
                dfsUtil(g, v.vertex, visited);
            }
        }
    }
}
