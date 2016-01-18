package dijkstra;

/**
 * Representation of a graph vertex
 */
public class Vertex implements Comparable<Vertex> {
	private final String label;		// label attached to this vertex
	public int cost;				// cost to get to this vertex 
	public Vertex prev;				// the previous vertex in the path 
	public boolean known;			// has this vertex been visited
	
	/**
	 * Construct a new vertex
	 * @param label the label attached to this vertex
	 */
	public Vertex(String label) {
		if(label == null)
			throw new IllegalArgumentException("null");
		this.label = label;
		this.cost = Integer.MAX_VALUE;
		this.prev = null;
		this.known = false;
	}

	/**
	 * Get a vertex label
	 * @return the label attached to this vertex
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * A string representation of this object
	 * @return the label attached to this vertex
	 */
	public String toString() {
		return label;
	}

	//auto-generated: hashes on label
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	//auto-generated: compares labels
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Vertex other = (Vertex) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	
	/**
	 * compares given vertex to another one
	 * @param other
	 * @return -1 if the cost of first vertex is less than that 
	 * 				of the second, 0 if they are equal, and 1 
	 * 				otherwise
	 */
	public int compareTo(Vertex other) {
		return this.cost < other.cost ? -1 :this.cost > other.cost ? 1 : 0;
	}
}
