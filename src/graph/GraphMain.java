package graph;

public class GraphMain {

	public static void main(final String[] args) {
		final Graph<Character> graph = new Graph<>();
		graph.addEdge('A', 'B');
		graph.addEdge('E', 'A');
		graph.addEdge('E', 'D');
		graph.addEdge('B', 'D');
		graph.addEdge('B', 'C');

		//graph.printDepthFirstSearch();
		//System.out.println(graph.isCyclic());
		//graph.printGraph();
		//System.out.println("after apply transpose");
		//graph.getTranspose().printGraph();

		graph.printAllTopologicalSort();
	}
}