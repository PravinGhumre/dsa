package com.dsa.book.binarytree;

public class BinarySearchTree {

	Node root;

	BinarySearchTree() {
		this.root = null;
	}

	BinarySearchTree(int key) {
		this.root = new Node(key);
	}

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

	void insertKey(int key) {
		this.root = insertNode(this.root, key);
	}

	Node insertNode(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.key) {
			root.left = insertNode(root.left, key);
		} else if (key > root.key) {
			root.right = insertNode(root.right, key);
		}
		return root;
	}

	Node searchNode(Node root, int key) {
		if (root == null || root.key == key) {
			return new Node(key);
		}

		if (key < root.key) {
			return searchNode(root.left, key);
		}
		return root.right = searchNode(root.right, key);

	}

	void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(" " + root.key + " ");
		inOrderTraversal(root.right);
	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.root = new Node(50);
		bst.insertKey(10);
		bst.insertKey(20);
		bst.insertKey(30);
		bst.insertKey(40);
		bst.insertKey(60);
		bst.insertKey(70);
		bst.insertKey(80);
		bst.insertKey(90);

		bst.inOrderTraversal(bst.root);
		System.out.println("");
		Node searchNode = bst.searchNode(bst.root, 10);
		System.out.println(" searchNode " + searchNode.key);

		// All Algorithms of BinaryTree

		Node lcaNode = leastCommonAncestorOfTwoNodes(bst.root, new Node(90),
				new Node(60));
		System.out.println(" lcaNode " + lcaNode.key);

		// Is BinarySearchTree
		boolean binarySearchTree = isBinarySearchTree(bst.root);
		System.out.println(" binarySearchTree " + binarySearchTree);
		boolean binarySearchTreeImproved = isBinarySearchTreeImproved(bst.root,
				Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(
				" binarySearchTreeImproved " + binarySearchTreeImproved);
		boolean binarySearchTreeRecursivly = isBinarySearchTreeRecursivly(
				bst.root);
		System.out.println(
				" binarySearchTreeRecursivly " + binarySearchTreeRecursivly);

		// Converting Sorted Array to BinarySearchTree
		int[] sortedArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int lastElement = sortedArray.length - 1;
		Node root = buildBSTfromSortedArray(sortedArray, 0, lastElement);
		boolean binarySearchTreeTest = isBinarySearchTree(root);
		System.out.println(" binarySearchTreeTest " + binarySearchTreeTest);

		// Finding Kth Smallest Element in BST
		Node kthSmallestInBST = kthSmallestInBST(bst.root, 4, 0);
		System.out.println(" kthSmallestInBST " + kthSmallestInBST.key);
	}

	private static Node kthSmallestInBST(Node root2, int k, int counter) {
		if (root2 == null) {
			return null;
		}
		Node left = kthSmallestInBST(root2.left, k, counter);
		if (left != null) {
			return left;
		}
		if (++counter == k) {
			return root2;
		}
		return kthSmallestInBST(root2.right, k, counter);
	}

	private static Node buildBSTfromSortedArray(int[] sortedArray, int left,
			int right) {
		Node newNode;
		if (left > right) {
			return null;
		}
		newNode = new Node(0);
		if (left == right) {
			newNode.key = sortedArray[left];
			newNode.left = null;
			newNode.right = null;
		} else {
			int mid = left + (right - left) / 2;
			newNode.key = sortedArray[mid];
			newNode.left = buildBSTfromSortedArray(sortedArray, left, mid - 1);
			newNode.right = buildBSTfromSortedArray(sortedArray, mid + 1,
					right);
		}
		return newNode;
	}

	private static boolean isBinarySearchTreeRecursivly(Node root2) {
		int prevValue = Integer.MIN_VALUE;
		return isBSTRecursivly(root2, prevValue);
	}

	private static boolean isBSTRecursivly(Node root2, int prevValue) {
		if (root2 == null) {
			return true;
		}
		if (!isBSTRecursivly(root2.left, prevValue)) {
			return false;
		}
		if (root2.key < prevValue) {
			return false;
		}
		prevValue = root2.key;
		return isBSTRecursivly(root2.right, prevValue);
	}

	private static boolean isBinarySearchTreeImproved(Node root2, int minValue,
			int maxValue) {
		if (root2 == null) {
			return true;
		}
		return (root2.key > minValue && root2.key < maxValue
				&& isBinarySearchTreeImproved(root2.left, minValue, root2.key)
				&& isBinarySearchTreeImproved(root2.right, root2.key,
						maxValue));
	}

	private static boolean isBinarySearchTree(Node rootNode) {
		if (rootNode == null) {
			return true;
		}
		if (rootNode.left != null
				&& (findMaxInBinaryTree(rootNode.left) > rootNode.key)) {
			return false;
		}
		if (rootNode.right != null
				&& (findMaxInBinaryTree(rootNode.right) < rootNode.key)) {
			return false;
		}
		if (!isBinarySearchTree(rootNode.left)
				|| !isBinarySearchTree(rootNode.right)) {
			return false;
		}
		return true;
	}

	private static int findMaxInBinaryTree(Node rootNode) {
		int maxValue = Integer.MIN_VALUE;
		if (rootNode != null) {
			int leftMax = findMaxInBinaryTree(rootNode.left);
			int rightMax = findMaxInBinaryTree(rootNode.right);

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

	private static Node leastCommonAncestorOfTwoNodes(Node rootNode, Node node1,
			Node node2) {
		if (rootNode == null) {
			return rootNode;
		}
		if (rootNode == node1 || rootNode == node2) {
			return rootNode;
		}
		if (Math.max(node1.key, node2.key) < rootNode.key) {
			return leastCommonAncestorOfTwoNodes(rootNode.left, node1, node2);
		} else if (Math.min(node1.key, node2.key) > rootNode.key) {
			return leastCommonAncestorOfTwoNodes(rootNode.right, node1, node2);
		} else
			return rootNode;
	}

}
