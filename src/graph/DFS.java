package graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS<B> {
	private final Graph<B> graph;

	public DFS(final Graph<B> graph) {
		this.graph = graph;
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
	public boolean searchNode(final B nodeData) {
		final Stack<Node<B>> nodeStack = new Stack<>();
		final Set<Node<B>> visitedSet = new HashSet<>();

		for (final Node<B> node : graph.nodes) {
			nodeStack.push(node);
			visitedSet.add(node);

			while (!nodeStack.isEmpty()) {
				final Node<B> currentNode = nodeStack.pop();

				if (currentNode.data == nodeData) {
					return true;
				}

				currentNode.neighbours.forEach(neighbourNode -> {
					if (!visitedSet.contains(neighbourNode)) {
						nodeStack.push(neighbourNode);
						visitedSet.add(neighbourNode);
					}
				});
			}
		}

		return false;
	}
}
