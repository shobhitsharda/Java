package graph;

public class GraphMain {

	public static void main(final String[] args) {
		final Graph<Character> graph = new Graph<>();
		graph.addEdge('A', 'B');
		graph.addEdge('A', 'D');
		graph.addEdge('B', 'E');
		graph.addEdge('D', 'E');
		//graph.addEdge('E', 'D');

		//graph.printDepthFirstSearch();
		//System.out.println(graph.isCyclic());
		graph.printGraph();
		System.out.println("after apply transpose");
		graph.getTranspose().printGraph();
	}
}