package com.collections;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@SuppressWarnings({"rawtypes", "unused"})
public class QueueDemo {

	public static void main(String[] args) {

		// queueOperations();
		// blockingQueueOperations();
		dequeOperations();

	}

	private static void dequeOperations() {
		Deque<String> deque = new LinkedList<>();

		// We can add elements to the queue in various ways
		deque.add("Element 1 (Tail)"); // add to tail
		deque.addFirst("Element 2 (Head)");
		deque.addLast("Element 3 (Tail)");
		deque.push("Element 4 (Head)"); // add to head
		deque.offer("Element 5 (Tail)");
		deque.offerFirst("Element 6 (Head)");
		deque.offerLast("Element 7 (Tail)");

		System.out.println(deque + "\n");

		// Iterate through the queue elements.
		System.out.println("Standard Iterator");
		Iterator iterator = deque.iterator();
		while (iterator.hasNext())
			System.out.println("\t" + iterator.next());

		// Reverse Iterate through the queue elements.
		System.out.println("Reverse Iterator");
		Iterator reverseIterator = deque.descendingIterator();
		while (reverseIterator.hasNext())
			System.out.println("\t" + reverseIterator.next());

		// Peek returns the head, without deleting
		// it from the deque
		System.out.println("Peek " + deque.peek());
		System.out.println("After peek: " + deque);

		// Pop returns the head, and removes it from
		// the deque
		System.out.println("Pop " + deque.pop());
		System.out.println("After pop: " + deque);

		// We can check if a specific element exists
		// in the deque
		System.out.println(
				"Contains element 3: " + deque.contains("Element 3 (Tail)"));

		// We can remove the first / last element.
		deque.removeFirst();
		deque.removeLast();
		System.out
				.println("Deque after removing " + "first and last: " + deque);

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
