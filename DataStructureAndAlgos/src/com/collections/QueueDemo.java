package com.collections;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueDemo {

	public static void main(String[] args) {

		// queueOperations();
		blockingQueueOperations();

	}

	private static void blockingQueueOperations() {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

		Integer one = new Integer(1);
		Integer two = new Integer(2);
		Integer three = new Integer(3);
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					// System.out.println(queue.poll());
					System.out.println(queue.take());
					System.out.println(queue.take());
					System.out.println(queue.take());
					// System.out.println(queue.poll());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(500);
					queue.put(one);
					Thread.sleep(1000);
					queue.put(two);
					Thread.sleep(2000);
					queue.put(three);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t.start();
		t1.start();
	}

	private static void queueOperations() {
		Queue<Integer> queue = new PriorityQueue<>(1);

		Integer one = new Integer(1);
		Integer two = new Integer(2);
		Integer three = new Integer(3);
		Integer four = new Integer(4);
		Integer five = new Integer(5);
		Integer six = new Integer(6);
		Integer seven = new Integer(7);

		queue.add(one);
		queue.offer(two);
		queue.add(three);
		queue.offer(four);
		queue.offer(five);

		// returns null when queue is empty else return head of queue
		System.out.println("peek " + queue.peek());
		// throws NoSuchElementException when queue is empty else return head
		System.out.println("element " + queue.element());

		// returns null when queue is empty else remove head of queue
		System.out.println("poll " + queue.poll());
		// throws NoSuchElementException when queue is empty else remove head of
		System.out.println("remove " + queue.remove());

		System.out.println("Printing all elements");
		for (Integer item : queue) {
			System.out.println(item);
		}

		System.out.println("offer " + queue.offer(six));
		System.out.println("add " + queue.add(seven));

		System.out.println("Printing all elements");
		for (Integer item : queue) {
			System.out.println(item);
		}
	}
}
