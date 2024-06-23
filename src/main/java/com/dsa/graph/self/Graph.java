package com.dsa.graph.self;

import java.util.*;

public class Graph {
    List<Node> list[];
    int n;

    Graph(int n){
        this.n = n;
        list = new List[n];
        for(int i=0;i<n;i++){
            list[i] = new ArrayList<>();
        }
    }

    void addUEdge(int u, int v, int w){
        list[u].add(new Node(v,w));
        list[v].add(new Node(u,w));
    }

    void addUEdge(int u, int v){
        list[u].add(new Node(v));
        list[v].add(new Node(u));
    }

    void removeUEdge(int u, int v){
        list[u].remove(new Node(v));
        list[v].remove(new Node(u));
    }

    void addDEdge(int u, int v, int w){
        list[u].add(new Node(v,w));
    }


    void addDEdge(int u, int v){
        list[u].add(new Node(v));
    }

    void removeDEdge(int u, int v){
        list[u].remove(new Node(v));
    }

    void print(){
        for(int i=0;i<n;i++){
            System.out.print(i+" |");
            for(Node node : list[i]){
                System.out.print("-->(" + node.vertex+")");
            }
            System.out.println();
        }
    }

    void printWeighted(){
        for(int i=0;i<n;i++){
            System.out.print(i+" |");
            for(Node x: list[i]){
                System.out.print(" --"+x.vertex+"-->("+x.weight+")");
            }
            System.out.println();
        }
    }
}
