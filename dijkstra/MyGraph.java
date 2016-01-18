package dijkstra;

import java.util.*;

/**
 * A representation of a graph.
 * Assumes that we do not have negative cost edges in the graph.
 */
public class MyGraph implements Graph {
	private Collection<Vertex> myVertices;	// the vertices in this graph
	private Collection<Edge> myEdges;	// the edges in this graph

	/**
	 * Creates a MyGraph object with the given collection of vertices
	 * and the given collection of edges.
	 * @param v a collection of the vertices in this graph
	 * @param e a collection of the edges in this graph
	 */
	public MyGraph(Collection<Vertex> v, Collection<Edge> e) {

	    this.myVertices = v;
	    this.myEdges = e;
	}


    /** 
     * Return the collection of vertices of this graph
     * @return the vertices as a collection (which is anything iterable)
     */
    public Collection<Vertex> vertices() {
		return myVertices;
    }

    /** 
     * Return the collection of edges of this graph
     * @return the edges as a collection (which is anything iterable)
     */
    public Collection<Edge> edges() {
    	return myEdges;
    }

    /**
     * Return a collection of vertices adjacent to a given vertex v.
     *   i.e., the set of all vertices w where edges v -> w exist in the graph.
     * Return an empty collection if there are no adjacent vertices.
     * @param v one of the vertices in the graph
     * @return an iterable collection of vertices adjacent to v in the graph
     * @throws IllegalArgumentException if v does not exist.
     */
    public Collection<Vertex> adjacentVertices(Vertex v) {
    	if(!myVertices.contains(v))
    		throw new IllegalArgumentException("Vertex " + v + " is not a part of the "
    				+ "set of given vertices");
    	Set<Vertex> adjacent = new HashSet<Vertex>();
    	for(Edge e: myEdges) 
    		if(e.from.equals(v)) 
    			// instead of directly adding e.to
    			// to the list, we iterate over myVertices 
    			// till e.to is reached; that reference is then 
    			// added to the list
    			for(Vertex node: myVertices)
    				if(e.to.equals(node))
    					adjacent.add(node);
    		
		return adjacent;
    }

    /**
     * Test whether vertex b is adjacent to vertex a (i.e. a -> b) in a directed graph.
     * Assumes that we do not have negative cost edges in the graph.
     * @param a one vertex
     * @param b another vertex
     * @return cost of edge if there is a directed edge from a to b in the graph, 
     * return -1 otherwise.
     * @throws IllegalArgumentException if a or b do not exist.
     */
    public int isAdjacent(Vertex a, Vertex b) {
    	if(!myVertices.contains(a) || !myVertices.contains(b))
    		throw new IllegalArgumentException("One of the vertices is not a part of "
    				+ "the set of given vertices");
    	
    	for(Edge e: myEdges) 
    		if(e.from.equals(a) && e.to.equals(b))
    			return e.w;
    	
    	return -1;
    }

    /**
     * Returns the shortest path from a to b in the graph.  Assumes positive
     * edge weights.  Uses Dijkstra's algorithm.
     * @param a the starting vertex
     * @param b the destination vertex
     * @param path a list in which the path will be stored, in order, the first
     * being the start vertex and the last being the destination vertex.  The
     * list will be empty if no such path exists.  NOTE: the list will be
     * cleared of any previous data.  path is not expected to contain any data
     * needed by the method when the method is called.  It is used to allow
     * us to return multiple values from the function.
     * @return the length of the shortest path from a to b, -1 if no such path
     * exists.
     * @throws IllegalArgumentException if a or b does not exist.
     */
    public int shortestPath(Vertex a, Vertex b, List<Vertex> path) {
    	if(!myVertices.contains(a) || !myVertices.contains(b))
    		throw new IllegalArgumentException("One of the vertices is not a part of "
    				+ "the set of given vertices");
    	
    	PriorityQueue<Vertex> nodes = new PriorityQueue<Vertex>();
    	Set<Vertex> visited = new HashSet<Vertex>();
    	Collection<Vertex> vertices = vertices();
    	
    	// searching the set of vertices to set the 
    	// cost of the origin vertex to 0
    	// all other unvisited nodes set to INF
    	for(Vertex node: vertices) {
    		if(node.equals(a)) 
    			node.cost = 0;
    	}
    	
    	int sourceTargetCost = 0;
    		
    	// adding all nodes to the priority queue
    	for(Vertex node: vertices)
    		nodes.add(node);
    	
    	while(!nodes.isEmpty()) {
    		Vertex cur = nodes.poll();
    		
    		// mark node as visited
    		cur.known = true;
    		visited.add(cur);
    		
    		// if the target node has risen to the top
    		// of the priority queue, it's cost must have been determined
    		// no need to proceed to any more nodes
    		if(cur.equals(b)) {
    			sourceTargetCost = cur.cost;
    			break;
    		}
    		
    		Collection<Vertex> curAdjacent = adjacentVertices(cur);
    		boolean costChanged = false;
    		for(Vertex adj: curAdjacent) {
    			int pathCost = isAdjacent(cur, adj);
//    			// adj.cost needs to come from the present cost at that vertex,
//    			// from the priority queue, not from the cost of that vertex received
//    			// from isAdjacent().
//    			int curCost = 0;
//    			// getting cost of node from priority by removing elements till 
//    			// required element is reached; elements are then re-placed
//    			Stack<Vertex> stack = new Stack<Vertex>();
//    			while(!nodes.isEmpty()) {
//    				Vertex node = nodes.poll();
//    				stack.push(node);
//    				if(node.equals(adj)) {
//    					curCost = node.cost;
//    					break;
//    				}
//    			}
//    			while(!stack.isEmpty())
//    				nodes.add(stack.pop());
//    			if(cur.cost + pathCost < curCost) {
    			if(cur.cost + pathCost < adj.cost) {
    				adj.cost = cur.cost + pathCost;
    				adj.prev = cur;
    				costChanged = true;
    			}
    		}
    		
    		// if any of the costs changed, need to recreate priority queue
    		if(costChanged) {
    			Stack<Vertex> stack = new Stack<Vertex>();
    			while(!nodes.isEmpty()) 
    				stack.push(nodes.poll());
    			while(!stack.isEmpty()) 
    				nodes.add(stack.pop());
    			
    		}
    	}
    	
    	if(visited.contains(a) && visited.contains(b)) {
    		Vertex cur = null;
    		for(Vertex node: vertices)
    			if(node.equals(b))
    				cur = node;
    		
    		while(!cur.equals(a)) {
    			path.add(0,cur);
    			cur = cur.prev;
    		}
    		path.add(0,a);
    		return sourceTargetCost;
    	}
    	
    	return -1;
    }

}
