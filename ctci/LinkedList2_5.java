package ctci;

import ctci.LinkedList2_1.Node;

/**
 * 2 numbers are implemented by a linked list, 
 * where each node is one digit. The digits are 
 * stored in reverse order, such that the element 
 * at the head is in the 1's place. Return the sum
 * of these two number in a linked list in the
 * reverse order.
 * Assumption: positive numbers
 * @author Debosmit
 *
 */
public class LinkedList2_5 {

	private final int BASE = 10;
	
	public Node<Integer> getSum(Node<Integer> list1, Node<Integer> list2) {
		// null list cases
		if(list1 == null && list2 == null)
			return new Node<Integer>(0);
		
		if(list1 == null)
			return list2;
		
		if(list2 == null)
			return list1;
		
		Node<Integer> ptr1 = list1, ptr2 = list2;
		Node<Integer> sum = null, sumHead = null;
		
		int digitSum = 0, carry = 0;
		while(ptr1 != null && ptr2 != null) {
			digitSum = (ptr1.value + ptr2.value) + carry;
			carry = digitSum / BASE;
			Node<Integer> newNode = new Node<Integer>(digitSum % 10);
			
			// for first digit
			if(sum == null) {
				sum = newNode;
				sumHead = newNode;
			} else {
				sum.next = newNode;
				sum = sum.next;
			}
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		
		// one of the lists may still have numbers left
		while(ptr1 != null) {
			digitSum = (ptr1.value + 0) + carry;
			carry = digitSum / BASE;
			sum.next = new Node<Integer>(digitSum % 10);
			sum = sum.next;
			ptr1 = ptr1.next;
		}
		
		while(ptr2 != null) {
			digitSum = (0 + ptr2.value) + carry;
			carry = digitSum / BASE;
			sum.next = new Node<Integer>(digitSum % 10);
			sum = sum.next;
			ptr2 = ptr2.next;
		}
		
		if(carry != 0)
			sum.next = new Node<Integer>(carry);
		
		return sumHead;
	}
	
	private static int randomWithRange(int min, int max) {
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
    }
	
	public static void main(String[] args) {
		int[] numRange = {0, 9};	// {min, max}
		
		Node<Integer> root1 = new Node<Integer>(randomWithRange(numRange[0], numRange[1]));
		Node<Integer> node = root1;
		for(int i = 1 ; i < 7 ; i++) {
			// when i = 4, set Node val to 1
			int getVal = randomWithRange(numRange[0], numRange[1]);
			node.next = new Node<Integer>(getVal);
			node = node.next;
		}
		System.out.println("List1: " + root1.getList());
		
		Node<Integer> root2 = new Node<Integer>(randomWithRange(numRange[0], numRange[1]));
		node = root2;
		for(int i = 1 ; i < 6 ; i++) {
			// when i = 4, set Node val to 1
			int getVal = randomWithRange(numRange[0], numRange[1]);
			node.next = new Node<Integer>(getVal);
			node = node.next;
		}
		System.out.println("List2: " + root2.getList());
		
		
		LinkedList2_5 Traverser = new LinkedList2_5();
		
		Node<Integer> sum = Traverser.getSum(root1, root2);
		System.out.println("Sum:   " + sum.getList());
		
	}
}
