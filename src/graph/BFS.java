package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS<B> {
	private final Graph<B> graph;

	public BFS(final Graph<B> graph) {
		this.graph = graph;
	}

	public void bfsTraverseUsingQueue(final B nodeData) {
		final Node<B> node = graph.nodeMap.get(nodeData);
		final Set<Node<B>> visitedSet = new HashSet<>();
		final Queue<Node<B>> nodeQueue = new LinkedList<>();

		bfsTraverseUsingQueue(node, visitedSet, nodeQueue);

		graph.nodes.forEach(remainingNode -> {
			if (!visitedSet.contains(remainingNode)) {
				bfsTraverseUsingQueue(remainingNode, visitedSet, nodeQueue);
			}

		});
	}

	public void bfsTraverseUsingQueue(final Node<B> node, final Set<Node<B>> visitedSet, final Queue<Node<B>> nodeQueue) {
		visitedSet.add(node);
		nodeQueue.add(node);
		Node<B> currentNode;

		while(!nodeQueue.isEmpty()) {
			currentNode = nodeQueue.remove();
			System.out.println(currentNode.data);

			currentNode.neighbours.forEach(neighbourNode -> {
				if (!visitedSet.contains(neighbourNode)) {
					nodeQueue.add(neighbourNode);
					visitedSet.add(neighbourNode);
				}
			});
		}
	}

	public boolean searchNodeByBfs(final B nodeData) {
		final Set<Node<B>> visitedSet = new HashSet<>();
		final Queue<Node<B>> nodeQueue = new LinkedList<>();
		Node<B> currentNode;

		for (final Node<B> node : graph.nodes) {
			visitedSet.add(node);
			nodeQueue.add(node);

			while(!nodeQueue.isEmpty()) {
				currentNode = nodeQueue.remove();

				if (currentNode.data == nodeData) {
					return true;
				}

				currentNode.neighbours.forEach(neighbourNode -> {
					if (!visitedSet.contains(neighbourNode)) {
						visitedSet.add(neighbourNode);
						nodeQueue.add(neighbourNode);
					}
				});
			}
		}

		return false;
	}
}
