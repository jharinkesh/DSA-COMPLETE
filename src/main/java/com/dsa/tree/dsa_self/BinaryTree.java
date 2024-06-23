package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public static void main(String[] args) {
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);

        four.left = five;
        four.right = six;

        five.left = seven;
        five.right = eight;

        six.left = nine;
        six.right = ten;

//        inorder(four);
//        preorder(four);
//        System.out.println();
//        postorder(four);
//        levelOrder(four);
//        System.out.println(search2(four, 91));
//        System.out.println(height(four));
//        System.out.println(getMax(four));
        printlevel(four, 2);
    }

    static void printlevel(Node root, int k){
        if(root!=null){
            if(k==0)
                System.out.print(root.key+" ");
            else {
                printlevel(root.left, k - 1);
                printlevel(root.right, k-1);
            }
        }
    }

    static Integer getMax(Node root){
        if(root!=null){
            int m = root.key;
            if(root.left!=null)
                m = Math.max(getMax(root.left), m);
            if(root.right!=null)
                m = Math.max(getMax(root.right), m);
            return m;
        }
        return null;
    }

    static int height(Node root){
        if(root !=null){
            int lh = height(root.left);
            int rh = height(root.right);
            return 1 + (Math.max(lh,rh));
        }
        return 0;
    }

    static boolean search2(Node root, int k){
        if(root == null)
            return false;
        return root.key == k || search(root.left, k) || search(root.right, k);
    }

    static boolean search(Node root, int k){
        if(root != null){
            if(root.key == k)
                return true;
            boolean found = search(root.left, k);
            if(!found)
                found = search(root.right, k);
            return found;
        }
        return false;
    }
    static void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node x = queue.poll();
            System.out.print(x.key +" ");
            if(x.left!=null)
                queue.add(x.left);
            if(x.right!=null)
                queue.add(x.right);
        }
    }

    static void inorder(Node root){
        if(root !=null){
            inorder(root.left);
            System.out.print(root.key +" ");
            inorder(root.right);
        }
    }

    static void preorder(Node root){
        if(root !=null){
            System.out.print(root.key +" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void postorder(Node root){
        if(root !=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key +" ");
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
