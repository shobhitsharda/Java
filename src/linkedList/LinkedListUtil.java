package linkedList;

public class LinkedListUtil {

	public static boolean compareLists(final SinglyLinkedListNode head1, final SinglyLinkedListNode head2) {
		if (head1 == null && head2 == null) {
			return true;
		}

		if (head1 == null || head2 == null) {
			return false;
		}

		if (head1.data != head2.data) {
			return false;
		}

		return compareLists(head1.next, head2.next);
	}

	public static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		if (head1 == null && head2 == null) {
			return null;
		}

		if (head1 == null) {
			return head2;
		}

		if (head2 == null) {
			return head1;
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

}
