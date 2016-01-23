package ctci;

import ctci.LinkedList2_1.Node;

/**
 * Find the kth to last element of a singly linked list
 * @author Debosmit
 *
 */
public class LinkedList2_2 {
	
	public Node<Integer> removeKthFromEnd(Node<Integer> root, int k) {
		// if root is null, or 0th node from end
		// is to be removed
		if(root == null || k == 0)
			return root;
		
		int kTemp = k;
		// fast pointer that will be k+1 steps ahead of the slow ptr
		Node<Integer> cur = root;
		try {
			while(k>=0) {
				cur = cur.next;
				k--;
			}
		} catch(Exception e) {
			// fast pointer has reached null
			// either head has to be removed,
			// or value to remove is greater than
			// the size of the list
			if(k == 0) {
				// need to remove head
				return root.next;
			}
			throw new IllegalArgumentException("There are "
					+ "less that " + kTemp + " elements in the list");
		}
		
		// fast pointer is at k+1
		// slow pointer is at 0
		// say, after n steps, fast is at k+1+n
		// slow is at n
		// this means that we have to remove the element at n+1
		// [k+1+n] = [n+1] = k, i.e., the element we have to remove
		Node<Integer> slowPtr = root;
		while(cur != null) {
			slowPtr = slowPtr.next;
			cur = cur.next;
		}
		// remove element
		slowPtr.next = slowPtr.next.next;
		return root;
	}
	
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(0);
		Node<Integer> node = root;
		for(int i = 1 ; i < 7 ; i++) {
			// when i = 4, set Node val to 1
			node.next = new Node<Integer>(i);
			node = node.next;
		}
		System.out.println("Before removal:           "
				+ "             " + root.getList());
		LinkedList2_2 Traverser = new LinkedList2_2();
		int k = 4;
		root = Traverser.removeKthFromEnd(root, k);
		System.out.println("After removal of " + k + "th element from "
				+ "end: " + root.getList());
		
	}

}
