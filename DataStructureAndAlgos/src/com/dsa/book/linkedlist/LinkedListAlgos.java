package com.dsa.book.linkedlist;

public class LinkedListAlgos {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private static void printAllNodes(Node head) {
		if (head == null) {
			System.out.println(" head is null !!!");
			return;
		}
		Node currentNode = head;
		while (currentNode != null) {
			System.out.format("%d ", currentNode.data);
			currentNode = currentNode.next;
		}
	}

	public static void main(String[] args) {
		LinkedListAlgos lla = new LinkedListAlgos();

		Node firstNode = new Node(10);
		Node secondNode = new Node(20);
		Node thirdNode = new Node(30);
		Node fourNode = new Node(40);

		lla.head = firstNode;
		firstNode.next = secondNode;
		secondNode.next = thirdNode;
		thirdNode.next = fourNode;

		printAllNodes(lla.head);

		Node addAtFirst = new Node(5);
		Node addAtLast = new Node(45);
		Node addAtMiddle = new Node(35);

		// Linked List Algorithms

		lla.addNodeAtFirst(addAtFirst);
		System.out.println("");
		printAllNodes(lla.head);

		lla.addNodeAtLast(addAtLast);
		System.out.println("");
		printAllNodes(lla.head);

		lla.addNodeAfterGivenNode(thirdNode, addAtMiddle);
		System.out.println("");
		printAllNodes(lla.head);

		lla.deleteNodeAtFirst();
		System.out.println("");
		printAllNodes(lla.head);

		lla.deleteNodeAtLast();
		System.out.println("");
		printAllNodes(lla.head);

		lla.deleteNodeAtAnyPosition(addAtMiddle);
		System.out.println("");
		printAllNodes(lla.head);

		// Reverse Linked List
		Node reversedLinkedList = lla.reverseLinkeList(lla.head);
		System.out.println(" ");
		printAllNodes(reversedLinkedList);

		lla.head = lla.reverseLinkeListRecursivly(reversedLinkedList);
		System.out.println(" ");
		printAllNodes(lla.head);

		// Find Middle Element in Linked List
		Node fifth = new Node(50);
		lla.addNodeAtLast(fifth);
		System.out.println("");
		printAllNodes(lla.head);

		Node middleElement = lla.findMiddleElementInLinkedList(lla.head);
		System.out.println("");
		System.out.println(" middleElement " + middleElement.data);

		// Detect and remove loop in Linked List
		fifth.next = secondNode;
		detectAndRemoveLoopInLinkedList(lla.head);
		System.out.println("");
		printAllNodes(lla.head);

		// Union and Intersection of Two Linked List
		LinkedListAlgos llaOne = new LinkedListAlgos();
		llaOne.head = new Node(10);
		llaOne.addNodeAtLast(new Node(15));
		llaOne.addNodeAtLast(new Node(4));
		llaOne.addNodeAtLast(new Node(20));

		LinkedListAlgos llaTwo = new LinkedListAlgos();
		llaTwo.head = new Node(8);
		llaTwo.addNodeAtLast(new Node(4));
		llaTwo.addNodeAtLast(new Node(2));
		llaTwo.addNodeAtLast(new Node(10));

		System.out.println("");
		printAllNodes(llaOne.head);

		System.out.println("");
		printAllNodes(llaTwo.head);

		System.out.println("");
		Node unionOfTwoLL = lla.unionOfTwoLinkedList(llaOne.head, llaTwo.head);
		System.out.println(" unionOfTwoLL ");
		printAllNodes(unionOfTwoLL);

		System.out.println("");
		Node intersectOfTwoLL = lla.intersectOfTwoLinkedList(llaOne.head,
				llaTwo.head);
		System.out.println(" intersectOfTwoLL ");
		printAllNodes(intersectOfTwoLL);

		// Merge Two Sorted Linked List

		LinkedListAlgos llaThree = new LinkedListAlgos();
		llaThree.head = new Node(10);
		llaThree.addNodeAtLast(new Node(20));
		llaThree.addNodeAtLast(new Node(30));
		llaThree.addNodeAtLast(new Node(40));

		LinkedListAlgos llaFour = new LinkedListAlgos();
		llaFour.head = new Node(5);
		llaFour.addNodeAtLast(new Node(15));
		llaFour.addNodeAtLast(new Node(25));
		llaFour.addNodeAtLast(new Node(35));

		System.out.println("");
		printAllNodes(llaThree.head);

		System.out.println("");
		printAllNodes(llaFour.head);

		System.out.println("");
		Node mergedList = mergeTwoSortedList(llaThree.head, llaFour.head);
		System.out.println(" mergedList ");
		printAllNodes(mergedList);

		// Check if Linked List is palindrome or not

		// Reverse Linked List in pairs
		Node reverseLinkedListInPairItr = reverseLinkedListInPairItr(
				mergedList);
		System.out.println("\n reverseLinkedListInPairItr ");
		printAllNodes(reverseLinkedListInPairItr);

		Node reverseLinkedListInPairs = reverseLinkedListInPairs(
				reverseLinkedListInPairItr);
		System.out.println("\n reverseLinkedListInPairs ");
		printAllNodes(reverseLinkedListInPairs);

	}

	private static Node reverseLinkedListInPairs(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		// Lets take example of 5->6->7
		// Here head node is 5
		// Storing 6 in temp node, it will become our new head
		Node temp = head.next;
		// Putting link between 5->7
		head.next = temp.next;
		// putting link between 6->5
		temp.next = head;
		// recursively calling the function for node 7
		head.next = reverseLinkedListInPairs(head.next);
		// returning new head
		return temp;
	}

