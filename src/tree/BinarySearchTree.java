package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
	private Node rootNode;

	public void addNode(final int data) {
		final Node node = new Node(data);
		addNode(node);
	}

	public void addNode(final Node node) {
		if (rootNode == null) {
			rootNode = node;
			return;
		}

		Node parentNode = rootNode;
		Node childNode = rootNode;

		while (childNode != null) {
			parentNode = childNode;

			if (node.data >= childNode.data) {
				childNode = childNode.right;
			}
			else {
				childNode = childNode.left;
			}
		}

		if (node.data >= parentNode.data) {
			parentNode.right = node;
		}
		else {
			parentNode.left = node;
		}
	}

	public void printTree() {
		System.out.print("Pre Order Traversal (V L R) :");
		preOrderTraversal(rootNode);

		System.out.println();

		System.out.print("In Order Traversal (L V R) :");
		inOrderTraversal(rootNode);

		System.out.println();

		System.out.print("Post Order Traversal (L R V) :");
		postOrderTraversal(rootNode);

		System.out.println();
	}

	// V L R
	private void preOrderTraversal(final Node rootNode) {
		if (rootNode == null) {
			return;
		}

		System.out.print(rootNode.data + " ");
		preOrderTraversal(rootNode.left);
		preOrderTraversal(rootNode.right);
	}

	// L V R
	private void inOrderTraversal(final Node rootNode) {
		if (rootNode == null) {
			return;
		}

		inOrderTraversal(rootNode.left);
		System.out.print(rootNode.data + " ");
		inOrderTraversal(rootNode.right);
	}

	// L R V
	private void postOrderTraversal(final Node rootNode) {
		if (rootNode == null) {
			return;
		}

		postOrderTraversal(rootNode.left);
		postOrderTraversal(rootNode.right);
		System.out.print(rootNode.data + " ");
	}

	// --------search node start ---------
	public boolean searchNode(final int data) {
		return searchNode(rootNode, data);
	}

	private boolean searchNode(final Node rootNode, final int data) {
		if (rootNode == null) {
			return false;
		}

		if (rootNode.data == data) {
			return true;
		}

		if (data > rootNode.data) {
			return searchNode(rootNode.right, data);
		}
		else {
			return searchNode(rootNode.left, data);
		}
	}
	// --------search node end ---------

	// ---------- top view start --------
	public void printTopView() {
		final ArrayList<Integer> nodeDataList = new ArrayList<>();

		getLeftChildren(rootNode.left, nodeDataList);
		nodeDataList.add(rootNode.data);
		getRightChildren(rootNode.right, nodeDataList);

		System.out.println("Printing Top View");

		nodeDataList.forEach(nodeData -> {
			System.out.print(nodeData + " ");
		});
	}

	private void getLeftChildren(final Node rootNode, final ArrayList<Integer> nodeDataList) {
		if (rootNode == null) {
			return;
		}

		getLeftChildren(rootNode.left, nodeDataList);
		nodeDataList.add(rootNode.data);
	}

	private void getRightChildren(final Node rootNode, final ArrayList<Integer> nodeDataList) {
		if (rootNode == null) {
			return;
		}

		nodeDataList.add(rootNode.data);
		getRightChildren(rootNode.right, nodeDataList);
	}

	// ---------- top view end --------

	// -----------size start -----------
	public int size() {
		return size(rootNode);
	}

	private int size(final Node rootNode) {
		if (rootNode == null) {
			return 0;
		}

		final int leftTreeSize = size(rootNode.left);
		final int rightTreeSize = size(rootNode.right);

		return leftTreeSize + rightTreeSize + 1;
	}
	// -----------size end -----------

	// ------------height start--------
	public int getHeight() {
		return getHeight(rootNode);
	}

	private int getHeight(final Node rootNode) {
		if (rootNode == null) {
			return 0;
		}

		final int leftHeight = getHeight(rootNode.left);
		final int rightHeigh = getHeight(rootNode.right);

		return 1 + (leftHeight > rightHeigh ? leftHeight : rightHeigh);
	}

	// ------------height end--------

	public void printLevelOrderTraversal() {
		printLevelOrderTraversal(rootNode);
	}

	private void printLevelOrderTraversal(final Node rootNode) {
		if (rootNode == null) {
			return;
		}

		final Queue<Node> qNodes = new LinkedList<>();
		qNodes.add(rootNode);

		while (!qNodes.isEmpty()) {
			final Node currentNode = qNodes.remove();
			System.out.print(currentNode.data + " ");
			final Node leftNode = currentNode.left;
			final Node rightNode = currentNode.right;

			if (leftNode != null) {
				qNodes.add(leftNode);
			}

			if (rightNode != null) {
				qNodes.add(rightNode);
			}
		}
	}

	public void printLevelOrderTraversalReverse() {
		printLevelOrderTraversalReverse(rootNode);
	}

	private void printLevelOrderTraversalReverse(final Node rootNode) {
		final Stack<Node> nodeStack = new Stack<>();
		final Queue<Node> qNodes = new LinkedList<>();
		qNodes.add(rootNode);

		while (!qNodes.isEmpty()) {
			final Node currentNode = qNodes.remove();
			nodeStack.add(currentNode);
			final Node leftChild = currentNode.left;
			final Node rightChild = currentNode.right;

			if (rightChild != null) {
				qNodes.add(rightChild);
			}

			if (leftChild != null) {
				qNodes.add(leftChild);
			}
		}

		while (!nodeStack.isEmpty()) {
			System.out.print(nodeStack.pop().data + " ");
		}
	}

	public void printLevelOrderTraversalInSpiralOrderTwoStack() {
		printLevelOrderTraversalInSpiralOrderTwoStack(rootNode);
	}

	private void printLevelOrderTraversalInSpiralOrderTwoStack(final Node rootNode) {
		final Stack<Node> nodeStack1 = new Stack<>();
		final Stack<Node> nodeStack2 = new Stack<>();
		final Queue<Node> qNodes = new LinkedList<>();

		nodeStack1.push(rootNode);

		while (true) {
			while (!nodeStack1.isEmpty()) {
				final Node currentNode = nodeStack1.pop();
				qNodes.add(currentNode);

				final Node leftChild = currentNode.left;
				final Node rightChild = currentNode.right;

				if (leftChild != null) {
					nodeStack2.push(leftChild);
				}

				if (rightChild != null) {
					nodeStack2.push(rightChild);
				}
			}

			while (!nodeStack2.isEmpty()) {
				final Node currentNode = nodeStack2.pop();
				qNodes.add(currentNode);

				final Node leftChild = currentNode.left;
				final Node rightChild = currentNode.right;

				if (rightChild != null) {
					nodeStack1.push(rightChild);
				}

				if (leftChild != null) {
					nodeStack1.push(leftChild);
				}
			}

			if (nodeStack1.isEmpty() && nodeStack2.isEmpty()) {
				break;
			}
		}

		while (!qNodes.isEmpty()) {
			System.out.print(qNodes.remove().data + " ");
		}
	}

	public void printLevelOrderTraversalInSpiralOrderDqueue() {
		printLevelOrderTraversalInSpiralOrderDqueue(rootNode);
	}

	private void printLevelOrderTraversalInSpiralOrderDqueue(final Node rootNode) {
		final Queue<Node> qNodes = new LinkedList<>();

		final Deque<Node> dqNodes = new LinkedList<>();
		dqNodes.offer(null);
		dqNodes.offerFirst(rootNode);

		while (dqNodes.size() > 1) {
			Node currentNode = dqNodes.peekFirst();

			while (currentNode != null) {
				currentNode = dqNodes.pollFirst();
				qNodes.offer(currentNode);

				if (currentNode.left != null) {
					dqNodes.offerLast(currentNode.left);
				}

				if (currentNode.right != null) {
					dqNodes.offerLast(currentNode.right);
				}

				currentNode = dqNodes.peekFirst();
			}

			currentNode = dqNodes.peekLast();

			while (currentNode != null) {
				currentNode = dqNodes.pollLast();
				qNodes.offer(currentNode);

				if (currentNode.right != null) {
					dqNodes.offerFirst(currentNode.right);
				}

				if (currentNode.left != null) {
					dqNodes.offerFirst(currentNode.left);
				}

				currentNode = dqNodes.peekLast();
			}
		}

		while (!qNodes.isEmpty()) {
			System.out.print(qNodes.poll().data + " ");
		}

	}

	// ----------sum start---------
	public int sum() {
		return sum(rootNode);
	}

	public int sum(final Node rootNode) {
		if (rootNode == null) {
			return 0;
		}

		return rootNode.data + sum(rootNode.left) + sum(rootNode.right);
	}
	// ---------sum end---------

	// ---------is binary search tree----------
	public boolean isTreeBinarySearchTree() {
		return isTreeBinarySearchTree(rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isTreeBinarySearchTree(final Node rootNode, final int min, final int max) {
		if (rootNode == null) {
			return true;
		}

		if (rootNode.data < min || rootNode.data > max) {
			return false;
		}

		return isTreeBinarySearchTree(rootNode.left, min, rootNode.data) && isTreeBinarySearchTree(rootNode.right, rootNode.data, max);
	}
	// ---------is binary search tree----------

	// iterative post order traversal
	public void printIterativePostOrderTraversal() {
		printIterativePostOrderTraversal(rootNode);
	}

	private void printIterativePostOrderTraversal(final Node rootNode) {
		final Stack<Node> nodeStack = new Stack<>();
		final Stack<Node> resultStack = new Stack<>();

		nodeStack.add(rootNode);

		while (!nodeStack.isEmpty()) {
			final Node currentNode = nodeStack.pop();
			resultStack.add(currentNode);
			final Node leftNode = currentNode.left;
			final Node rightNode = currentNode.right;

			if (leftNode != null) {
				nodeStack.add(leftNode);
			}

			if (rightNode != null) {
				nodeStack.add(rightNode);
			}
		}

		final int stackSize = resultStack.size();
		for (int i = 0; i < stackSize; i++) {
			System.out.print(resultStack.pop().data + " ");
		}
	}

	// iterative post order traversal

	// iterative pre order traversal
	public void printIterativePreorderTraversal() {
		printIterativePreorderTraversal(rootNode);
	}

	private void printIterativePreorderTraversal(final Node rootNode) {
		final Stack<Node> nodeStack = new Stack<>();
		final Queue<Node> qNodes = new LinkedList<>();

		nodeStack.add(rootNode);

		while (!nodeStack.isEmpty()) {
			final Node node = nodeStack.pop();
			qNodes.add(node);
			final Node leftNode = node.left;
			final Node rightNode = node.right;

			if (rightNode != null) {
				nodeStack.add(rightNode);
			}

			if (leftNode != null) {
				nodeStack.add(leftNode);
			}
		}

		while (!qNodes.isEmpty()) {
			System.out.print(qNodes.remove().data + " ");
		}
	}

	public void printIterativeInorderTraversal() {
		printIterativeInorderTraversal(rootNode);
	}

	public void printIterativeInorderTraversal(Node rootNode) {
		if (rootNode == null) {
			return;
		}

		final Stack<Node> nodeStack = new Stack<>();
		final Queue<Node> qNodes = new LinkedList<>();

		while (true) {
			if (rootNode != null) {
				nodeStack.push(rootNode);
				rootNode = rootNode.left;
			}
			else {
				if (nodeStack.isEmpty()) {
					break;
				}

				rootNode = nodeStack.pop();
				qNodes.add(rootNode);
				rootNode = rootNode.right;
			}
		}

		while (!qNodes.isEmpty()) {
			System.out.print(qNodes.remove().data + " ");
		}
	}

	public void lowestCommonAncestorInBst(final int data1, final int data2) {
		lowestCommonAncestorInBst(rootNode, data1, data2);
	}

	public Node lowestCommonAncestorInBst(final Node rootNode, final int data1, final int data2) {
		if (rootNode.data > data1 && rootNode.data > data2) {
			return lowestCommonAncestorInBst(rootNode.left, data1, data2);
		}
		else if (rootNode.data < data1 && rootNode.data < data2) {
			return lowestCommonAncestorInBst(rootNode.right, data1, data2);
		}
		else {
			return rootNode;
		}
	}

	public Node lowestCommonAncestorInBt(final Node rootNode, final int data1, final int data2) {
		if (rootNode == null) {
			return null;
		}

		if (rootNode.data == data1 || rootNode.data == data2) {
			return rootNode;
		}

		final Node left = lowestCommonAncestorInBt(rootNode.left, data1, data2);
		final Node right = lowestCommonAncestorInBt(rootNode.right, data1, data2);

		if (left != null && right != null) {
			return rootNode;
		}

		if (left == null && right == null) {
			return null;
		}

		return left != null ? left : right;
	}

	public void printIterativePostOrderTraversalBtOneStack() {
		final Queue<Node> qNodes = new LinkedList<>();
		final Stack<Node> nodeStack = new Stack<>();

		Node currentNode = rootNode;

		while (!nodeStack.isEmpty() || currentNode != null) {
			if (currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.left;
			}
			else {
				Node temp = nodeStack.peek().right;

				if (temp != null) {
					currentNode = temp;
				}
				else {
					temp = nodeStack.pop();
					qNodes.offer(temp);

					while (!nodeStack.isEmpty() && temp == nodeStack.peek().right) {
						temp = nodeStack.pop();
						qNodes.offer(temp);
					}
				}
			}
		}

		while (!qNodes.isEmpty()) {
			System.out.print(qNodes.remove().data + " ");
		}

	}
}
