package ctci;

/**
 * Remove duplicates from unsorted list
 * Solve without temp buffer
 * @author Debosmit
 *
 */
public class LinkedList2_1 {
	
	public static class Node<T> {
		public T value;
		public Node<T> next;

		public Node() {
			this(null, null);
		}
		
		public Node(T value) {
			this(value, null);
		}
		
		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
		
		public String toString() {
			return "" + this.value;
		}
		
		// prints list starting at 'this'
		public String getList() {
			StringBuilder list = new StringBuilder();
			Node<T> cur = this;
			list.append(this.value);
			while(cur.next != null) {
				cur = cur.next;
				list.append(" -> " + cur.value);
			}
			return list.toString();
		}
	}
	
	public void removeDuplicates(Node<Integer> root) {
		// if root is null, or list contains only one node
		if(root == null || root.next == null)
			return;
		
		Node<Integer> cur = root, curNext, curNextNext;
		
		// compare root node to the one right after
		// stop when first two nodes don't contain 
		// the same value
		while(cur.next != null && cur.value == cur.next.value)
			cur.next = cur.next.next;
		
		// we are assured that root.next is either null
		// or it doesn't contain the same value as root
		// if next is null, we have nothing to do
		
		while(cur.next != null) {
			curNext = cur.next;
			curNextNext = curNext.next;
			while(curNextNext != null) {
				if(cur.value == curNextNext.value) {
					// remove curNextNext
					curNext.next = curNextNext.next;
					curNextNext = curNext.next;
				}
				else {
					curNext = curNextNext;
					curNextNext = curNext.next;
				}
			}
			cur = cur.next;
		}
	}
	
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(1);
		Node<Integer> node = root;
		for(int i = 1 ; i < 7 ; i++) {
			// when i = 4, set Node val to 1
			node.next = new Node<Integer>(i == 4 ? 1 : i);
			node = node.next;
		}
		node.next = new Node<Integer>(1);
		System.out.println("Before removal: " + root.getList());
		LinkedList2_1 Traverser = new LinkedList2_1();
		Traverser.removeDuplicates(root);
		System.out.println("After removal:  " + root.getList());
	}
	
}
