package com.dsa.linkedlist.dsa_self;

public class Clink {

	public static void main(String[] args) {
		
		Clink cl = new Clink();
		cl.add(10);
		cl.add(20);
		cl.add(30);
		cl.add(40);
		
		cl.disp();
		
		//cl.insertFirst(5);
		cl.removeFirst();
		
		cl.disp();

	}
	
	Node head = null;
	
	void removeFirst() {
		if(head.next == head)
			head = null;
		else {
			Node n1 =head;
			while(n1.next != head)
				n1 = n1.next;
			n1.next = head.next;
			head = head.next;
		}
	}
	
	void insertFirst(int data) {
		if(head == null) {
			head  = new Node(data);
			head.next = head;
		}else {
			Node n1=head,n2 = new Node(data);
			while(n1.next != head)
				n1 = n1.next;
			n1.next = n2;
			n2.next = head;
			head = n2;
		}
	}
	
	void add(int data) {
		if(head == null) {
			head = new Node(data);
			head.next = head;
		}else {
			Node n1 = head;
			while(n1.next!=head)
				n1  =n1.next;
			Node n2 = new Node(data);
			n1.next = n2;
			n2.next =head;
		}
	}
	
	void disp() {
		System.out.println();
		Node n1 = head;
		while(n1.next!=head) {
			System.out.print(n1.data +" ->");
			n1 = n1.next;
		}
		System.out.print(n1.data);
	}
	
	class Node {
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
}
