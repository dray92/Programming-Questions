package ctci;

import ctci.LinkedList2_1.Node;

/**
 * Partition a linked list around a value x, such
 * that all nodes less than x comes before all values
 * greater than or equal to x.
 * @author Debosmit
 *
 */
public class LinkedList2_4 {
	public Node<Integer> partitionList(Node<Integer> node, int x) {
		if(node == null || node.next == null)
			return node;
		
		Node<Integer> cur, smallerNodes, temp;
		
		// ensure element at head is less than x
		if(node.value >= x) {
			cur = node;
			while(cur.next != null && cur.next.value >= x)
				cur = cur.next;
			
			// possibly reached end of list without
			// getting a value less than x; so,
			// list has no element less than x,
			// i.e., no need to move any node
			if(cur.next == null)
				return node;
				
			Node<Integer> newHead = cur.next;
			cur.next = newHead.next;
			newHead.next = node;
			node = newHead;
		}
		// at this stage, if list had no element 
		// less than x, this point wouldn't
		// have been reached; now, head node
		// must contain value less than x
		
		smallerNodes = node;
		cur = node;
		while(cur.next != null) {
			// if next node is smaller than x
			// move to 'smaller' partition towards 
			// the front of the list
			// head < x, so current node that is
			// smaller than x, can be attached after it
			if(cur.next.value < x) {
				temp = cur.next;
				cur.next = temp.next;
				temp.next = smallerNodes.next;
				smallerNodes.next = temp;
				smallerNodes = temp;
			}
			cur = cur.next;
		}
		
		return node;
	}
	
	private static int randomWithRange(int min, int max) {
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
    }

	public static void main(String[] args) {
		int[] numRange = {15, 99};	// {min, max}
		
		Node<Integer> root = new Node<Integer>(randomWithRange(numRange[0], numRange[1]));
		Node<Integer> node = root;
		for(int i = 1 ; i < 7 ; i++) {
			// when i = 4, set Node val to 1
			int getVal = randomWithRange(numRange[0], numRange[1]);
			node.next = new Node<Integer>(getVal);
			node = node.next;
		}
		System.out.println("Before removal:   "
				+ "             " + root.getList());
		LinkedList2_4 Traverser = new LinkedList2_4();
		
		// node to be deleted
		node = root.next.next;
		int x = randomWithRange(numRange[0], numRange[1]);
		root = Traverser.partitionList(root, x);
		System.out.println("After partitioning around " + x + ":  " + root.getList());
		
	}
}
