package DCT.Graphs;

//https://www.geeksforgeeks.org/topological-sorting/
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphDfs {
	public class Graph {
		private int vertices; // vertices
		private LinkedList<Integer> adj[]; // array of lists for adj list rep

		Graph(int vertices) {
			this.vertices = vertices;
			adj = new LinkedList[vertices];
			for (int i = 0; i < vertices; i++) {
				adj[i] = new LinkedList<Integer>();
			}
		}

		void addEdge(int u, int v) {
			adj[u].add(v);
		}

		void TopologicalSortUtil(Stack<Integer> stack, boolean visited[], int v) {
			visited[v] = true;
			Iterator<Integer> it = adj[v].iterator();
			while(it.hasNext()) {
				int n = it.next();
				if (!visited[n]) {
					TopologicalSortUtil(stack, visited,n);
				}
			}
			stack.add(v); // you add it last after visiting and adding all child nodes

		}

		void TopologicalSort() {
			Stack<Integer> stack = new Stack<>();
			boolean visited[] = new boolean[this.vertices];
			for (int i = 0; i<vertices;i++) {
				if (!visited[i]) {
					TopologicalSortUtil(stack,visited,i);
				}
			}
			
			while(!stack.isEmpty()) {
				System.out.print(stack.pop()+" ");
			}
			System.out.println();
		}

		void DFSUtil(int v, boolean visited[]) {
			visited[v] = true;
			System.out.print(v + " ");
			Iterator<Integer> it = adj[v].iterator();
			while (it.hasNext()) {
				int n = it.next();
				if (!visited[n]) {
					DFSUtil(n, visited);
				}
			}
		}

		void DFS() {
			boolean visited[] = new boolean[this.vertices];
			for (int i = 0; i < vertices; i++) {
				if (!visited[i]) {
					DFSUtil(i, visited);
				}
			}

		}
	}

	public static void main(String args[]) {
		GraphDfs obj = new GraphDfs();
		Graph g = obj.new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		System.out.println("DFS Traversal:");
		g.DFS();
		System.out.println("Topological Traversal:");
		g.TopologicalSort();

	}

}
