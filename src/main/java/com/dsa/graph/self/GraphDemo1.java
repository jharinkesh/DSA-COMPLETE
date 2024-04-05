package com.dsa.graph.self;

import java.util.*;

public class GraphDemo1 {

    public static void main(String[] args) {

//             2       3       6
//        (0)---->(1)---->(2)----->(3)
//         \            /*        /*
//         1\         /2         /
//           \      /           /1
//            *   /            /
//            (4)------------>(5)
//                     4

            WGraph g = new WGraph(6);
            g.addDEdge(0, 1, 2);
            g.addDEdge(0, 4, 1);
            g.addDEdge(1, 2, 3);
            g.addDEdge(2, 3, 6);
            g.addDEdge(4, 2, 2);
            g.addDEdge(4, 5, 4);
            g.addDEdge(5, 3, 1);

            g.disp();
            g.shortestPathDAGTopo();


    }

}

class WGraph {
    List<Node>[] data;
    int n;

    WGraph(int n){
        this.n = n;
        data = new List[n];
        for(int i=0;i<n;i++)
            data[i] = new ArrayList<Node>();
    }

    void shortestPathDAGTopo(){
        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        int[] topSort = toplogicalSortDFS();
        for(int i=0;i<n;i++){
            int x = topSort[i];
            for(Node u: data[x]){
                if(d[u.vertex]>d[x]+u.weight)
                    d[u.vertex] = d[x]+u.weight;
            }
        }
        System.out.println(Arrays.toString(d));
    }

    int[] toplogicalSortDFS(){
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(!visited[i])
                dfs(i, visited, st);
        }

        int[] output = new int[n];
        int i=0;
        while (!st.isEmpty())
            output[i++] = st.pop();
        return output;
    }

    void dfs(int s, boolean[] visited, Stack<Integer> st){
        visited[s] = true;
        for(Node v: data[s]){
            if(!visited[v.vertex])
                dfs(v.vertex, visited, st);
        }
        st.push(s);
    }

    void addUEdge(int u, int v, int cost){
        data[u].add(new Node(v, cost));
        data[v].add(new Node(u, cost));
    }

    void removeUEdge(int u, int v){
        data[u].remove(new Node(v, 0));
        data[v].remove(new Node(u, 0));
    }

    void addDEdge(int u, int v, int cost){
        data[u].add(new Node(v, cost));
    }

    void removeDEdge(int u, int v){
        data[u].remove(new Node(v, 0));
    }

    void disp(){
        for(int i=0;i<n;i++){
            System.out.print(i+" | ");
            for(Node x: data[i]){
                System.out.print(" -> "+x.vertex+"("+x.weight+")");
            }
            System.out.println();
        }
    }

}

class Node{
    int vertex;
    int weight;

    Node(int vertex, int cost){
        this.vertex = vertex;
        this.weight = cost;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Node){
            Node x = (Node)o;
            return x.vertex==this.vertex;
        }
        return false;
    }
}

class Graph{
    List<Integer>[] data;
    int n;

    Graph(int n){
        this.n = n;
        data = new List[n];
        for(int i=0;i<n;i++)
            data[i] = new ArrayList<Integer>();
    }


    void shorrtestPathDAG(int s){
        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[s] = 0;
        int[] topSort = toplogicalSortDFS();
        for(int i=0;i<n;i++){
            int x = topSort[i];
            for(int u: data[x]){
                if(d[u]>d[x]+1)
                    d[u] = d[x]+1;
            }
        }
        System.out.println(Arrays.toString(d));
    }

    int[] toplogicalSortDFS(){
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(!visited[i])
                dfs(i, visited, st);
        }

        int[] output = new int[n];
        int i=0;
        while (!st.isEmpty())
            output[i++] = st.pop();
        return output;
    }

    void dfs(int s, boolean[] visited, Stack<Integer> st){
        visited[s] = true;
        for(int v: data[s]){
            if(!visited[v])
                dfs(v, visited, st);
        }
        st.push(s);
    }

    void toplogicalSortBFS(){
        int[] in = new int[n];
        for(List<Integer> x:data){
            for(int i:x)
                in[i]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0)
                q.add(i);
        }

        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x+" ");
            for(int i:data[x]){
                in[i]--;
                if(in[i]==0)
                    q.add(i);
            }
        }
    }

    boolean hasCycle(int s, boolean[] visited, int parent){
        visited[s] = true;
        for(int v: data[s]){
            if(!visited[v]){
                if(hasCycle(v, visited, s))
                    return true;
            }else if(v!=parent)
                return true;
        }
        return false;
    }


    void shortestPath(int s){
        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        d[s] = 0;
        while (!q.isEmpty()){
            int x = q.poll();
            for(int u: data[x]){
                if(!visited[u]){
                    q.add(u);
                    visited[u] = true;
                    d[u] = d[x]+1;
                }
            }
        }

        System.out.println(Arrays.toString(d));
    }

    void dfs(int s){
        boolean[] visited = new boolean[n];
        System.out.print(s +" ");
        visited[s] = true;
        Stack<Integer> st = new Stack<>();
        st.push(s);
        while (!st.isEmpty()){
            int x = st.peek();
            int y = getUnvisited(x, visited);
            if(y!=-1){
                visited[y] = true;
                System.out.print(y +" ");
                st.push(y);
            }else
                st.pop();
        }
    }


    int getUnvisited(int x, boolean[] visited){
        for(int m : data[x]){
            if(!visited[m])
                return m;
        }
        return -1;
    }

    void dfs(int s, boolean[] visited){
        System.out.print(s +" ");
        visited[s] = true;
        for(int v: data[s]){
            if(!visited[v])
                dfs(v, visited);
        }
    }


    void bfsDisconnected(){
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i])
                bfs(i, visited);
        }
    }

    void bfs(int s, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()){
            int x = q.poll();
            System.out.print(x+" ");
            for(int v: data[x]){
                if(!visited[v]){
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
    }


    void addUEdge(int u, int v){
        data[u].add(v);
        data[v].add(u);
    }

    void removeUEdge(Integer u, Integer v){
        data[u].remove(v);
        data[v].remove(u);
    }

    void addDEdge(int u, int v){
        data[u].add(v);
    }

    void removeDEdge(Integer u, Integer v){
        data[u].remove(v);
    }

    void disp(){
        for(int i =0;i<n;i++){
            System.out.print(i +" | ");
            for (int j=0;j<data[i].size();j++)
                System.out.print(" -> "+data[i].get(j));
            System.out.println();
        }
    }
}
