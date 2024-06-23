package com.dsa.linkedlist.dsa10;

public class SLink {

    public static void add(SNode head, int data) {
	if (head == null)
	    head = new SNode(data);
	else {
	    SNode n1 = head;
	    while (n1.next != null) {
		n1 = n1.next;
	    }
	    n1.next = new SNode(data);
	}
    }

    public static void remove(SNode head, int data) {
	if (head.data == data) {
	    head = head.next;
	    return;
	}

	SNode prev = head, n1 = head.next;
	while (n1 != null) {
	    if (n1.data == data) {
		prev.next = n1.next;
		return;
	    }
	    n1 = n1.next;
	}
    }

    public static void disp(SNode head) {
	System.out.println();
	SNode n1 = head;
	while (n1 != null) {
	    System.out.print(n1.data + " -> ");
	    n1 = n1.next;
	}
    }
}
