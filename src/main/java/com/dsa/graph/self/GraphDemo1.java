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

//            WGraph g = new WGraph(6);
//            g.addDEdge(0, 1, 2);
//            g.addDEdge(0, 4, 1);
//            g.addDEdge(1, 2, 3);
//            g.addDEdge(2, 3, 6);
//            g.addDEdge(4, 2, 2);
//            g.addDEdge(4, 5, 4);
//            g.addDEdge(5, 3, 1);

//            g.disp();
//            g.shortestPathDAGTopo();

//        System.out.println(g.prims2());


//          0--->1--->3
//          ^   /     |
//          |  /      *
//          2 *       4


//        Graph g = new Graph(5);
//        g.addDEdge(0, 1);
//        g.addDEdge(2, 0);
//        g.addDEdge(1, 3);
//        g.addDEdge(3, 4);
//        g.addDEdge(1, 2);
//        g.disp();

//        g.kosaraju();


//            *1
//         1 / | \ 2
//          /  |  \
//         0   |-3 *3
//          \  |  /*
//         4 \ * / 3
//            *2/

//        WGraph g = new WGraph(4);
//        g.addDEdge(0,1,1);
//        g.addDEdge(0,2,4);
//        g.addDEdge(1,2,-3);
//        g.addDEdge(1,3,2);
//        g.addDEdge(2,3,3);
//
//        g.bellman();

//        0--2--3
//        | / \ |
//        |/   \|
//        1     4

        Graph1 g = new Graph1(5);
        g.addUEdge(0,1);
        g.addUEdge(0,2);
        g.addUEdge(1,2);
        g.addUEdge(2,3);
        g.addUEdge(2,4);
        g.addUEdge(3,4);

        g.disp();
        System.out.println(g.hasArticulationPoint());
    }

}

class WGraph {
    List<Node1>[] data;
    int n;

    WGraph(int n){
        this.n = n;
        data = new List[n];
        for(int i=0;i<n;i++)
            data[i] = new ArrayList<Node1>();
    }


    void bellman(){
        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        for(int i=0;i<(n-1);i++){
            for(int u=0;u<n;u++){
                for(Node1 v:data[u]){
                    if((d[u]+v.weight)<d[v.vertex])
                        d[v.vertex] = d[u] + v.weight;
                }
            }
        }
        System.out.println(Arrays.toString(d));
    }



    int[] dijkstra(int s){
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
        boolean[] added = new boolean[n];
        for(int i=0;i<n;i++){
            int u  = -1;
            for(int j = 0;j<n;j++){
                if(!added[j] && (u==-1 || dist[j]<dist[u])){
                    u = j;
                }
            }
            added[u] = true;
            for(Node1 v:data[u]){
                if(!added[v.vertex] && dist[u]+v.weight<dist[v.vertex]){
                    dist[v.vertex] = dist[u]+v.weight;
                }
            }
        }
        return dist;
    }


    int prims2(){
        int res = 0;
        boolean mst[] = new boolean[n];
        int[] key = new int[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        for(int count =0;count<n;count++){
            int u = -1;
            int min = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                if(!mst[i] && key[i]<min){
                    min = key[i];
                    u = i;
                }
            }

            mst[u] = true;
            res+=min;
            for(Node1 v: data[u]){
                if(!mst[v.vertex] && v.weight<key[v.vertex])
                    key[v.vertex] = v.weight;
            }
        }
        return res;
    }

    int prims(){
        int res = 0;
        List<Integer> mst= new ArrayList<>();
        List<Integer> nonMst = new ArrayList<>();
        for(int i=1;i<n;i++)
            nonMst.add(i);
        mst.add(0);

        while(!nonMst.isEmpty()){
            int min = Integer.MAX_VALUE;
            int v = -1;
            for(int x: mst){
                for(Node1 y: data[x]){
                    if(!mst.contains(y.vertex) && y.weight<min){
                        min = y.weight;
                        v = y.vertex;
                    }
                }
            }
            res+=min;
            mst.add(v);
            nonMst.remove((Integer)v);
        }
        return res;
    }

