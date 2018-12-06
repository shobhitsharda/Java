package linkedList;

import java.io.IOException;

public class DoublyLinkedList {
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

	public static void printDoublyLinkedList(DoublyLinkedListNode node) throws IOException {
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

	static DoublyLinkedListNode sortedInsert(final DoublyLinkedListNode head, final int data) {
		final DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

		if (head == null || head.data >= data) {
			newNode.next = head;
			newNode.prev = null;
			return newNode;
		}

		DoublyLinkedListNode currentNode = head;

		while (currentNode.next != null) {
			if (data < currentNode.data) {
				newNode.prev = currentNode.prev;
				newNode.next = currentNode;
				currentNode.prev.next = newNode;
				currentNode.prev = newNode;
				return head;
			}
			currentNode = currentNode.next;
		}

		if (currentNode.next == null) {
			newNode.prev = currentNode;
			currentNode.next = newNode;
		}

		return head;
	}

	public static void main(final String[] args) throws IOException {
		final DoublyLinkedList dlist = new DoublyLinkedList();
		dlist.insertNode(1);
		dlist.insertNode(2);
		dlist.insertNode(3);

		// printDoublyLinkedList(dlist.head);
		System.out.println("Inserted: ");

		printDoublyLinkedList(sortedInsert(dlist.head, 4));
	}
}