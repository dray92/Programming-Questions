package dataStructures;

/**
 * Base interface for priority queue implementations for doubles. 
 * Throw exceptions as appropriate. 
 * 
 * @author Debosmit
 */
public interface PriorityQueue<T> {
	/**
	 * Returns true if priority queue has no elements
	 *
	 * @return true if the priority queue has no elements
	 */
	public boolean isEmpty();


	/**
	 * Returns the number of elements in this priority queue.
	 *
	 * @return the number of elements in this priority queue.
	 */
	public int size();


	/**
	 * Returns the minimum element in the priority queue
	 *
	 * @return the minimum element or throw EmptyHeapException if empty
	 */
	public T findMin();


	/**
	 * Inserts a new element into the priority queue.
	 * Duplicate values ARE allowed.
	 *
	 * @param x element to be inserted into the priority queue.
	 */
	public void insert(T x);


	/**
	 * Removes and returns the minimum element from the priority queue.
	 *
	 * @return the minimum element or throw EmptyHeapException if empty
	 */
	public T deleteMin();


	/**
	 * Erases all elements from the priority queue.
	 */
	public void makeEmpty();

}
