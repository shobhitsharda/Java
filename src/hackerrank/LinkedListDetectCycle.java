package hackerrank;

import java.util.HashSet;

public class LinkedListDetectCycle {

	/*
	 * https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem
	 */
	class Node {
		int data;
		Node next;
	}

	boolean hasCycle(final Node head) {
		final HashSet<Node> visitedSet = new HashSet<>();
		return hasCycleUtil(head, visitedSet);
	}

	boolean hasCycleUtil(final Node head, final HashSet<Node> visitedSet) {
		if (head == null) {
			return false;
		}

		if (visitedSet.contains(head)) {
			return true;
		}

		visitedSet.add(head);
		return hasCycleUtil(head.next, visitedSet);
	}
}
