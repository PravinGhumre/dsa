package com.dsa.book.binarytree;

public class BinarySearchTree {

	TreeNode root;

	BinarySearchTree() {
		this.root = null;
	}

	BinarySearchTree(int key) {
		this.root = new TreeNode(key);
	}

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

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.root = new TreeNode(50);
		bst.insertKey(10);
		bst.insertKey(20);
		bst.insertKey(30);
		bst.insertKey(40);
		bst.insertKey(60);
		bst.insertKey(70);
		bst.insertKey(80);
		bst.insertKey(90);

		// All Algorithms of BinaryTree

		bst.inOrderTraversal(bst.root);
		System.out.println("");

		bst.preOrderTraversal(bst.root);
		System.out.println("");

		bst.postOrderTraversal(bst.root);
		System.out.println("");

		TreeNode searchNode = bst.searchNode(bst.root, 10);
		System.out.println(" searchNode " + searchNode.key);

		TreeNode lcaNode = leastCommonAncestorOfTwoNodes(bst.root,
				new TreeNode(90), new TreeNode(60));
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
		TreeNode root = buildBSTfromSortedArray(sortedArray, 0, lastElement);
		boolean binarySearchTreeTest = isBinarySearchTree(root);
		System.out.println(" binarySearchTreeTest " + binarySearchTreeTest);

		// Finding Kth Smallest Element in BST
		TreeNode kthSmallestInBST = kthSmallestInBST(bst.root, 4, 0);
		System.out.println(" kthSmallestInBST " + kthSmallestInBST.key);

		TreeNode minimumElement = minimumElement(bst.root);
		System.out.println(" minimumElement " + minimumElement.key);
	}

	void insertKey(int key) {
		this.root = insertNode(this.root, key);
	}

	TreeNode insertNode(TreeNode root, int key) {
		if (root == null) {
			root = new TreeNode(key);
			return root;
		}

		if (key < root.key) {
			root.left = insertNode(root.left, key);
		} else if (key > root.key) {
			root.right = insertNode(root.right, key);
		}
		return root;
	}

	TreeNode searchNode(TreeNode root, int key) {
		if (root == null || root.key == key) {
			return new TreeNode(key);
		}

		if (key < root.key) {
			return searchNode(root.left, key);
		}
		return root.right = searchNode(root.right, key);

	}

	void inOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(" " + root.key + " ");
		inOrderTraversal(root.right);
	}

	private void postOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(" " + root.key + " ");
	}

	private void preOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(" " + root.key + " ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	private static TreeNode minimumElement(TreeNode root) {
		if (root.left == null) {
			return root;
		} else {
			return minimumElement(root.left);
		}

	}

	private static TreeNode kthSmallestInBST(TreeNode root2, int k,
			int counter) {
		if (root2 == null) {
			return null;
		}
		TreeNode left = kthSmallestInBST(root2.left, k, counter);
		if (left != null) {
			return left;
		}
		if (++counter == k) {
			return root2;
		}
		return kthSmallestInBST(root2.right, k, counter);
	}

	private static TreeNode buildBSTfromSortedArray(int[] sortedArray, int left,
			int right) {
		TreeNode newNode;
		if (left > right) {
			return null;
		}
		newNode = new TreeNode(0);
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

	private static boolean isBinarySearchTreeRecursivly(TreeNode root2) {
		int prevValue = Integer.MIN_VALUE;
		return isBSTRecursivly(root2, prevValue);
	}

	private static boolean isBSTRecursivly(TreeNode root2, int prevValue) {
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

	private static boolean isBinarySearchTreeImproved(TreeNode root2,
			int minValue, int maxValue) {
		if (root2 == null) {
			return true;
		}
		return (root2.key > minValue && root2.key < maxValue
				&& isBinarySearchTreeImproved(root2.left, minValue, root2.key)
				&& isBinarySearchTreeImproved(root2.right, root2.key,
						maxValue));
	}

	private static boolean isBinarySearchTree(TreeNode rootNode) {
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

	private static int findMaxInBinaryTree(TreeNode rootNode) {
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

	private static TreeNode leastCommonAncestorOfTwoNodes(TreeNode rootNode,
			TreeNode node1, TreeNode node2) {
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
