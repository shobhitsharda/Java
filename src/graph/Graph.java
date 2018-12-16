package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
	public void printTopologicalSort(final B nodeData) {
		final Set<Node<B>> visitedSet = new HashSet<>();
		final Stack<Node<B>> nodeStack = new Stack<>();
		final Node<B> node = nodeMap.get(nodeData);

		printTopologicalSort(node, visitedSet, nodeStack);

		nodes.forEach(remainingNode -> {
			if (!visitedSet.contains(remainingNode)) {
				printTopologicalSort(remainingNode, visitedSet, nodeStack);
			}
		});

		while(!nodeStack.isEmpty()) {
			System.out.println(nodeStack.pop().data);
		}
	}

	public void printTopologicalSort(final Node<B> node, final Set<Node<B>> visitedSet, final Stack<Node<B>> nodeStack) {
		visitedSet.add(node);

		node.neighbours.forEach(neighbourNode -> {
			if (!visitedSet.contains(neighbourNode)) {
				printTopologicalSort(neighbourNode, visitedSet, nodeStack);
			}
		});

		nodeStack.push(node);
	}

	public void searchPath(final B startNodeData, final B endNodeData) {
		final Node<B> startNode = nodeMap.get(startNodeData);
		final Node<B> endNode = nodeMap.get(endNodeData);

		final Set<Node<B>> visitedSet = new HashSet<>();
		final Stack<Node<B>> nodeStack = new Stack<>();

		if (isPathAvailable(startNode, endNode, visitedSet, nodeStack)) {
			while(!nodeStack.isEmpty()) {
				System.out.println(nodeStack.pop().data);
			}
		} else {
			System.out.println("Path not Found!");
		}
	}

	public boolean isPathAvailable(final Node<B> startNode, final Node<B> endNode, final Set<Node<B>> visitedSet, final Stack<Node<B>> nodeStack){
		visitedSet.add(startNode);
		nodeStack.push(startNode);

		if (startNode == endNode){
			return true;
		}

		for (final Node<B> neighbourNode : startNode.neighbours) {
			if (visitedSet.contains(neighbourNode)) {
				continue;
			}

			if (isPathAvailable(neighbourNode, endNode, visitedSet, nodeStack)) {
				return true;
			}
		}

		nodeStack.pop();
		return false;
	}

}
