package com.dsa.tree.all_dsa.treev2.training;

import java.util.ArrayList;
import java.util.List;

public class BST {

    public static void main(String[] args) {

        Node root = add(null, 40);
        add(root, 50);
        add(root, 60);
        add(root,20);
        add(root, 10);
        add(root, 30);
        add(root, 90);
//        root.key = 100;
        //inorder(root);
        //System.out.println(isValid(root));
        //System.out.println(search(root, 600));
        //inorder(root);
        //System.out.println();
        //remove(root, 40);
        //inorder(root);

        //addLoop(root, 66);
        //addLoop(root, 77);
        //inorder(root);

        //System.out.println(kthSmallest(root, 5));

        mirror(root);
        inorder(root);

    }

    static Node mirror(Node root){
        if(root == null) return null;
        Node left = mirror(root.left);
        root.left = mirror(root.right);
        root.right = left;
        return root;
    }

    static int kthSmallest(Node root, int k){
        List<Integer> ls = new ArrayList<>();
        inordPush(root, ls);
        return ls.get(k-1);
    }

    static void inordPush(Node root, List<Integer> ls){
        if(root!=null){
            inordPush(root.left, ls);
            ls.add(root.key);
            inordPush(root.right, ls);
        }
    }

    static void addLoop(Node root, int k){
        Node p = null, current = root;
        while(current !=null){
            Node t = current;
            if(k<current.key)
                current = current.left;
            else
                current = current.right;
            p = t;
        }

        if(k<p.key)
            p.left = new Node(k);
        else
            p.right = new Node(k);
    }

    static Node remove(Node root, int k){
        if(root == null)
            return null;
        if(k<root.key)
            root.left = remove(root.left,k);
        else if(k>root.key)
            root.right = remove(root.right, k);
        else {
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            root.key = min(root.right);
            root.right = remove(root.right, root.key);
        }
        return root;
    }



    static boolean search(Node root, int k){
        if(root == null)
            return false;
        if(k == root.key)
            return true;
        if(k<root.key)
            return search(root.left, k);
        return search(root.right, k);
    }

    static boolean isValid(Node root){
        if(root == null)
            return true;

        if(root.left!=null){
            if(max(root.left)>root.key)
                return false;
        }

        if(root.right!=null){
            if(min(root.right)< root.key)
                return false;
        }

        return isValid(root.left)
                && isValid(root.right);
    }





    static int min(Node root){
        if(root == null)
            return -1;
        int mx = root.key;
        if(root.left !=null)
            mx = Math.min(min(root.left), mx);
        if(root.right !=null)
            mx = Math.min(min(root.right), mx);
        return mx;
    }

    static int max(Node root){
        if(root == null)
            return -1;
        int mx = root.key;
        if(root.left !=null)
            mx = Math.max(max(root.left), mx);
        if(root.right !=null)
            mx = Math.max(max(root.right), mx);
        return mx;
    }

    static Node add(Node root, int k){
        if(root == null)
            return new Node(k);
        if(k<root.key)
            root.left = add(root.left, k);
        if(k>root.key)
            root.right = add(root.right, k);
        return root;
    }

    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.key+" ");
            inorder(root.right);
        }
    }




    static class Node {
        int key;
        Node left;
        Node right;
        Node(int key) {
            this.key = key;
        }
    }
}
