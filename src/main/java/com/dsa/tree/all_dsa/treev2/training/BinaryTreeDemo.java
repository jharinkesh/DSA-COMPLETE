package com.dsa.tree.all_dsa.treev2.training;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class BinaryTreeDemo {

    public static void main2(String[] args) {
        Node root = new Node(30);

        Node n40 = new Node(40);
        Node n50 = new Node(50);

        root.left = n40;
        root.right = n50;

        Node n70 = new Node(70);
        n40.left = n70;

        Node n60 = new Node(60);
        Node n80 = new Node(80);

        n50.left = n60;
        n50.right = n80;

        inorder(root);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        Node n20 = new Node(20);
        Node n30 = new Node(30);

        root.left = n20;
        root.right = n30;

        Node n60 = new Node(60);
        n30.right = n60;

        Node n40 = new Node(40);
        Node n50 = new Node(50);

        n20.left = n40;
        n20.right = n50;

        Node n70 = new Node(70);
        Node n80 = new Node(80);

        n50.left = n70;
        n50.right = n80;

        //inorder(root);
        //System.out.println(height(root));
        //levelOrder(root);
        //System.out.println(findPath(root, 80, new ArrayList<>()));
//        printLevel(root, 3);


//        System.out.println(maxWidth(root));

//        int[] in = {40, 20, 70, 50, 80, 10, 30, 60};
//        int[] pre = {10, 20, 40, 50, 70, 80, 30, 60};
//        int n = in.length;
//        Node newRoot = construct(in, pre, 0, n-1);
//        inorder(newRoot);
//        System.out.println();
//        preorder(newRoot);

        System.out.println(lca(root, 40, 60));
    }

    static int lca(Node root, int n1, int n2){
        List<Integer> l1 = findPath(root, n1, new ArrayList<>());
        if(l1.isEmpty()) return -1;
        List<Integer> l2 = findPath(root, n2, new ArrayList<>());
        if(l2.isEmpty()) return -1;
        int i = 0;
        while(i<l1.size() && i<l2.size()){
            if(!l1.get(i).equals(l2.get(i)))
                break;
            i++;
        }
        return l1.get(i-1);
    }

    static int pIndex = 0;
    static Node construct(int[] in, int[] pre, int start, int end){
        if(start<=end){
            Node root = new Node(pre[pIndex]);
            pIndex++;
            int index = -1;
            for(int i=start;i<=end;i++){
                if(in[i] == root.key){
                    index = i;
                    break;
                }
            }

            root.left = construct(in, pre, start, index-1);
            root.right = construct(in, pre, index+1, end);
            return root;
        }
        return null;
    }

    static int maxWidth(Node root){
        int r = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int c = q.size();
            r = Math.max(r, c);
            for(int i =0;i<c;i++){
                Node x = q.poll();
                if(x.left!=null)
                    q.add(x.left);
                if(x.right!=null)
                    q.add(x.right);
            }
        }

        return r;
    }


    static List<Integer> findPath(Node root, int k, List<Integer> path){
        if(root == null)
            return null;
        path.add(root.key);
        if(root.key == k)
            return path;

        List<Integer> p = findPath(root.left, k, new ArrayList<>(path));
        if(p!=null)
            return p;
        return findPath(root.right, k , new ArrayList<>(path));
    }


    static void printLevel(Node root, int k){
        if(root == null)
            return;
        if(k == 0)
            System.out.print(root.key + " ");
        else{
            printLevel(root.left, k-1);
            printLevel(root.right, k-1);
        }
    }

    static int getMax(Node root){
        if(root == null)
            return -1;
        int mx = root.key;
        if(root.left !=null)
            mx = Math.max(getMax(root.left), mx);
        if(root.right !=null)
            mx = Math.max(getMax(root.right), mx);
        return mx;
    }


    static boolean search(Node root, int k){
        if(root == null)
            return false;
        return (root.key == k) || search(root.left, k) || search(root.right, k);
    }

    static int size(Node root){
        if(root == null)
            return 0;
        return size(root.left)
                +size(root.right)
                +1;
    }

    static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node x = q.poll();
            System.out.print(x.key + " ");
            if (x.left != null)
                q.add(x.left);
            if (x.right != null)
                q.add(x.right);
        }
    }

    static int height(Node root){
        if(root !=null){
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh,rh) + 1;
        }
        return 0;
    }

    static void preorder(Node root){
        if(root!=null){
            System.out.print(root.key +" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void postorder(Node root){
        if(root !=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key+ " ");
        }
    }

    static  void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.key+ " ");
            inorder(root.right);
        }
    }

}
