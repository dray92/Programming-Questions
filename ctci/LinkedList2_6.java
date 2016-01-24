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
		if(!isCircular(list))
			throw new IllegalArgumentException("List is not circular");
		
		// we advance slow by 1, and fast by 2
		// so, meeting point will be some multiple of 2
		// since list must be circular, they will meet 
		// somewhere inside the loop
		Node<T> fast, slow;
		slow = list;
		fast = list;
		while(true) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow.equals(fast))
				break;
		}
		
		// reset slow to the head
		// increment both pointers by 1
		// these will meet again at a point 
		// which is in the set [n, 2n, 3n, ..]
		// on some iteration; all elements in 
		// this set points to the exact same
		// node, which is the start of the loop
		slow = list;
		while(!slow.equals(fast)) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	
	public <T> boolean isCircular(Node<T> list) {
		if(list == null || list.next == null)
			return false;
		
		Node<T> fast, slow;
		slow = list;
		fast = list;
		try {
			while(fast != null && slow != null) {
				if(fast.next == slow)
					return true;
				slow = slow.next;
				fast = fast.next.next;
			}
		} catch(Exception e) {
			return false;
		}
		return false;
	}
	
	private static int randomWithRange(int min, int max) {
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
    }
	
	
	public static void main(String[] args) {
		
		int[] numRange = {0, 25};	// {min, max}
		
		int getVal = randomWithRange(numRange[0], numRange[1]);
		Node<Character> root = new Node<Character>((char)('A' + getVal));
		Node<Character> node = root;
		int numItems = 10;
		for(int i = 1 ; i < numItems ; i++) {
			// when i = 4, set Node val to 1
			getVal = randomWithRange(numRange[0], numRange[1]);
			node.next = new Node<Character>((char)('A' + getVal));
			node = node.next;
		}
		// get some random node in the list
		Node<Character> loopStartNode = root;
		getVal = randomWithRange(0, numItems-3);
		while(getVal > 0) {
			loopStartNode = loopStartNode.next;
			getVal--;
		}
		
		// create circle
		node.next = loopStartNode;
		
		System.out.println("Pre-chosen point of circularity: " + loopStartNode.value);
		
		// printing
		node = root;
		System.out.print("List: ");
		System.out.print(node.value + " -> ");
		for(int i = 0 ; i < numItems + 3 ; i++) {
			node = node.next;
			if(node.equals(loopStartNode))
				System.out.print("\"" + node.value + "\" -> ");
			else 
				System.out.print(node.value + " -> ");
		}
		System.out.println(".....");
		
		LinkedList2_6 Traverser = new LinkedList2_6();
		Node<Character> calculatedLoopStartNode = Traverser.getLoop(root);
		System.out.println("Computed point of circularity: " + calculatedLoopStartNode.value);
	}
}