	private static Node reverseLinkedListInPairItr(Node head) {
		Node current = head;
		Node temp = null;
		Node newHead = null;
		while (current != null && current.next != null) {
			if (temp != null) {
				// This is important step
				temp.next.next = current.next;
			}
			temp = current.next;
			current.next = temp.next;
			temp.next = current;

			if (newHead == null) {
				newHead = temp;
			}
			current = current.next;

		}
		return newHead;
	}

	private Node reverseLinkeListRecursivly(Node head) {
		Node currentNode = head;
		if (currentNode.next == null) {
			head = currentNode;
			return head;
		}
		reverseLinkeListRecursivly(currentNode.next);
		Node prevNode = currentNode;
		prevNode.next = currentNode;
		currentNode.next = null;
		return currentNode;
	}

	private static Node mergeTwoSortedList(Node list1, Node list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.data < list2.data) {
			list1.next = mergeTwoSortedList(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoSortedList(list2.next, list1);
			return list2;
		}
	}

	private Node intersectOfTwoLinkedList(Node head1, Node head2) {
		Node t1 = head1;
		LinkedListAlgos llaNew = new LinkedListAlgos();
		while (t1 != null) {
			if (isPresent(head2, t1.data)) {
				buildNewLinkedList(llaNew, t1.data);
			}
			t1 = t1.next;
		}
		return llaNew.head;
	}

	private Node unionOfTwoLinkedList(Node head1, Node head2) {
		Node t1 = head1;
		Node t2 = head2;

		LinkedListAlgos llaNew = new LinkedListAlgos();
		while (t1 != null) {
			buildNewLinkedList(llaNew, t1.data);
			t1 = t1.next;
		}
		while (t2 != null) {
			if (!isPresent(llaNew.head, t2.data)) {
				buildNewLinkedList(llaNew, t2.data);
			}
			t2 = t2.next;
		}
		return llaNew.head;
	}

	private boolean isPresent(Node headNew, int data) {
		if (headNew == null) {
			System.out.println(" head is null !!!");
			return false;
		}
		Node currentNode = headNew;
		while (currentNode != null) {
			if (currentNode.data == data) {
				return true;
			}
			currentNode = currentNode.next;
		}
		return false;
	}

	private void buildNewLinkedList(LinkedListAlgos llaNew, int data) {
		if (llaNew.head == null) {
			llaNew.head = new Node(data);
			return;
		}
		Node newNode = new Node(data);
		newNode.next = llaNew.head;
		llaNew.head = newNode;
	}

	private static void detectAndRemoveLoopInLinkedList(Node head) {
		if (head == null) {
			System.out.println(" head is null !!!");
			return;
		}
		Node slowPointer = head;
		Node fastPointer = head;

		while (slowPointer != null && fastPointer != null
				&& fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;

			if (slowPointer == fastPointer) {
				System.out.println(" Loop Detected at " + slowPointer.data);
				removeLoop(slowPointer, head);
				break;
			}
		}

	}

	private static void removeLoop(Node loopNode, Node head) {
		Node pointerOne = head;
		Node pointerTwo = null;
		while (true) {
			pointerTwo = loopNode;
			while (pointerTwo.next != loopNode
					&& pointerTwo.next != pointerOne) {
				pointerTwo = pointerTwo.next;
			}
			if (pointerTwo.next == pointerOne) {
				break;
			}
			pointerOne = pointerOne.next;
		}
		pointerTwo.next = null;
	}

	private Node findMiddleElementInLinkedList(Node head) {
		if (head == null) {
			System.out.println(" head is null !!!");
			return head;
		}
		Node slowPointer = head;
		Node fastPointer = head;

		while (slowPointer != null && fastPointer != null
				&& fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}

		return slowPointer;
	}

	private Node reverseLinkeList(Node head) {
		if (head == null) {
			System.out.println(" head is null !!!");
			return head;
		}
		Node prevNode = null;
		Node tempNode = null;
		Node currentNode = head;

		while (currentNode != null) {
			tempNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = tempNode;
		}
		return prevNode;
	}

	private void deleteNodeAtAnyPosition(Node addAtMiddle) {
		if (head == null) {
			System.out.println(" head is null !!!");
			return;
		}
		Node prevNode = null;
		Node currentNode = this.head;
		while (currentNode.next != null
				&& currentNode.data != addAtMiddle.data) {
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		prevNode.next = currentNode.next;
	}

	private void deleteNodeAtLast() {
		if (head == null) {
			System.out.println(" head is null !!!");
			return;
		}
		Node prevNode = null;
		Node currentNode = this.head;
		while (currentNode.next != null) {
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		prevNode.next = null;
	}

	private void deleteNodeAtFirst() {
		this.head = this.head.next;
	}

	private void addNodeAfterGivenNode(Node thirdNode, Node addAtMiddle) {
		if (null == thirdNode) {
			System.out.println(" Given Node is null !!");
			return;
		}
		addAtMiddle.next = thirdNode.next;
		thirdNode.next = addAtMiddle;
	}

	private void addNodeAtLast(Node addAtLast) {
		if (this.head == null) {
			this.head = addAtLast;
			return;
		}
		Node currentNode = this.head;
		while (null != currentNode.next) {
			currentNode = currentNode.next;
		}
		currentNode.next = addAtLast;
	}

	private void addNodeAtFirst(Node addAtFirst) {
		if (this.head == null) {
			this.head = addAtFirst;
			return;
		}
		addAtFirst.next = this.head;
		this.head = addAtFirst;
	}

}
