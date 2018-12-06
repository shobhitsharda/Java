package hackerrank;

import java.io.BufferedWriter;
import java.io.IOException;

public class InsertNodeDoublyLinkedList {

	/*
	 * https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem
	 */
	static class DoublyLinkedListNode {
		public int data;
		public DoublyLinkedListNode next;
		public DoublyLinkedListNode prev;

		public DoublyLinkedListNode(final int nodeData) {
			data = nodeData;
			next = null;
			prev = null;
		}
	}

	static class DoublyLinkedList {
		public DoublyLinkedListNode head;
		public DoublyLinkedListNode tail;

		public DoublyLinkedList() {
			head = null;
			tail = null;
		}

		public void insertNode(final int nodeData) {
			final DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

			if (head == null) {
				head = node;
			}
			else {
				tail.next = node;
				node.prev = tail;
			}

			tail = node;
		}
	}

	public static void printDoublyLinkedList(DoublyLinkedListNode node, final String sep, final BufferedWriter bufferedWriter) throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	// Complete the sortedInsert function below.

	/*
	 * For your reference:
	 *
	 * DoublyLinkedListNode {
	 *     int data;
	 *     DoublyLinkedListNode next;
	 *     DoublyLinkedListNode prev;
	 * }
	 *
	 */
	static DoublyLinkedListNode sortedInsert(final DoublyLinkedListNode head, final int data) {
		final DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

		if (head == null) {
			return newNode;
		}

		if (head.data >= data) {
			newNode.next = head;
			newNode.prev = null;
			return newNode;
		}

		DoublyLinkedListNode currentNode = head;
		DoublyLinkedListNode tempNode = null;

		while (currentNode != null && currentNode.next != null) {
			if (data > currentNode.data && data <= currentNode.next.data) {
				tempNode = currentNode.next;
				newNode.next = tempNode;
				newNode.prev = currentNode;
				currentNode.next = newNode;
				tempNode.prev = newNode;
				return head;
			}

			currentNode = currentNode.next;
		}

		currentNode.next = newNode;
		newNode.prev = currentNode;
		newNode.next = null;

		return head;
	}
}
