package com.dsa.book.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	TreeNode root;

	static class TreeNode {

		int key;
		TreeNode left;
		TreeNode right;

		TreeNode(int key) {
			this.key = key;
			this.left = null;
			this.right = null;
		}
	}

	BinaryTree() {
		this.root = null;
	}

	BinaryTree(int key) {
		this.root = new TreeNode(key);
	}

	void inOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(" " + root.key + " ");
		inOrderTraversal(root.right);
	}

	void preOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(" " + root.key + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	void postOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(" " + root.key + " ");
	}

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();

		TreeNode root = new TreeNode(1);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);

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

		// Max In Binary Tree
		// Max In Binary Tree Traversal Order
		// Find In Binary Tree
		// Size Of Binary Tree
		// Max Depth Of Binary Tree
		// Min Depth Of Binary Tree
		// Print Leaf Nodes
		// LCA of Binary Tree
		// Mirror Of Binary Tree
		// Level Order Traversal
		// Pre Order Traversal
		// Post Order Traversal
		// Spiral Order Traversal
		// Boundary Traversal
		// Print All Paths Of Binary Tree
		// Print Vertical Sum Of Binay Tree
		// Get Level Of Node In Binary Tree
	}

	private static int sumOfBinaryTree(TreeNode root2) {
		if (root2 == null) {
			return 0;
		} else {
			return (root2.key + sumOfBinaryTree(root2.left)
					+ sumOfBinaryTree(root2.right));
		}
	}

	private static int minDepthOfBinaryTree(TreeNode root2) {
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

	private static TreeNode mirrorOfBinaryTree(TreeNode rootNode) {
		TreeNode temp;
		if (rootNode != null) {
			mirrorOfBinaryTree(rootNode.left);
			mirrorOfBinaryTree(rootNode.right);

			temp = rootNode.left;
			rootNode.left = rootNode.right;
			rootNode.right = temp;
		}
		return rootNode;
	}

	private static int maxDepthOfBinaryTree(TreeNode rootNode) {
		if (rootNode == null) {
			return 0;
		}
		int leftDepth = maxDepthOfBinaryTree(rootNode.left);
		int rightDepth = maxDepthOfBinaryTree(rootNode.right);
		return (leftDepth > rightDepth) ? leftDepth + 1 : rightDepth + 1;
	}

	private static int sizeOfBinaryTree(TreeNode rootNode) {
		int leftCount = rootNode.left == null
				? 0
				: sizeOfBinaryTree(rootNode.left);
		int rightCount = rootNode.right == null
				? 0
				: sizeOfBinaryTree(rootNode.right);
		return 1 + leftCount + rightCount;
	}

	private static boolean findInBinaryTree(TreeNode rootNode, int value) {
		if (rootNode == null) {
			return false;
		}
		if (rootNode.key == value) {
			return true;
		}
		return findInBinaryTree(rootNode.left, value)
				|| findInBinaryTree(rootNode.right, value);
	}

	private static int maxInBinaryTreeLevelOrder(TreeNode rootNode) {
		int maxValue = Integer.MIN_VALUE;
		if (rootNode == null) {
			return maxValue;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(rootNode);

		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
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

	private static int maxInBinaryTree(TreeNode rootNode) {
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
