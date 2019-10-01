package DCT.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathDijkstra {

	int dist[];  
	int prev[];
	HashSet<Integer> settled;
	PriorityQueue<Node> pq;
	List<List<Node>> adj;
	int V;

	ShortestPathDijkstra(int V) {
		this.V = V;
		this.dist = new int[V];
		this.prev = new int[V];
		settled = new HashSet<>();
		pq = new PriorityQueue<Node>(V, new Node());
	}

	// function to iterate over every vertex
	public void Dijkstra(List<List<Node>> adj, int src) {
		// src to src = 0
		
		
		 for (int i = 0; i < V; i++) 
	            dist[i] = Integer.MAX_VALUE; 

		this.adj = adj;
		dist[src] = 0;
		prev[src] = Integer.MIN_VALUE;
		pq.add(new Node(src, 0));

		while (settled.size() != V) {
			// iterate neighbor
			int u = pq.poll().node;
			settled.add(u);
			visitNeighbors(u);
		}

	}

	// visit every neighbor and check if new dist < dist[neighbor]
	public void visitNeighbors(int u) {
		int edgeDist = -1;
		int newDist = -1;

		for (int i = 0; i < adj.get(u).size(); i++) {
			Node v = adj.get(u).get(i);
			edgeDist = v.cost;
			newDist = edgeDist + dist[u];

			if (dist[v.node] > newDist) {				
				dist[v.node] = newDist;
				prev[v.node] = u;
			}
//			optimization, break once you reach destination node
//			if (v.node==destination)
//				break;
			//add the current node to queue
			
			pq.add(new Node(v.node, newDist));
		}
	}

	// function to iterate over non vistied neghbour of v

	public static void main(String args[]) {
		int V = 5;
		List<List<Node>> adj = new ArrayList<List<Node>>();
		for (int i = 0; i < V; i++) {
			adj.add(i, new ArrayList<Node>());
		}
		ShortestPathDijkstra obj = new ShortestPathDijkstra(V);

		adj.get(0).add(obj.new Node(1, 9));
		adj.get(0).add(obj.new Node(2, 6));
		adj.get(0).add(obj.new Node(3, 5));
		adj.get(0).add(obj.new Node(4, 3));

		adj.get(2).add(obj.new Node(1, 2));
		adj.get(2).add(obj.new Node(3, 4));

		obj.Dijkstra(adj, 0);

		for (int i = 0; i < V; i++) {
			System.out.println("Distance from node " + 0 + "to node " + i + " is " + obj.dist[i]);
		}
		
		//path from src to dest 1
		int dest = 1;
		ArrayList<Integer> path = new ArrayList<>();
		for(int i = dest; i!=Integer.MIN_VALUE; i=obj.prev[i]) {
			path.add(i);
		}
		
		Collections.reverse(path);
		
		System.out.println("path from 0 to 1 is:" );
		
		Iterator pathIt = path.iterator();
		while(pathIt.hasNext()) {
			System.out.print(pathIt.next());
		}
	

	}

	// type of adj list element
	public class Node implements Comparator<Node> {
		int node;
		int cost;

		Node() {

		}

		Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}

		public int compare(Node node1, Node node2) {
			if (node1.cost < node2.cost)
				return -1;
			else if (node1.cost > node2.cost)
				return 1;
			return 0;
		}
	}
}

//dist-> maintain distance to every node from source
//priority queue-> key value pair of node index, distance to pull out the next minimum node with min dist for visiting.
//sijkatras algo processes next promising node in order, so if the destination node is already visited
//its shortest distance will not change as future nodes are visited.
//Lazy version keeps adding new keys value pair for same node because priority queue search key complexity is O(n)
//but insert is O(Log n), so we keep inserting duplicate key with new lesser distance.
//Eager approach uses a indeed priority queue where the key can be accessed in O(1) so keys can be modified
//and there is not duplicate extra data hanging around in the heap (PQ)

//new PriorityQueue<Node>(V, new Node());  -> V is initial capacity of priority queue, and new Node is the type of comparator and sicne 
//Node class implements comparator interface , its object can be supplied here.
