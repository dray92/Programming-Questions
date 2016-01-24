package ctci;

import java.util.Stack;

import ctci.LinkedList2_1.Node;

/**
 * Check if a linked list is a palindrome
 * @author Debosmit
 *
 */
public class LinkedList2_7 {
	
	public <T> boolean isPalindrome(Node<T> list) {
		if(list == null || list.next == null)
			return true;
		
		Node<T> slow = list, fast = list;
		Stack<Node<T>> stack = new Stack<Node<T>>();
		
		while(fast != null && fast.next != null) {
			stack.push(slow);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// if there are odd elements,
		// when slow is at the middle element
		// fast will be at the last element
		// so, fast.next will be null
		// but, fast will not be null
		// odd elements => skip middle
		if(fast != null)
			slow = slow.next;
		
		while(!stack.isEmpty()) {
			Node<T> top = stack.pop();
			if(top.value != slow.value)
				return false;
			slow = slow.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Node<Character> list = new Node<Character>('A');
		Node<Character> cur = list;
		int maxChar = 6;
		for(int i = 1 ; i < maxChar ; i++) {
			cur.next = new Node<Character>((char)('A' + i));
			cur = cur.next;
		}
		for(int i = maxChar ; i >= 0 ; i--) {
			cur.next = new Node<Character>((char)('A' + i));
			cur = cur.next;
		}
		System.out.println("List: " + list.getList());
		LinkedList2_7 Traverser = new LinkedList2_7();
		System.out.println("Is list a palindrome? " + Traverser.isPalindrome(list));
	}
}
