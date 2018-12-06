package graph;

import java.util.ArrayList;

public class Node<B> {
	B data;
	ArrayList<Node<B>> neighbours;

	Node(final B data) {
		this.data = data;
		neighbours = new ArrayList<>();
	}

	public void addNeighbour(final Node<B> node) {
		neighbours.add(node);
	}
}
