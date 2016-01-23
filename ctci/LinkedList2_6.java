package ctci;

import ctci.LinkedList2_1.Node;

/**
 * Take a circular linked list as input.
 * Return the node at the beginning of 
 * the loop.
 * @author Debosmit
 *
 */
public class LinkedList2_6 {
	
	public <T> Node<T> getLoop(Node<T> list) {
		
		
		return null;
	}
	
	public <T> boolean isCircular(Node<T> list) {
		if(list == null || list.next == null)
			return false;
		
		Node<T> fast, slow;
		slow = list;
		fast = list.next.next;
		try {
			while(fast != null && slow != null) {
				if()
				slow = slow.next;
				fast = fast.next.next;
			}
		} catch(Exception e) {
			return false;
		}
	}
}
