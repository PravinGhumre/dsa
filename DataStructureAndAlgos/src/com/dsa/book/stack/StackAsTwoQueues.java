package com.dsa.book.stack;

import java.util.Queue;

@SuppressWarnings("rawtypes")
public class StackAsTwoQueues {

	int size;
	Queue q1, q2;

	StackAsTwoQueues() {
		this.size = 0;
	}

	int size() {
		return this.size;
	}

	void push(int item) {
		size++;

		q2.add(item);

		while (!q1.isEmpty()) {
			q2.add(q1.poll());
			q1.poll();
		}
	}
}
