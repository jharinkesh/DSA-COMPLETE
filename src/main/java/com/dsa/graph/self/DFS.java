package com.dsa.graph.self;

public class DFS {
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
        dfs(g, 0);
    }

    static void dfs(Graph g, int s){
        boolean[] visited = new boolean[g.n];
        dfsUtil(g, s, visited);
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
