package com.dsa.linkedlist;

public class CopyOfSinglyLinkedList {

	private Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	void printAllNodes() {
		Node currentNode = this.head;
		while (currentNode != null) {
			System.out.format(" %d ", currentNode.data);
			currentNode = currentNode.next;
		}
	}

	void addNodeAtFirst(Node node) {
		if (this.head == null) {
			this.head = node;
			return;
		}
		node.next = head;
		head = node;
	}

	void addNodeAtLast(Node node) {
		if (this.head == null) {
			this.head = node;
			return;
		}
		Node currentNode = this.head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = node;
	}

	void addNodeAtAfter(Node prevNode, Node node) {
		if (prevNode == null) {
			System.out.println(" prevNode is null !!");
			return;
		}
		node.next = prevNode.next;
		prevNode.next = node;
	}

	void deleteFirstNode() {
		this.head = this.head.next;
	}

	void deleteLastNode() {
		Node currentNode = this.head;
		Node prev = null;
		while (currentNode.next != null) {
			prev = currentNode;
			currentNode = currentNode.next;
		}
		prev.next = null;
	}

	void deleteNodeAtAnyPosition(Node nodeToBeDeleted) {
		int value = nodeToBeDeleted.data;
		if (this.head == null) {
			System.out.println(" head is null !! ");
			return;
		}
		Node currentNode = this.head;
		Node prevNode = null;
		while (currentNode != null && currentNode.data != value) {
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		if (currentNode == null) {
			System.out.println("Node is not Found !!");
		}
		prevNode.next = currentNode.next;
	}

	public static void main(String[] args) {
		CopyOfSinglyLinkedList ll = new CopyOfSinglyLinkedList();
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
