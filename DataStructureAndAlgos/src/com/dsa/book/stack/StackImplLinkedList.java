package com.dsa.book.stack;

public class StackImplLinkedList {

	int size;
	StackNode top;

	StackImplLinkedList() {
		this.top = null;
		this.size = 0;
	}

	static class StackNode {
		int data;
		StackNode next;

		StackNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {

		StackImplLinkedList si = new StackImplLinkedList();
		si.pop();
		si.push(10);
		si.push(20);
		si.push(30);
		si.push(40);
		si.push(50);
		si.push(60);
		int peek = si.peek();
		System.out.println("peek " + peek);
		si.printStack();
		System.out.println("");
		si.pop();
		si.printStack();
		System.out.println("");
		si.push(60);
		si.printStack();
	}

	private int pop() {
		if (!isEmpty()) {
			StackNode currentNode = this.top;
			this.top = currentNode.next;
			size--;
			return currentNode.data;
		}
		System.out.println(" Stack is empty !!");
		return 0;
	}

	private int peek() {
		if (!isEmpty()) {
			return this.top.data;
		}
		System.out.println(" Stack is empty !!");
		return 0;
	}

	private void push(int item) {
		StackNode newNode = new StackNode(item);
		if (this.top == null) {
			this.top = newNode;
		} else {
			newNode.next = this.top;
			this.top = newNode;
		}
		size++;
	}

	private void printStack() {
		StackNode currentNode = this.top;
		while (currentNode != null) {
			System.out.format("%d ", currentNode.data);
			currentNode = currentNode.next;
		}
	}

	private boolean isEmpty() {
		if (this.top == null) {
			return true;
		}
		return false;
	}

}
