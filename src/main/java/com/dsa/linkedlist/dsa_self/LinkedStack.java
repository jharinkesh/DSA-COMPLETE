package com.dsa.linkedlist.dsa_self;

public class LinkedStack {

	public static void main(String[] args) throws Exception {
		LinkedStack ls = new LinkedStack();
		ls.push(10);
		ls.push(20);
		ls.push(30);
		ls.push(40);
		ls.disp();
		
		System.out.println(ls.pop());
		System.out.println(ls.pop());
		System.out.println(ls.pop());
		System.out.println(ls.pop());
		System.out.println(ls.pop());

	}
	
	private void push(int data) {
		if(head == null)
			head = new Node(data);
		else {
			Node n1 = new Node(data);
			n1.next = head;
			head = n1;
		}
	}
	
	private int pop() throws Exception {
		if(head!=null) {
			Node n1 = head;
			head = n1.next;
			return n1.data;
		}else {
			throw new Exception("stack underflow");
		}
	}
	
	void disp() {
		System.out.println("elements are ");
		Node n1 =head;
		while(n1!=null) {
			System.out.println(n1.data);
			n1 = n1.next;
		}
	}
	
	
	Node head = null;
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
}


