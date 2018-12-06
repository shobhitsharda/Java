package graph;

public class Edge<B> {
	Node<B> startNode;
	Node<B> endNode;
	int weight;

	Edge(final Node<B> startNodeData, final Node<B> endNodeData) {
		this(startNodeData, endNodeData, 0);
	}

	Edge(final Node<B> startNode, final Node<B> endNode, final int weight) {
		this.startNode = startNode;
		this.endNode = endNode;
		this.weight = weight;
	}
}
