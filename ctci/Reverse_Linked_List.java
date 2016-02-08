package ctci;

import ctci.LinkedList2_1.Node;

public class Reverse_Linked_List {

	public Node<Object> reverseList(Node<Object> head) {
		if(head == null || head.next == null)
			return head;
		
		Node<Object> cur = head, prev = null, nextNode = null;
		
		while(cur != null) {
			// pointer to next element
			nextNode = cur.next;
			
			// for the first case,
			// head needs to point to null after
			// for future cases, prev needs to be  
			// this node
			cur.next = prev;
			
			prev = cur;
			cur = nextNode;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		Reverse_Linked_List Reverser = new Reverse_Linked_List();
		
		Node<Object> head = new Node<Object>(0), cur = head;
		int listLen = 5;
		for(int i = 1 ; i <= listLen ; i++) {
			cur.next = new Node<Object>(i);
			cur = cur.next;
		}
		System.out.println("List:          " + head.getList());
		
		head = Reverser.reverseList(head);
		
		System.out.println("Reversed list: " + head.getList());
	}
}
