package com.dsa.linkedlist.dsa_self;

public class DoublyLinkedList {
	
	
	public static void main(String[] args) {
		DoublyLinkedList lst = new DoublyLinkedList();
		lst.add(6);
		lst.add(7);
		lst.add(8);
		lst.add(9);
		lst.disp();
		lst.reverse();
		lst.disp();
	}
	
	void reverse() {
		Node n1 = head;
		while(n1!=null) {
			head = n1;
			Node t = n1.next;
			n1.next = n1.prev;
			n1.prev = t;
			n1 = t;
		}
	}
	
	void insertLast(int data) {
		if(head == null)
			head = new Node(data);
		else {
			Node n1 = head;
			while(n1.next !=null)
				n1 =n1.next;
			Node n2 = new Node(data);
			n1.next = n2;
			n2.prev = n1;
		}
	}
	
	void insertFirst(int data) {
		if(head == null)
			head = new Node(data);
		else {
				Node n2 = new Node(data);
				Node n1 = head;
				n2.next = n1;
				n1.prev = n2;
				head = n2;
			}
	}
	
	
	Node head = null;
	void add(int data) {
		if(head == null)
			head = new Node(data);
		else {
			Node n1 =head;
			while(n1.next!=null)
				n1 = n1.next;
			
			Node n2 = new Node(data);
			n1.next = n2;
			n2.prev =n1;
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

	class Node{
		int data;
		Node prev, next;
		Node(int data){
			this.data = data;
		}
	}
}


