package com.dsa.linkedlist;

public class SinglyLinkedList {

	private Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	void addNodeAtFirst(Node node) {
		if (this.head == null) {
			this.head = node;
			return;
		}
		node.next = this.head;
		this.head = node;

	}

	void addNodeAtLast(Node node) {
		if (this.head == null) {
			this.head = node;
			return;
		}
		Node temp = this.head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}

	void addNodeAtAfter(Node prevNode, Node node) {
		if (prevNode == null) {
			System.out.println(" prevNode is null !!");
			return;
		}
		node.next = prevNode.next;
		prevNode.next = node;
	}

	void printAllNodes() {
		Node temp = this.head;
		while (temp != null) {
			System.out.format("%d ", temp.data);
			temp = temp.next;
		}
	}

	void deleteFirstNode() {
		this.head = this.head.next;
	}

	void deleteLastNode() {
		Node temp = this.head;
		Node prevNode = null;
		while (temp.next != null) {
			prevNode = temp;
			temp = temp.next;
		}
		prevNode.next = null;
	}

	void deleteNodeAtAnyPosition(Node nodeToBeDeleted) {
		int value = nodeToBeDeleted.data;
		Node temp = this.head;
		Node prevNode = null;
		while (temp != null && temp.data != value) {
			prevNode = temp;
			temp = temp.next;
		}

		if (temp == null) {
			System.out.println("Node is not found !!");
			return;
		}
		prevNode.next = temp.next;
	}

	public static void main(String[] args) {
		SinglyLinkedList ll = new SinglyLinkedList();
		Node head = new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);
		Node fourth = new Node(40);

		ll.head = head;
		ll.head.next = second;
		second.next = third;
		third.next = fourth;
		
		ll.printAllNodes();
		
		Node addAtFirst = new Node(5);
		ll.addNodeAtFirst(addAtFirst);
		System.out.println("\n");
		ll.printAllNodes();
		
		Node addAtMiddle = new Node(35);
		ll.addNodeAtAfter(third, addAtMiddle);
		System.out.println("\n");
		ll.printAllNodes();
		
		Node addAtLast = new Node(45);
		ll.addNodeAtLast(addAtLast);
		System.out.println("\n");
		ll.printAllNodes();
		
		ll.deleteFirstNode();
		System.out.println("\n");
		ll.printAllNodes();
		
		ll.deleteLastNode();
		System.out.println("\n");
		ll.printAllNodes();
		
		ll.deleteNodeAtAnyPosition(addAtMiddle);
		System.out.println("\n");
		ll.printAllNodes();
	}

}
