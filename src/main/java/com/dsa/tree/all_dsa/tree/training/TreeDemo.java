package com.dsa.tree.all_dsa.tree.training;

import java.util.LinkedList;
import java.util.Queue;

public class TreeDemo {

    public static void main(String[] args) {

        Node x = new Node(30);
        Node y = new Node(40);
        Node z = new Node(50);
        x.left = y; x.right = z;

        Node m = new Node(90);
        y.left = m;

        Node n = new Node(70);
        Node p = new Node(10);
        z.left = n; z. right = p;

        //inorder(x);
        // 90, 40, 30, 70, 50, 10
        //System.out.println();

        //preorder(x);
        // 30, 40, 90, 50, 70, 10
        //System.out.println();

        //postorder(x);
        //  90 40 70 10 50 30

        //System.out.println();
        //levelOrder(x);
        // 30 40 50 90 70 10

        System.out.println(max(x));


    }

    static int max(Node root){
        if(root != null){
            int left = max(root.left);
            int right = max(root.right);
            int m = Math.max(left, right);
            return Math.max(root.key, m);
        }
        return 0;
    }

    static boolean search(Node root, int k){
        if(root!=null){
            if(root.key == k)
                return true;
            if(search(root.left, k))
                return true;
            if(search(root.right, k))
                return true;
        }
        return false;
    }

    static int size(Node root){
        if(root!=null){
            int left  = size(root.left);
            int right = size(root.right);
            return left + right + 1;
        }
        return 0;
    }

    static int height(Node root){
        if(root!=null){
            int left = height(root.left);
            int right = height(root.right);
            return Math.max(left, right)  + 1;
        }
        return 0;
    }

    static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            Node x = q.poll();
            System.out.print(" "+x.key);
            if(x.left!=null)
                q.add(x.left);
            if(x.right!=null)
                q.add(x.right);
        }
    }

    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(" "+ root.key);
            inorder((root.right));
        }
    }

    static void preorder(Node root){
        if(root!=null){
            System.out.print(" "+ root.key);
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void postorder(Node root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(" "+root.key);
        }
    }

}

class Node {
    int key;
    Node left, right;
    Node(int key){
        this.key = key;
    }
}
