package graph;

import java.util.HashSet;
import java.util.Set;

public class MyWeightedGraph implements WeightedGraph {
	
	private int V;
	private int E;
	private Set<Edge>[] adj;
	
	public MyWeightedGraph(int V) {
		if(V < 0)
			throw new IllegalArgumentException("Number of vertices "
					+ "must be non-negative");
		this.V = V;
		this.E = 0;
	    adj = (Set<Edge>[]) new Set[V];
	    for (int v = 0; v < V; v++)
	    	adj[v] = new HashSet<Edge>();
	}

	@Override
	public void insert(Edge e) {
		int v = e.v(), w = e.w();
		adj[v].add(e);
		adj[w].add(e);
	}

	@Override
	public Iterable<Edge> adj(int v) {
		return adj[v];
	}

	@Override
	public int V() {
		return V;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}
