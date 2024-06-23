package com.dsa.linkedlist.dsa_self;

public class CycleLinkedList {

	public static void main(String[] args) {
		CycleLinkedList ls = new CycleLinkedList();
		ls.makeList();
		//ls.disp();
		System.out.println(ls.hasCycle());
		
	}
	
	boolean hasCycle() {
		Node s = head, f = head;
		while(s!=null && f!=null && f.next !=null) {
			s = s.next;
			f = f.next.next;
			if(s == f)
				return true;
		}
		return false;
	}
	
	void makeList() {
		head = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		
		head.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		
		six.next = three;
		
	}
	
	Node head;
	
	class Node {
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	
	void disp() {
		System.out.println();
		Node n1 =head;
		while(n1!=null) {
			System.out.print(n1.data +"->");
			n1 = n1.next;
		}
	}
}
