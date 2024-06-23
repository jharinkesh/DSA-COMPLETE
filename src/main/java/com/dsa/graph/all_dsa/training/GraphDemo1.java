package com.dsa.graph.all_dsa.training;
import java.util.*;

public class GraphDemo1 {

    public static void main(String[] args) {

        Graph g = new Graph(5);
//        g.addDEdge(0,1);
//        g.addDEdge(0,2);
//        g.addDEdge(1,2);
//        g.addDEdge(2,3);
//        g.disp();
//        g.removeDEdge(0,2);
//        g.disp();

//        g.addUEdge(0,1);
//        g.addUEdge(0,2);
//        g.addUEdge(0,3);
//        g.addUEdge(1,4);
//        g.addUEdge(4,5);
//        g.addUEdge(5,6);
//        g.addUEdge(3,6);
//        g.addUEdge(2,5);

//        g.addUEdge(0,1);
//        g.addUEdge(0,2);
//        g.addUEdge(0,3);
//        g.addUEdge(2,8);
//        g.addUEdge(2,6);
//        g.addUEdge(3,4);
//        g.addUEdge(3,6);
//        g.addUEdge(4,5);
//        g.addUEdge(6,7);

//        g.addUEdge(0,1);
//        g.addUEdge(1,2);
//        g.addUEdge(1,3);
//        g.addUEdge(2,3);
//        g.addUEdge(3,4);
//
//        g.addUEdge(5,6);
//        g.addUEdge(6,7);
//        g.addUEdge(5,7);

        //g.addUEdge(0,1);
        //g.addUEdge(0,2);
//        g.addUEdge(2,3);
//        g.addUEdge(2,4);
//        g.addUEdge(4,5);
//        g.addUEdge(2,5);
//        g.addUEdge(1,3);
//        g.addUEdge(3,5);


        g.addDEdge(0,2);
        g.addDEdge(0,3);
        g.addDEdge(1,3);
        g.addDEdge(2,3);
        g.addDEdge(1,4);

        g.disp();
        System.out.println();
        //g.bfs(2);
        //g.dfs(0, new boolean[7]);
        //g.bfsDisconnected();
        //g.shortestPath(0);
        //System.out.println(g.hasCycle(0, new boolean[6], -1));




        g.toplogicalSortDFS();

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

    void toplogicalSortDFS(){
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(!visited[i])
                dfs(i, visited, st);
        }

        while (!st.isEmpty())
            System.out.print(st.pop()+" ");
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

        System.out.println("in: " + Arrays.toString(in));

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