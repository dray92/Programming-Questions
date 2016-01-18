package graph;

import java.util.Comparator;

public class Edge implements Comparable<Edge> {

	private final int v;
	private final int w;
	private final double weight;
	
	public final static Comparator<Edge> BY_WEIGHT = new ByWeightComparator();
	
	/**
	 * Public contsructor
	 * 
	 * @param v element containing one vertex
	 * 
	 * @param w element containing the other vertex
	 * 
	 * @param weight element containing weight of edge
	 */
	public Edge(int v, int w, int weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	
	/**
	 * Slightly tricky accessor methods
	 * @return
	 */
	public int either() {  
		return v; 
	}

	
	/**
	 * Slightly tricky accessor methods
	 * (enables client code like this)
	 * 
	 *	for (int v = 0; v < G.V(); v++) {
	 * 	   for(Edge e : G.adj(v)) {
	 *	      int w = e.other(v);
	 *	      
	 *	      // edge v-w
	 *	   }
	 *	}
	 *
	 * @return
	 */
	public int other(int vertex) {
		if (vertex == v) 
			return w;
		return v; 
	}
	
	
	/**
	 * 
	 * @return one vertex
	 */
	public int v() {
		return v;
	}
	
	
	/**
	 * 
	 * @return other vertex
	 */
	public int w() {
		return w;
	}
	
	
	/**
	 * 
	 * @return edge weight
	 */
	public double weight() {  
		return weight; 
	}
	
	
	/**
	 * So that edges are Comparable, for use in Set
	 */
	@Override
	public int compareTo(Edge that) {
		if(this.weight < that.weight) 
			return -1;
	    else if (this.weight > that.weight) 
	    	return +1;
	    return  0;
	}
	
	private static class ByWeightComparator implements Comparator<Edge> {
		
		/**
		 * So that clients can compare edges by weight
		 * 
		 */
		public int compare(Edge e, Edge f) {
			if (e.weight < f.weight) 
				return -1;
			if (e.weight > f.weight) 
				return +1;
			return 0;
	   }
	}  
}

