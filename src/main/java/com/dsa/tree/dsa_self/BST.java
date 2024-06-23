package main.java.tree;

public class BST {

    static class Node{
        int key;
        Node left, right;
        Node(int key){
            this.key = key;
        }
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(null, 7);
        root = insert(root, 2);
        root = insert(root, 5);
        root = insert(root, 1);
        root = insertRecurive(root, 20);
//        inorder(root);

//        System.out.println(search(root, 51));
        System.out.println(max(root));
    }

    static int max(Node root){
        int max = root.key;
        while(root.right !=null){
            max = root.key;
            root = root.right;
        }
        max = root.key;
        return max;
    }

    static boolean search(Node root, int k){
        if(root == null)
            return false;
        if(k == root.key)
            return true;
        if(k<root.key)
            return search(root.left, k);
        else
            return search(root.right, k);
    }

    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.key+ " ");
            inorder(root.right);
        }
    }

    static Node insertRecurive(Node root, int key){
        if(root == null)
            return new Node(key);
        if(key<root.key)
            root.left = insertRecurive(root.left, key);
        else
            root.right = insertRecurive(root.right, key);
        return root;
    }

    static Node insert(Node root, int key){
        if(root == null)
            root = new Node(key);
        else{
            Node x = root, p = null;
            while(x!=null){
                p = x;
                if(key<root.key)
                    x = x.left;
                else
                    x = x.right;
            }
            if(key<p.key)
                p.left = new Node(key);
            else
                p.right = new Node(key);
        }
        return root;
    }
}


