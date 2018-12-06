package linkedList;

import java.io.IOException;

public class SinglyLinkedList {
	public SinglyLinkedListNode head;

	public SinglyLinkedList() {
		head = null;
	}

	public static void printLinkedList(SinglyLinkedListNode head) {
		if (head == null) {
			System.out.println("its null!");
		}

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

	public static SinglyLinkedListNode insertAtTail(final SinglyLinkedListNode head, final int data) {
		final SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

		if (head == null) {
			return newNode;
		}

		SinglyLinkedListNode node = head;

		while (node.next != null) {
			node = node.next;
		}

		node.next = newNode;

		return head;
	}

	public static SinglyLinkedListNode insertAtHead(final SinglyLinkedListNode llist, final int data) {
		final SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

		if (llist == null) {
			return newNode;
		}

		newNode.next = llist;
		return newNode;
	}

	static SinglyLinkedListNode insertNodeAtPosition(final SinglyLinkedListNode head, final int data, final int position) {
		if (head == null) {
			return head;
		}

		final SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

		if (position == 0) {
			newNode.next = head;
			return newNode;
		}

		SinglyLinkedListNode node = head;
		int count = 1;

		while (count < position) {
			node = node.next;
			count++;
		}

		newNode.next = node.next;
		node.next = newNode;

		return head;
	}

	static SinglyLinkedListNode deleteNode1(final SinglyLinkedListNode head, final int position) {
		if (head == null || head.next == null && position == 0) {
			return null;
		}

		SinglyLinkedListNode parentNode = head;
		SinglyLinkedListNode childNode = head.next;
		int count = 1;

		while (count < position) {
			parentNode = childNode;
			childNode = childNode.next;
			count++;
		}

		parentNode.next = childNode.next;

		return head;
	}

	static SinglyLinkedListNode deleteNode(final SinglyLinkedListNode head, final int position) {
		if (head == null) {
			return null;
		}

		if (position == 0) {
			return head.next;
		}

		SinglyLinkedListNode node = head;
		int count = 1;

		while (count < position) {
			node = node.next;
			count++;
		}

		node.next = node.next.next;

		return head;
	}

	static void reversePrint(final SinglyLinkedListNode head) {
		if (head == null) {
			return;
		}

		reversePrint(head.next);

		System.out.println(head.data);
	}

	static SinglyLinkedListNode reverse(final SinglyLinkedListNode head) {
		if (head.next == null || head == null) {
			return head;
		}

		final SinglyLinkedListNode remainingNode = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return remainingNode;
	}

	static boolean compareLists(final SinglyLinkedListNode head1, final SinglyLinkedListNode head2) {
		if (head1.next == null && head2.next == null) {
			return true;
		}

		if (head1.next == null || head2.next == null) {
			return false;
		}

		if (head1.data != head2.data) {
			return false;
		}

		return compareLists(head1.next, head2.next);
	}

	static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		if (head1 == null && head2 == null) {
			return null;
		}

		if (head2 == null) {
			return head1;
		}

		if (head1 == null) {
			return head2;
		}

		if (head1.data > head2.data) {
			final SinglyLinkedListNode tempNode = head2.next;
			head2.next = head1;
			head1 = head2;
			head2 = tempNode;
		}

		head1.next = mergeLists(head1.next, head2);
		return head1;
	}

	static int getNode(final SinglyLinkedListNode head, final int positionFromTail) {
		int count = 1;
		SinglyLinkedListNode currentNode = head;
		SinglyLinkedListNode resultNode = head;

		while (currentNode.next != null) {
			if (count > positionFromTail) {
				resultNode = resultNode.next;
			}

			count++;
			currentNode = currentNode.next;
		}

		return resultNode.data;
	}

	static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
		final SinglyLinkedListNode rootNode = head;

		while (head.next != null) {
			if (head.data == head.next.data) {
				head.next = head.next.next;
			}
			else {
				head = head.next;
			}
		}

		return rootNode;
	}

	// assumption - the lists will merge for sure
	static int findMergeNode(final SinglyLinkedListNode head1, final SinglyLinkedListNode head2) {
		SinglyLinkedListNode duplicateHead1 = head1;
		SinglyLinkedListNode duplicateHead2 = head2;

		while (duplicateHead1.next != null) {
			while (duplicateHead2.next != null) {
				if (duplicateHead1 == duplicateHead2) {
					return duplicateHead2.data;
				}
				else {
					duplicateHead2 = duplicateHead2.next;
				}
			}
			duplicateHead1 = duplicateHead1.next;
		}

		return duplicateHead1.data;
	}

	public static void main(final String[] args) throws IOException {
		final SinglyLinkedList llist = new SinglyLinkedList();

		for (int i = 5; i < 10; i++) {
			llist.head = insertAtTail(llist.head, i);
		}

		printLinkedList(llist.head);

		// System.out.println("inserting node at position 3");
		// insertNodeAtPosition(llist.head, 3, 3);
		// printLinkedList(llist.head);

		// System.out.println("Deleting node at position 3");
		// llist.head = deleteNode(llist.head, 3);
		// printLinkedList(llist.head);

		// System.out.println("Print Reveres Linked List");
		// reversePrint(llist.head);

		// System.out.println("Reversing the Linked List");
		// reverse(llist.head);

		// final SinglyLinkedList llist1 = new SinglyLinkedList();
		// final SinglyLinkedList llist2 = new SinglyLinkedList();
		//
		// llist1.head = insertAtTail(llist1.head, 4);
		// llist1.head = insertAtTail(llist1.head, 5);
		// llist1.head = insertAtTail(llist1.head, 6);
		//
		// llist2.head = insertAtTail(llist2.head, 1);
		// llist2.head = insertAtTail(llist2.head, 2);
		// llist2.head = insertAtTail(llist2.head, 10);

		// System.out.println("Printing llist1.head");
		// printLinkedList(llist1.head);
		//
		// System.out.println("Printing llist2.head");
		// printLinkedList(llist2.head);
		//
		// // llist3.head = mergeLists(llist1.head, llist2.head);
		// System.out.println("Printing mreged list");
		// printLinkedList(mergeLists(llist1.head, llist2.head));

		// System.out.println("Printing the element from reverse");
		// final int data = getNode(llist.head, 0);
		// System.out.println(data);

		// final SinglyLinkedList llist = new SinglyLinkedList();
		//
		// llist.head = insertAtTail(llist.head, 4);
		// llist.head = insertAtTail(llist.head, 4);
		// llist.head = insertAtTail(llist.head, 4);
		//
		// printLinkedList(removeDuplicates(llist.head));

		// final SinglyLinkedList llist1 = new SinglyLinkedList();
		// final SinglyLinkedList llist2 = new SinglyLinkedList();
		//
		// llist1.head = insertAtTail(llist1.head, 4);
		// llist1.head = insertAtTail(llist1.head, 5);
		// llist1.head = insertAtTail(llist1.head, 6);
		//
		// llist2.head = insertAtTail(llist2.head, 1);
		// llist2.head = insertAtTail(llist2.head, 4);
		// llist2.head = insertAtTail(llist2.head, 5);

	}
}