    void shortestPathDAGTopo(){
        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        int[] topSort = toplogicalSortDFS();
        for(int i=0;i<n;i++){
            int x = topSort[i];
            for(Node1 u: data[x]){
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
        for(Node1 v: data[s]){
            if(!visited[v.vertex])
                dfs(v.vertex, visited, st);
        }
        st.push(s);
    }

    void addUEdge(int u, int v, int cost){
        data[u].add(new Node1(v, cost));
        data[v].add(new Node1(u, cost));
    }

    void removeUEdge(int u, int v){
        data[u].remove(new Node1(v, 0));
        data[v].remove(new Node1(u, 0));
    }

    void addDEdge(int u, int v, int cost){
        data[u].add(new Node1(v, cost));
    }

    void removeDEdge(int u, int v){
        data[u].remove(new Node1(v, 0));
    }

    void disp(){
        for(int i=0;i<n;i++){
            System.out.print(i+" | ");
            for(Node1 x: data[i]){
                System.out.print(" -> "+x.vertex+"("+x.weight+")");
            }
            System.out.println();
        }
    }

}

class Node1{
    int vertex;
    int weight;

    Node1(int vertex, int cost){
        this.vertex = vertex;
        this.weight = cost;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Node1){
            Node1 x = (Node1)o;
            return x.vertex==this.vertex;
        }
        return false;
    }
}

class Graph1{
    List<Integer>[] data;
    int n;

    Graph1(int n){
        this.n = n;
        data = new List[n];
        for(int i=0;i<n;i++)
            data[i] = new ArrayList<Integer>();
    }

    boolean hasArticulationPoint(){
        for(int i=0;i<n;i++){
            System.out.println("checking for: "+i);
            boolean[] visited = new boolean[n];
            if(!visited[i]){
                boolean re = dfsArti(i, visited);
                System.out.println("result: "+re);
                if(re)
                    return true;
            }
        }
        return false;
    }

    boolean dfsArti(int s, boolean[] visited){
        int count = 0;
        visited[s] = true;
        for(int v:data[s]){
            if(!visited[v]){
                System.out.println("dfs : "+v);

                if(count>0)
                    return true;
                dfsArti(v, visited);
                count++;
            }
        }
        return false;
    }

    void kosaraju(){
        Stack<Integer> finish = new Stack<>();
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                order(i, visited, finish);
            }
        }

        List<Integer>[] newData = new List[n];
        for(int i=0;i<n;i++)
            newData[i] = new ArrayList<Integer>();

        for(int i=0;i<n;i++){
            List<Integer> ls = this.data[i];
            for(Integer v: ls){
                newData[v].add(i);
            }
        }

        this.data = newData;
        visited = new boolean[n];
        while(!finish.empty()){
            int v = finish.pop();
            if(!visited[v]){
                dfs(v, visited);
            }
            System.out.println();
        }
    }

    void order(int s,boolean[] visited, Stack<Integer> finish){
        visited[s] = true;
        for(int v: data[s]){
            if(!visited[v]){
                order(v, visited, finish);
            }
        }
        finish.push(s);
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
                topoDfs(i, visited, st);
        }

        int[] output = new int[n];
        int i=0;
        while (!st.isEmpty())
            output[i++] = st.pop();
        return output;
    }

    void topoDfs(int s, boolean[] visited, Stack<Integer> st){
        visited[s] = true;
        for(int v: data[s]){
            if(!visited[v])
                topoDfs(v, visited, st);
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
        disp(this.data);
    }

    void disp(List<Integer>[] data){
        for(int i =0;i<n;i++){
            System.out.print(i +" | ");
            for (int j=0;j<data[i].size();j++)
                System.out.print(" -> "+data[i].get(j));
            System.out.println();
        }
    }
}
