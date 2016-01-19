package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class MyWeightedGraph implements WeightedGraph {
	private static final String NEWLINE = System.getProperty("line.separator");
	
	private int V;
	private int E;
	private Set<Edge>[] adj;
	
	
	/**
     * Initializes an empty edge-weighted graph with V vertices and 0 edges.
     *
     * @param  V the number of vertices
     * @throws IllegalArgumentException if V < 0
     */
	@SuppressWarnings("unchecked")
	public MyWeightedGraph(int V) throws IllegalArgumentException {
		if(V < 0)
			throw new IllegalArgumentException("Number of vertices "
					+ "must be non-negative");
		
		this.V = V;
		this.E = 0;
	    
		adj = (Set<Edge>[]) new Set[V];
	    for (int v = 0; v < V; v++)
	    	adj[v] = new HashSet<Edge>();
	}
	
	
	/**
     * Initializes a random edge-weighted graph with V vertices and E edges.
     *
     * @param  V the number of vertices
     * @param  E the number of edges
     * @throws IllegalArgumentException if V < 0
     * @throws IllegalArgumentException if E < 0
     */
	public MyWeightedGraph(int V, int E) {
		this(V);
		
		if(E < 0)
			throw new IllegalArgumentException("Number of vertices "
					+ "must be non-negative");
		for (int i = 0; i < E; i++) {
            int v = StdRandom.uniform(V);
            int w = StdRandom.uniform(V);
            double weight = Math.round(100 * StdRandom.uniform()) / 100.0;
            Edge e = new Edge(v, w, weight);
            insert(e);
        }
	}
	
	
	/**  
     * Initializes an edge-weighted graph from an input stream.
     * The format is the number of vertices V,
     * followed by the number of edges E,
     * followed by E pairs of vertices and edge weights,
     * with each entry separated by whitespace.
     *
     * @param  in the input stream
     * @throws IndexOutOfBoundsException if the endpoints of any edge are not in prescribed range
     * @throws IllegalArgumentException if the number of vertices or edges is negative
     */
    public MyWeightedGraph(Scanner in) {
        this(in.nextInt());
        int E = in.nextInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            double weight = in.nextDouble();
            Edge e = new Edge(v, w, weight);
            insert(e);
        }
    }
    
    
    /**
     * Initializes a new edge-weighted graph that is a deep copy of G.
     *
     * @param  G the edge-weighted graph to copy
     */
    public MyWeightedGraph(MyWeightedGraph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Edge> reverse = new Stack<Edge>();
            for (Edge e : G.adj[v]) 
                reverse.push(e);
            
            for (Edge e : reverse) 
                adj[v].add(e);
            
        }
    }


	/**
     * Adds the undirected edge e to this edge-weighted graph.
     *
     * @param  e the edge
     * @throws IndexOutOfBoundsException unless both endpoints are between 0 and V-1
     */
    @Override
    public void insert(Edge e) {
        int v = e.either();
        int w = e.other(v);
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }
	
	
	/**
     * Returns the edges incident on vertex v.
     *
     * @param  v the vertex
     * @return the edges incident on vertex v as an Iterable
     * @throws IndexOutOfBoundsException unless 0 <= v < V
     */
	@Override
	public Iterable<Edge> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
	

	/**
     * Returns the number of vertices in this edge-weighted graph.
     *
     * @return the number of vertices in this edge-weighted graph
     */
	@Override
    public int V() {
        return V;
    }

	
    /**
     * Returns the number of edges in this edge-weighted graph.
     *
     * @return the number of edges in this edge-weighted graph
     */
	@Override
	public int E() {
        return E;
    }
	
	// throw an IndexOutOfBoundsException unless 0 <= v < V
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
    }
	
    
	/**
     * Returns a string representation of the edge-weighted graph.
     * This method takes time proportional to E + V.
     *
     * @return the number of vertices V, followed by the number of edges E,
     *         followed by the V adjacency lists of edges
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }


	@Override
	public List<Edge> edges() {
		// TODO Auto-generated method stub
		return null;
	}

}
