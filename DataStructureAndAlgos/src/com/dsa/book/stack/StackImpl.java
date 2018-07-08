package com.dsa.book.stack;

public class StackImpl {

	private int top;
	private int size;
	private int[] stack;

	StackImpl(int size) {
		this.size = size;
		this.top = -1;
		this.stack = new int[this.size];
	}

	private boolean isEmpty() {
		if (this.top == -1) {
			return true;
		}
		return false;
	}

	private boolean isFull() {
		if (this.top == (this.size - 1)) {
			return true;
		}
		return false;
	}

	private int pop() {
		if (!isEmpty()) {
			return this.stack[top--];
		}
		System.out.println(" Stack is Empty !!");
		return 0;
	}

	private int peek() {
		if (!isEmpty()) {
			return this.stack[top];
		}
		System.out.println(" Stack is Empty !!");
		return 0;
	}

	private boolean push(int item) {
		if (!isFull()) {
			this.stack[++top] = item;
			return true;
		}
		System.out.println(" Stack is Full !!");
		return false;
	}
	private void printStack() {
		if (!isEmpty()) {
			for (int i = 0; i < top + 1; i++) {
				System.out.print(stack[i] + " ");
			}
		}
	}

	public static void main(String[] args) {

		StackImpl si = new StackImpl(5);
		si.pop();
		System.out.println("");
		si.push(10);
		si.push(20);
		si.push(30);
		si.push(40);
		si.push(50);
		System.out.println("");
		si.push(60);
		System.out.println("");
		int peek = si.peek();
		System.out.println("peek " + peek);
		si.printStack();
		System.out.println("");
		si.pop();
		si.printStack();
		System.out.println("");
		si.push(50);
		si.printStack();
	}

}
