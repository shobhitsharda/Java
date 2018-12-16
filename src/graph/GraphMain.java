package graph;

public class GraphMain {

	public static void main(final String[] args) {
		final Graph<Character> graph = new Graph<>();
		graph.addEdge('A', 'C');
		graph.addEdge('B', 'C');
		graph.addEdge('C', 'E');
		graph.addEdge('B', 'D');
		graph.addEdge('E', 'F');
		graph.addEdge('D', 'F');
		graph.addEdge('F', 'G');

		//System.out.println(graph.isCyclic());
		//graph.printGraph();
		//System.out.println("after apply transpose");
		//graph.getTranspose().printGraph();
		//graph.printTopologicalSort('C');
		graph.searchPath('B', 'F');

		//final DFS<Character> dfs = new DFS<>(graph);
		//dfs.dfsTraverseByRecurrsion('B');
		//dfs.traverseByStack('B');
		//System.out.println(dfs.searchNodeByDfs('F'));

		//final BFS<Character> bfs = new BFS<>(graph);
		//bfs.traverseByQueue('B');
		//bfs.bfsTraverseUsingQueue('B');
		//System.out.println(bfs.searchNodeByBfs('F'));
	}
}