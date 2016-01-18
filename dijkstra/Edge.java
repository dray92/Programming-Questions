package dijkstra;

/**
 * Representation of a directed graph edge.
 */
public class Edge {
	public final Vertex from,to;
	public final int w;

	/**
	 * Construct a new edge
	 * @param from start vertex
	 * @param to end vertex
	 * @param w weight of this edge
	 */
	public Edge(Vertex from, Vertex to, int w) {
		if(from == null || to == null)
			throw new IllegalArgumentException("null");
		this.from = from;
		this.to = to;
		this.w = w;
	}

	/**
	 * A string representation of this object
	 * @return A string of the form <from, to, weight>
	 */
	public String toString() {
		return "<"+from+", "+to+", "+w+">";
	}

	//auto-generated: hashes on all fields
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		result = prime * result + w;
		return result;
	}

	//auto-generated: compares all fields
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Edge other = (Edge) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		if (w != other.w)
			return false;
		return true;
	}
}
