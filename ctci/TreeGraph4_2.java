package ctci;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * See if there is a path between
 * two nodes in a directed graph.
 * @author Debosmit
 *
 */
public class TreeGraph4_2 {
	
	public static class Graph {
		private Node[] vertices;
		public int count;
		public final int MAX_NODES = 30;
		
		public Graph() {
			vertices = new Node[6];
			count = 0;
		}
		
		public void addNode(Node x) {
			if(count < MAX_NODES) 
				vertices[count++] = x;
			else 
				System.err.println("Graph is full");
		}
		
		public Node[] getNodes() {
			return vertices;
		}
	}
	
	public static class Node {
		private Node[] adjacentNodes;
		public int adjacentCount;
		private String vertex;
		public State state;
		
		public Node(String vertex, int adjacentLength) {
			this.vertex = vertex;
			this.adjacentCount = 0;
			adjacentNodes = new Node[adjacentLength];
			this.state = State.UNVISITED;
		}
		
		public void addAdjacentNode(Node x) {
			if(adjacentNodes.length >= adjacentCount+1)
				this.adjacentNodes[adjacentCount++] = x;
			else 
				System.err.println("Adjacent node array is full");
		}
		
		public Node[] getAdjacentNodes() {
	        return adjacentNodes;
	    }
		
	    public String getVertex() {
	        return vertex;
	    }
	    
	    public String toString() {
	    	return vertex + Arrays.toString(adjacentNodes) + "<" + state +">";
	    }
	}
	
	public static enum State {
		VISITED, UNVISITED, VISITING;
	}

	public void initializeGraph(Graph g) {
		Node[] temp = new Node[6];
		
		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);
		
		temp[0].addAdjacentNode(temp[1]);
		temp[0].addAdjacentNode(temp[2]);
		temp[0].addAdjacentNode(temp[3]);
		temp[3].addAdjacentNode(temp[4]);
		temp[4].addAdjacentNode(temp[5]);
		for (int i = 0; i < 6; i++) 
			g.addNode(temp[i]);
		
	}
	
	private boolean search(Graph g, Node start, Node end) {
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(start);
        Node u;
		while(!q.isEmpty()) {
			u = q.removeFirst();
			if(u != null) {
				for(Node v: u.getAdjacentNodes()) {
					if (v.state == State.UNVISITED) {
	                    if (v == end)
	                        return true;
	                    else {
	                        v.state = State.VISITING;
	                        q.add(v);
	                    }
	                }
				}
				u.state = State.VISITED;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		TreeGraph4_2 DirectedGraph = new TreeGraph4_2();
		Graph g = new Graph();
		DirectedGraph.initializeGraph(g);
		System.out.println("Initialized graph");
		
		Node[] n = g.getNodes();
		Node start = n[3];
		Node end = n[5];
		System.out.println("Path exists from " + start + " to " + end + "? " + 
							DirectedGraph.search(g, start, end));
	}
}
