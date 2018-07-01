package com.dsa.queue;

public class CopyOfQueueImpl {

	private int front;
	private int rear;
	private int size;
	private int capacity;
	private int[] queue;

	private CopyOfQueueImpl(int capacity) {
		this.front = 0;
		this.size = 0;
		this.capacity = capacity;
		this.rear = this.capacity - 1;
		this.queue = new int[this.capacity];
	}

	private boolean isEmpty() {
		if (this.size == 0) {
			return true;
		}
		return false;
	}

	private boolean isFull() {
		if (this.size == this.capacity) {
			return true;
		}
		return false;
	}

	private boolean enqueue(int item) {
		if (!isFull()) {
			this.rear = (this.rear + 1) % (this.capacity);
			this.queue[this.rear] = item;
			size++;
			return true;
		}
		System.out.println("Queue is Full !!");
		return false;
	}

	private int dequeue() {
		if (!isEmpty()) {
			int item = this.queue[this.front];
			this.front = (this.front + 1) % (this.capacity);
			size--;
			return item;
		}
		System.out.println("Queue is Empty !!");
		return 0;
	}

	private int front() {
		if (!isEmpty()) {
			int item = this.queue[this.front];
			return item;
		}
		System.out.println("Queue is Empty !!");
		return 0;
	}

	private int rear() {
		if (!isEmpty()) {
			int item = this.queue[this.rear];
			return item;
		}
		System.out.println("Queue is Empty !!");
		return 0;
	}

	public int size() {
		return this.size;
	}

	public static void main(String[] args) {
		CopyOfQueueImpl qi = new CopyOfQueueImpl(5);

		System.out.println(" dequeue " + qi.dequeue());
		qi.enqueue(10);
		qi.enqueue(20);
		qi.enqueue(30);
		qi.enqueue(40);
		qi.enqueue(50);

		System.out.println(" front " + qi.front());
		System.out.println(" rear " + qi.rear());

		System.out.println(" dequeue " + qi.dequeue());

		System.out.println(" front " + qi.front());
		System.out.println(" rear " + qi.rear());

		qi.enqueue(60);

		System.out.println(" front " + qi.front());
		System.out.println(" rear " + qi.rear());
	}

}
