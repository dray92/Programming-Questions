package ctci;

import ctci.LinkedList2_1.Node;

/**
 * Delete node in middle of list given access to
 * only that node.
 * Input node c in a -> b -> c -> d -> e
 * Output nothing is returned; new list a -> b -> d -> e
 * @author Debosmit
 *
 */
public class LinkedList2_3 {
	public <T> boolean deleteNode(Node<T> node) {
		if(node == null || node.next == null)
			return false;
		
		Node<T> nextNode = node.next;
		node.value = nextNode.value;
		node.next = nextNode.next;
		
		return true;
	}
	
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(0);
		Node<Integer> node = root;
		for(int i = 1 ; i < 7 ; i++) {
			// when i = 4, set Node val to 1
			node.next = new Node<Integer>(i);
			node = node.next;
		}
		System.out.println("Before removal:  "
				+ "             " + root.getList());
		LinkedList2_3 Traverser = new LinkedList2_3();
		
		// node to be deleted
		node = root.next.next;
		Traverser.deleteNode(node);
		System.out.println("After removal of " + node.value + " from "
				+ "list: " + root.getList());
		
	}
}
