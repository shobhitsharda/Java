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

		//graph.printDepthFirstSearch();
		//System.out.println(graph.isCyclic());
		//graph.printGraph();
		//System.out.println("after apply transpose");
		//graph.getTranspose().printGraph();
		//graph.printAllTopologicalSort();

		//final DFS<Character> dfs = new DFS<>(graph);
		//dfs.traverseByStack('A');
		//System.out.println(dfs.searchNode('R'));

		//final BFS<Character> bfs = new BFS<>(graph);
		//bfs.traverseByQueue('A');
		//System.out.println(bfs.searchData('H'));
	}
}