package DCT.Graphs;

import java.util.LinkedList;

//also used to check if all tasks/courses can be take when pre reqs
public class DetectCycleDirectedGraph {
	public class Graph {
		int vertices;
		LinkedList<Integer> adj[];

		Graph(int vertices) {
			this.vertices = vertices;
			adj = new LinkedList[vertices];
			for (int i = 0; i < vertices; i++) {
				adj[i] = new LinkedList<Integer>();
			}
		}

		public void addEdge(int u, int v) {
			adj[u].add(v);
		}

		public boolean isCyclicUtil(int v, boolean visited[], boolean recStack[]) {
			if (recStack[v])
				return true;
			
			if (visited[v]) {
				System.out.println("hi");
				return false;
			}
			
			visited[v]=recStack[v] = true;
			
			for(Integer child:adj[v]) {
				if (isCyclicUtil(child,visited,recStack))
					return true;
			}
			recStack[v] = false;
			return false;
		}

		public boolean isCyclic() {
			boolean visited[] = new boolean[vertices];
			boolean recStack[] = new boolean[vertices];

			for (int i = 0; i < vertices; i++) {
				if (isCyclicUtil(i, visited,recStack))
					return true;
			}
			return false;
		}

	}

	public static void main(String args[]) {
		DetectCycleDirectedGraph obj = new DetectCycleDirectedGraph();
		Graph g = obj.new Graph(4);
//		g.addEdge(1, 0);
//		g.addEdge(0, 1);
//		g.addEdge(1, 2);
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
		System.out.println("has cycle (task canot be done):" + g.isCyclic());

	}
}
