package linkedList;

public class SinglyLinkedList {

	public void print(final SinglyLinkedListNode head) {
		if (head == null) {
			return;
		}

		System.out.println(head.data);

		print(head.next);
	}

	public SinglyLinkedListNode insertAtTail(final SinglyLinkedListNode head, final int nodeData) {
		final SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

		if (head == null) {
			return node;
		}

		SinglyLinkedListNode parentNode = head;

		while (parentNode.next != null) {
			parentNode = parentNode.next;
		}

		parentNode.next = node;

		return head;
	}

	public SinglyLinkedListNode insertAtHead(final SinglyLinkedListNode head, final int data) {
		final SinglyLinkedListNode node = new SinglyLinkedListNode(data);
		node.next = head;
		return node;
	}

	public SinglyLinkedListNode insertNodeAtPosition(final SinglyLinkedListNode head, final int data, final int position) {
		final SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);

		if (head == null) {
			return newNode;
		}
		else if (position == 0) {
			newNode.next = head;
			return newNode;
		}

		int count = 1;
		SinglyLinkedListNode currentNode = head;

		while (count < position && currentNode.next != null) {
			currentNode = currentNode.next;
			count++;
		}

		newNode.next = currentNode.next;
		currentNode.next = newNode;

		return head;
	}

	public SinglyLinkedListNode deleteNode(final SinglyLinkedListNode head, final int position) {
		if (head == null) {
			return null;
		}
		else if (position == 0) {
			return head.next;
		}

		int count = 1;
		SinglyLinkedListNode currentNode = head;

		while (count < position) {
			currentNode = currentNode.next;
			count++;

			if (currentNode == null) {
				return head;
			}
		}

		currentNode.next = currentNode.next.next;

		return head;
	}

	public void reversePrint(final SinglyLinkedListNode head) {
		if (head == null) {
			return;
		}

		reversePrint(head.next);
		System.out.println(head.data);
	}

	public SinglyLinkedListNode reverse(final SinglyLinkedListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		final SinglyLinkedListNode node = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return node;
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
}
