package com.dsa.book.hashing;

public class HashTableOperations {

	public static final int LOAD_FACTOR = 20;

	public static void main(String[] args) {

	}

	public static void hashInsert(HashTable h, int data) {

	}

	public static int hashSearch(HashTable h, int data) {
		ListNode temp;

		temp = h.table[Hash(data, h.tSize)].startNode;
		while (temp != null) {
			if (temp.data == data) {
				return 1;
			}
			temp = temp.next;
		}
		return 0;
	}

	private static int Hash(int data, int tSize) {
		return 0;
	}

	public static HashTable createHashTable(int size) {
		HashTable h = new HashTable();
		h.tSize = size / LOAD_FACTOR;
		h.count = 0;
		for (int i = 0; i < h.tSize; i++) {
			h.table[i].startNode = null;
		}
		return h;
	}

	static class HashTable {
		int tSize;
		int count;
		HashTableNode[] table;

		HashTable(int tSize) {
			this.tSize = tSize;
		}

		HashTable() {
		}
	}

	static class HashTableNode {
		int blockCount;
		ListNode startNode;

		public HashTableNode(int blockCount, ListNode startNode) {
			this.blockCount = blockCount;
			this.startNode = startNode;
		}
	}

	static class ListNode {

		int key;
		int data;
		ListNode next;

		ListNode(int key, int data, ListNode next) {
			this.key = key;
			this.data = data;
			this.next = next;
		}
	}

}
