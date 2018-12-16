package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class DFS<B> {
	private final Graph<B> graph;

	public DFS(final Graph<B> graph) {
		this.graph = graph;
	}

	public void dfsTraverseByRecurrsion(final B data) {
		final Node<B> node = graph.getNode(data);

		final Set<Node<B>> visitedSet = new HashSet<>();
		final Queue<Node<B>> nodeQueue = new LinkedList<>();

		dfsTraverseByRecurrsion(node, visitedSet, nodeQueue);

		graph.nodes.forEach(remainingNode -> {
			if (!visitedSet.contains(remainingNode)) {
				dfsTraverseByRecurrsion(remainingNode, visitedSet, nodeQueue);
			}
		});

		while(!nodeQueue.isEmpty()) {
			System.out.println(nodeQueue.remove().data);
		}
	}

	public void dfsTraverseByRecurrsion(final Node<B> node, final Set<Node<B>> visitedSet, final Queue<Node<B>> nodeQueue) {
		visitedSet.add(node);
		nodeQueue.add(node);

		node.neighbours.forEach(neighbourNode -> {
			if (!visitedSet.contains(neighbourNode)) {
				dfsTraverseByRecurrsion(neighbourNode, visitedSet, nodeQueue);
			}
		});
	}

	public void traverseByStack(final B nodeData) {
		final Node<B> node = graph.getNode(nodeData);

		if (node == null) {
			return;
		}

		final Stack<Node<B>> nodeStack = new Stack<>();
		final Set<Node<B>> visitedSet = new HashSet<>();

		traverseByStack(node, nodeStack, visitedSet);

		graph.nodes.forEach(remainingNode -> {
			if (!visitedSet.contains(remainingNode)) {
				traverseByStack(remainingNode, nodeStack, visitedSet);
			}
		});
	}

	public void traverseByStack(final Node<B> node, final Stack<Node<B>> nodeStack, final Set<Node<B>> visitedSet) {
		nodeStack.push(node);
		visitedSet.add(node);

		while (!nodeStack.isEmpty()) {
			final Node<B> currentNode = nodeStack.pop();
			System.out.println(currentNode.data);

			currentNode.neighbours.forEach(neighbourNode -> {
				if (!visitedSet.contains(neighbourNode)) {
					nodeStack.push(neighbourNode);
					visitedSet.add(neighbourNode);
				}
			});
		}
	}

	//node search
	public boolean searchNodeByDfs(final B nodeData) {
		final Set<Node<B>> visitedSet = new HashSet<>();
		final Stack<Node<B>> nodeStack = new Stack<>();
		Node<B> currentNode;

		for (final Node<B> node : graph.nodes) {
			visitedSet.add(node);
			nodeStack.push(node);

			while(!nodeStack.isEmpty()) {
				currentNode = nodeStack.pop();

				if (currentNode.data == nodeData) {
					return true;
				}

				currentNode.neighbours.forEach(neighbourNode-> {
					if (!visitedSet.contains(neighbourNode)) {
						visitedSet.add(neighbourNode);
						nodeStack.push(neighbourNode);
					}
				});
			}

		}

		return false;
	}
}
