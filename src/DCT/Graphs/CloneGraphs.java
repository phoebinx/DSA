package DCT.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

//The idea is to do a BFS traversal of the graph and while visiting a node make a clone node of
//it (a copy of orginal node) , if a node is encountered that is already visited then it already
//has a clone.
//geeksforgeeks.org/clone-an-undirected-graph/

public class CloneGraphs {
	public class GraphNode {
		int val;
		ArrayList<GraphNode> neighbors;

		GraphNode(int val) {
			this.val = val;
			this.neighbors = new ArrayList<GraphNode>();
		}
	}

	public class Graph {

		public GraphNode cloneGraph(GraphNode source) {
			Queue<GraphNode> q = new LinkedList<>();
			Hashtable<GraphNode, GraphNode> cloneTable = new Hashtable<>();
			cloneTable.put(source, new GraphNode(source.val));
			q.add(source);
			while (!q.isEmpty()) {
				GraphNode original = q.poll();
				GraphNode clone = cloneTable.get(original);
				if (original.neighbors != null) {
					for (GraphNode oN : original.neighbors) {
						if (!cloneTable.containsKey(oN)) {
							GraphNode cN = new GraphNode(oN.val);
							clone.neighbors.add(cN);
							cloneTable.put(oN, cN);
							q.add(oN);
						} else {
							clone.neighbors.add(cloneTable.get(oN));
						}
					}
				}
			}
			return cloneTable.get(source);
		}

		public GraphNode buildGraph() {
			/*
			 * Note : All the edges are Undirected Given Graph: 1--2 | | 4--3
			 */

			GraphNode node1 = new GraphNode(1);
			GraphNode node2 = new GraphNode(2);
			GraphNode node3 = new GraphNode(3);
			GraphNode node4 = new GraphNode(4);

			ArrayList<GraphNode> v = new ArrayList<>();
			v.add(node2);
			v.add(node4);
			node1.neighbors = v;

			v = new ArrayList<>();
			v.add(node1);
			v.add(node3);
			node2.neighbors = v;

			v = new ArrayList<>();
			v.add(node2);
			v.add(node4);
			node3.neighbors = v;

			v = new ArrayList<>();
			v.add(node1);
			v.add(node3);
			node4.neighbors = v;

			return node1;
		}

		public void bfs(GraphNode source) {
			Queue<GraphNode> q = new LinkedList<GraphNode>();
			q.add(source);
			HashSet<GraphNode> visited = new HashSet<>();
			visited.add(source);
			while (!q.isEmpty()) {
				GraphNode temp = q.poll();

				System.out.println("Value of Node: " + temp.val);
				System.out.println("Address of Node: " + temp);

				ArrayList<GraphNode> neighbors = temp.neighbors;
				for (GraphNode tempN : neighbors) {
					if (!visited.contains(tempN)) {
						q.add(tempN);
						visited.add(tempN);
					}
				}
			}
			System.out.println();
		}

	}

	public static void main(String args[]) {
		CloneGraphs obj = new CloneGraphs();
		Graph graph = obj.new Graph();
		GraphNode source = graph.buildGraph();
//		System.out.println("BFS traversal of graph before cloning:");
		graph.bfs(source);
		GraphNode newSource = graph.cloneGraph(source);
		System.out.println("BFS traversal of graph before cloning:");
		graph.bfs(newSource);

	}
}
