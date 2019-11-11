package hackerrunInterview;

import java.io.BufferedWriter;
import java.io.IOException;

public class ReverseDoublyLinkedList {

	static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
		DoublyLinkedListNode temp = null;
		DoublyLinkedListNode current = head;

		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}

		if (temp != null) {
			head = temp.prev;
		}

		return head;
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
}
