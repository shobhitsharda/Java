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

	public void traverseByQueue(final B nodeData) {
		final Node<B> node = graph.getNode(nodeData);

		if (node == null) {
			return;
		}

		final Queue<Node<B>> nodeQ = new LinkedList<>();
		final Set<Node<B>> visitedSet = new HashSet<>();

		traverseByQueue(node, nodeQ, visitedSet);

		graph.nodes.forEach(remainingNode -> {
			if (!visitedSet.contains(remainingNode)) {
				traverseByQueue(remainingNode, nodeQ, visitedSet);
			}
		});
	}

	public void traverseByQueue(final Node<B> node, final Queue<Node<B>> nodeQ, final Set<Node<B>> visitedSet) {
		nodeQ.add(node);
		visitedSet.add(node);

		while (!nodeQ.isEmpty()) {
			final Node<B> currentNode = nodeQ.poll();
			System.out.println(currentNode.data);

			currentNode.neighbours.forEach(neighbourNode -> {
				if (!visitedSet.contains(neighbourNode)) {
					nodeQ.add(neighbourNode);
					visitedSet.add(neighbourNode);
				}
			});
		}
	}

	//search data
	public boolean searchData(final B nodeData) {
		final Queue<Node<B>> nodeQ = new LinkedList<>();
		final Set<Node<B>> visitedSet = new HashSet<>();

		for (final Node<B> node : graph.nodes) {
			nodeQ.add(node);
			visitedSet.add(node);

			while (!nodeQ.isEmpty()) {
				final Node<B> currentNode = nodeQ.poll();

				if (currentNode.data == nodeData) {
					return true;
				}

				currentNode.neighbours.forEach(neighbourNode -> {
					if (!visitedSet.contains(neighbourNode)) {
						nodeQ.add(neighbourNode);
						visitedSet.add(neighbourNode);
					}
				});
			}
		}

		return false;
	}
}
