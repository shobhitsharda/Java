package linkedList;

public class LinkedListMain {

	public static void main(final String[] args) {
		final SinglyLinkedList llist = new SinglyLinkedList();

		final SinglyLinkedListNode head = llist.insertAtTail(null, 1);
		llist.insertAtTail(head, 2);
		llist.insertAtTail(head, 3);

		//llist.insertNodeAtPosition(head, 4, 2);
		//llist.deleteNode(head, 3);
		//llist.reversePrint(head);
		//llist.print(head);

		//llist.insertAtTail(head, 4);
		//head = llist.reverse(head);

		//llist.print(head);

		final SinglyLinkedList llist2 = new SinglyLinkedList();
		final SinglyLinkedListNode head2 = llist2.insertAtTail(null, 1);
		llist2.insertAtTail(head2, 2);
		llist2.insertAtTail(head2, 3);

		//System.out.println(LinkedListUtil.compareLists(head, head2));

		final SinglyLinkedListNode newHead = LinkedListUtil.mergeLists(head, head2);
		llist.print(newHead);
	}

}
