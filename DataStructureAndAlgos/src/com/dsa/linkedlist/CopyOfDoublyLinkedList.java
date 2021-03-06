package com.dsa.linkedlist;

public class CopyOfDoublyLinkedList {

	Node head;

	static class Node {
		int data;
		Node prev;
		Node next;

		Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}

	void printAllNodes() {
		Node currentNode = this.head;
		while (currentNode != null) {
			if (currentNode.prev != null) {
				System.out.print(" prevNode " + currentNode.prev.data);
			} else {
				System.out.print(" prevNode null ");
			}
			System.out.format(" currentNode %d ", currentNode.data);
			if (currentNode.next != null) {
				System.out.print(" nextNode " + currentNode.next.data);
			} else {
				System.out.print(" nextNode null ");
			}
			System.out.println("");
			currentNode = currentNode.next;
		}
		System.out.println("");
	}

	void addNodeAtFirst(Node node) {
		if (this.head == null) {
			node.next = this.head;
			node.prev = null;
			this.head = node;
		}
		node.next = this.head;
		this.head.prev = node;
		this.head = node;
	}

	void addNodeAtLast(Node node) {
		if (this.head == null) {
			node.next = this.head;
			node.prev = null;
			this.head = node;
		}
		Node currentNode = this.head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = node;
		node.prev = currentNode;
	}

	void addNodeAfterGivenNode(Node prevNode, Node node) {
		if (prevNode == null) {
			System.out.println(" prevNode is null !! ");
			return;
		}
		node.next = prevNode.next;
		node.prev = prevNode;

		prevNode.next = node;

		if (node != null) {
			node.next.prev = node;
		}
	}

	void addNodeBeforeGivenNode(Node nextNode, Node node) {
		if (nextNode == null) {
			System.out.println(" nextNode is null !! ");
			return;
		}
		node.prev = nextNode.prev;
		node.next = nextNode;

		nextNode.prev = node;
		node.prev.next = node;
	}

	void removeNodeAtFirst() {
		this.head = this.head.next;
		this.head.prev = null;
	}

	void removeNodeAtLast() {
		Node currentNode = this.head;
		Node prevNode = null;

		while (currentNode.next != null) {
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		prevNode.next = null;
	}

	void removeGivenNode(Node node) {
		int value = node.data;
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
		currentNode.next.prev = prevNode;
	}

	public static void main(String[] args) {
		CopyOfDoublyLinkedList dll = new CopyOfDoublyLinkedList();
		Node head = new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);

		dll.head = head;
		dll.head.prev = null;
		dll.head.next = second;

		second.prev = head;
		second.next = third;

		third.prev = second;
		third.next = null;

		dll.printAllNodes();

		Node addNodeAtFirst = new Node(5);
		dll.addNodeAtFirst(addNodeAtFirst);

		dll.printAllNodes();

		Node addNodeAtLast = new Node(40);
		dll.addNodeAtLast(addNodeAtLast);

		dll.printAllNodes();

		Node addNodeAfterGivenNode = new Node(25);
		dll.addNodeAfterGivenNode(second, addNodeAfterGivenNode);

		dll.printAllNodes();

		Node addNodeBeforeGivenNode = new Node(15);
		dll.addNodeBeforeGivenNode(second, addNodeBeforeGivenNode);

		dll.printAllNodes();

		dll.removeNodeAtFirst();
		dll.printAllNodes();

		dll.removeNodeAtLast();
		dll.printAllNodes();

		dll.removeGivenNode(addNodeAfterGivenNode);
		dll.printAllNodes();
	}

}
