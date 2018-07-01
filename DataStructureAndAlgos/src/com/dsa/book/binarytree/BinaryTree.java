package com.dsa.book.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	Node root;

	static class Node {

		int key;
		Node left;
		Node right;

		Node(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}

	BinaryTree() {
		this.root = null;
	}

	BinaryTree(int key) {
		this.root = new Node(key);
	}

	void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(" " + root.key + " ");
		inOrderTraversal(root.right);
	}

	void preOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(" " + root.key + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	void postOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(" " + root.key + " ");
	}

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();

		Node root = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);

		bt.root = root;
		bt.root.left = second;
		bt.root.right = third;
		second.left = four;
		second.right = five;
		third.left = six;
		third.right = seven;

		bt.inOrderTraversal(root);
		System.out.println("");
		bt.preOrderTraversal(root);
		System.out.println("");
		bt.postOrderTraversal(root);

		// BinaryTree Algorithms

		int maxValue = maxInBinaryTree(bt.root);
		System.out.println("\n MaxValue in Binary Tree " + maxValue);

		int maxValueOne = maxInBinaryTreeLevelOrder(bt.root);
		System.out.println("\n MaxValueOne in Binary Tree " + maxValueOne);

		boolean isFound6 = findInBinaryTree(bt.root, 6);
		System.out.println(" 6 Found " + isFound6);

		boolean isFound9 = findInBinaryTree(bt.root, 9);
		System.out.println(" 9 Found " + isFound9);

		int size = sizeOfBinaryTree(bt.root);
		System.out.println(" size " + size);

		int maxDepth = maxDepthOfBinaryTree(bt.root);
		System.out.println(" maxDepth " + maxDepth);

		int minDepth = minDepthOfBinaryTree(bt.root);
		System.out.println(" minDepth " + minDepth);

		int sum = sumOfBinaryTree(bt.root);
		System.out.println(" sum " + sum);

		mirrorOfBinaryTree(bt.root);
	}

	private static int sumOfBinaryTree(Node root2) {
		if (root2 == null) {
			return 0;
		} else {
			return (root2.key + sumOfBinaryTree(root2.left)
					+ sumOfBinaryTree(root2.right));
		}
	}

	private static int minDepthOfBinaryTree(Node root2) {
		if (root2 == null) {
			return 0;
		}
		if (root2.left == null && root2.right == null) {
			return 1;
		}
		if (root2.left == null) {
			return minDepthOfBinaryTree(root2.right) + 1;
		}
		if (root2.right == null) {
			return minDepthOfBinaryTree(root2.left) + 1;
		}
		return Math.min(minDepthOfBinaryTree(root2.left),
				minDepthOfBinaryTree(root2.right)) + 1;
	}

	private static Node mirrorOfBinaryTree(Node rootNode) {
		Node temp;
		if (rootNode != null) {
			mirrorOfBinaryTree(rootNode.left);
			mirrorOfBinaryTree(rootNode.right);

			temp = rootNode.left;
			rootNode.left = rootNode.right;
			rootNode.right = temp;
		}
		return rootNode;
	}

	private static int maxDepthOfBinaryTree(Node rootNode) {
		if (rootNode == null) {
			return 0;
		}
		int leftDepth = maxDepthOfBinaryTree(rootNode.left);
		int rightDepth = maxDepthOfBinaryTree(rootNode.right);
		return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
	}

	private static int sizeOfBinaryTree(Node rootNode) {
		int leftCount = rootNode.left == null
				? 0
				: sizeOfBinaryTree(rootNode.left);
		int rightCount = rootNode.right == null
				? 0
				: sizeOfBinaryTree(rootNode.right);
		return 1 + leftCount + rightCount;
	}

	private static boolean findInBinaryTree(Node rootNode, int value) {
		if (rootNode == null) {
			return false;
		}
		if (rootNode.key == value) {
			return true;
		}
		return findInBinaryTree(rootNode.left, value)
				|| findInBinaryTree(rootNode.right, value);
	}

	private static int maxInBinaryTreeLevelOrder(Node rootNode) {
		int maxValue = Integer.MIN_VALUE;
		if (rootNode == null) {
			return maxValue;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(rootNode);

		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			if (temp.key > maxValue) {
				maxValue = temp.key;
			}
			if (temp != null) {
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);

				}
			}
		}
		return maxValue;
	}

	private static int maxInBinaryTree(Node rootNode) {
		int maxValue = Integer.MIN_VALUE;
		if (rootNode != null) {
			int leftMax = maxInBinaryTree(rootNode.left);
			int rightMax = maxInBinaryTree(rootNode.right);

			if (leftMax > rightMax) {
				maxValue = leftMax;
			} else {
				maxValue = rightMax;
			}

			if (rootNode.key > maxValue) {
				maxValue = rootNode.key;
			}
		}
		return maxValue;
	}
}
