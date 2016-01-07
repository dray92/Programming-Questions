package dataStructures;

/**
* This exception signifies an invalid access on an empty heap.
*/
public class EmptyHeapException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyHeapException() 
	{}

	public EmptyHeapException(String message) {
		super(message);
	}
}
