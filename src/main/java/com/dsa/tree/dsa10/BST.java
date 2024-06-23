//package com.dsa.tree.dsa10;
//
//public class BST {
//    public static void main(String[] args) {
//	// Node root = new Node(10);
//	// Node five = new Node(5);
//	// Node twenty = new Node(20);
//	// root.left = five;
//	// root.right = twenty;
//	//
//	// Node four = new Node(4);
//	// Node six = new Node(6);
//	// five.left = four;
//	// five.right = six;
//	//
//	// Node fifteen = new Node(15);
//	// Node twoFive = new Node(25);
//	//
//	// twenty.left = fifteen;
//	// twenty.right = twoFive;
//	//
//	// twoFive.right = new Node(40);
//	// // System.out.println(search(root, 15));
//	// // System.out.println(search(root, 75));
//	// System.out.println(max(root));
//	System.out.println("\ninserting 6");
//	insertItr(6);
//	inOrder(root);
//
//	System.out.println("\ninserting 9");
//	insertItr(9);
//	inOrder(root);
//
//	System.out.println("\ninserting 10");
//	insertItr(10);
//	inOrder(root);
//
//	System.out.println("\ninserting 5");
//	insertItr(5);
//	inOrder(root);
//
//	System.out.println("\ninserting 3");
//	insertItr(3);
//	inOrder(root);
//
//    }
//
//    static Node root;
//
//    static void insertItr(int key) {
//	if (root == null)
//	    root = new Node(key);
//	else {
//	    Node x = root, p = null;
//	    while (x != null) {
//		p = x;
//		if (key < x.key)
//		    x = x.left;
//		else
//		    x = x.right;
//	    }
//
//	    if (key < p.key)
//		p.left = new Node(key);
//	    else
//		p.right = new Node(key);
//	}
//
//    }
//
//    static void inOrder(DNode root) {
//	if (root != null) {
//	    inOrder(root.left);
//	    System.out.print(root.key + " ");
//	    inOrder(root.right);
//	}
//    }
//
//    static DNode insert(DNode root, int key) {
//	if (root == null)
//	    return new Node(key);
//	if (key < root.key)
//	    root.left = insert(root.left, key);
//	else
//	    root.right = insert(root.right, key);
//	return root;
//    }
//
//    static int max(DNode root) {
//	int max = root.key;
//	while (root.right != null) {
//	    max = root.key;
//	    root = root.right;
//	}
//	max = root.key;
//	return max;
//    }
//
//    static DNode search(DNode root, int k) {
//	if (root == null)
//	    return null;
//	if (k == root.key)
//	    return root;
//	if (k < root.key)
//	    return search(root.left, k);
//	else
//	    return search(root.right, k);
//    }
//}
//
//class DNode {
//    int key;
//    Node left, right;
//
//    DNode(int key) {
//	this.key = key;
//    }
//
//    @Override
//    public String toString() {
//	return "Node [key=" + key + "]";
//    }
//}
