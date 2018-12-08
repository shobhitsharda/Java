package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph<B> {
	ArrayList<Edge<B>> edges = new ArrayList<>();
	HashMap<B, Node<B>> nodeMap = new HashMap<>();
	ArrayList<Node<B>> nodes = new ArrayList<>();

	private void addNode(final B nodeData) {
		final Node<B> node = new Node<>(nodeData);
		nodes.add(node);
		nodeMap.put(nodeData, node);
	}

	public Node<B> getNode(final B nodeData) {
		return nodeMap.get(nodeData);
	}

	public void addEdge(final B startNodeData, final B endNodeData) {
		Node<B> startNode = nodeMap.get(startNodeData);
		Node<B> endNode = nodeMap.get(endNodeData);

		if (startNode == null) {
			addNode(startNodeData);
		}

		if (endNode == null) {
			addNode(endNodeData);
		}

		startNode = nodeMap.get(startNodeData);
		endNode = nodeMap.get(endNodeData);

		startNode.addNeighbour(endNode);

		final Edge<B> edge = new Edge<>(startNode, endNode);
		edges.add(edge);
	}

	public void printGraph() {
		edges.forEach(edge -> {
			System.out.println("Edge: " + edge.startNode.data + " -> " + edge.endNode.data);
		});
	}

	//DFS - start -
	public void printDepthFirstSearch() {
		final Set<Node<B>> visitedSet = new HashSet<>();
		final Queue<Node<B>> nodeQueue = new LinkedList<>();

		for (final Node<B> node : nodes) {
			if (!visitedSet.contains(node)) {
				printDepthFirstSearch(node, visitedSet, nodeQueue);
			}
		}

		while (!nodeQueue.isEmpty()) {
			System.out.println(nodeQueue.poll().data);
		}
	}

	private void printDepthFirstSearch(final Node<B> node, final Set<Node<B>> visitedSet, final Queue<Node<B>> nodeQueue) {
		visitedSet.add(node);
		nodeQueue.add(node);

		for (final Node<B> neighbourNode : node.neighbours) {
			if (!visitedSet.contains(neighbourNode)) {
				printDepthFirstSearch(neighbourNode, visitedSet, nodeQueue);
			}
		}
	}
	//DFS - end -

	//cyclic - start -
	public boolean isCyclic() {
		final Set<Node<B>> visitedSet = new HashSet<>();

		for (final Node<B> node : nodes) {
			if (isCyclic(node, visitedSet)) {
				return true;
			}
		}

		return false;
	}

	public boolean isCyclic(final Node<B> node, final Set<Node<B>> visitedSet) {
		if (visitedSet.contains(node)) {
			return true;
		}

		visitedSet.add(node);

		for (final Node<B> neighbourNode : node.neighbours) {
			if (isCyclic(neighbourNode, visitedSet)) {
				return true;
			}
		}

		visitedSet.remove(node);

		return false;
	}
	//cyclic - end -

	//transpose - start -
	public Graph<B> getTranspose() {
		final Graph<B> tGraph = new Graph<>();

		edges.forEach(edge -> {
			tGraph.addEdge(edge.endNode.data, edge.startNode.data);
		});

		return tGraph;
	}
	//transpose - end -

	//topological sort order - start -
	public void printAllTopologicalSort() {
		nodes.forEach(node -> {
			printTopologicalSort(node);
			System.out.println();
		});
	}

	public void printTopologicalSort(final Node<B> startNode) {
		final Set<Node<B>> visitedSet = new HashSet<>();
		final Stack<Node<B>> nodeStack = new Stack<>();

		topologicalSortUtil(startNode, visitedSet, nodeStack);

		nodes.forEach(node -> {
			if (!visitedSet.contains(node)) {
				topologicalSortUtil(node, visitedSet, nodeStack);
			}
		});

		System.out.print("start node " + startNode.data + " -> ");

		while (!nodeStack.isEmpty()) {
			System.out.print(nodeStack.pop().data + " ");
		}
	}

	private void topologicalSortUtil(final Node<B> node, final Set<Node<B>> visitedSet, final Stack<Node<B>> nodeStack) {
		visitedSet.add(node);

		node.neighbours.forEach(neighbourNode -> {
			if (!visitedSet.contains(neighbourNode)) {
				topologicalSortUtil(neighbourNode, visitedSet, nodeStack);
			}
		});

		nodeStack.push(node);
	}
}
