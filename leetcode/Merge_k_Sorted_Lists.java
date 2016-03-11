package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as 
 * one sorted list. Analyze and describe its complexity. 
 * @author Debosmit
 *
 */
public class Merge_k_Sorted_Lists {

	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) 
			return null;
		
		PriorityQueue<ListNode> pq = 
					new PriorityQueue<ListNode>(lists.length, listNodeComparator);
		
		// add top of each list to the pq
		for(ListNode node: lists)
			if(node != null)
				pq.add(node);
		
		// till pq is empty, remove the smallest node
		// remember, this node has a whole list after it
		// that list will need to get added back into the pq
		
		ListNode head = new ListNode(1), cur = head;
		
		while(!pq.isEmpty()) {
			// remove smallest node
			ListNode curSmallest = pq.poll();
			
			// add this to our list
			cur.next = curSmallest;
			
			// curSmallest.next can be the remainder
			// of a list; if so, it must be added back
			if(curSmallest.next != null)
				pq.add(curSmallest.next);
			
			cur = cur.next;
		}
		
	    return head.next;
	}
	
	private Comparator<ListNode> listNodeComparator = new Comparator<ListNode>() {

		@Override
		public int compare(ListNode o1, ListNode o2) {
			if(o1.val > o2.val)
				return 1;
			if(o1.val < o2.val)
				return -1;
			return 0;
		}
		
	};
	
	//  Definition for singly-linked list.
	static class ListNode {
		int val;
		ListNode next;
	 
		ListNode(int x) {
			this(x, null);
		}
		
		ListNode(int x, ListNode next) {
			this.val = x;
			this.next = next;
		}
		
		public String toString() {
			StringBuilder st = new StringBuilder();
			st.append("[" + this.val);
			ListNode cur = this.next;
			while(cur != null) {
				st.append(", " + cur.val);
				cur = cur.next;
			}
			st.append("]");
			return st.toString();
		}
	}
	
	public static void main(String[] args) {
		Merge_k_Sorted_Lists Merger = new Merge_k_Sorted_Lists();
		ListNode l1 = new ListNode(1, new ListNode(5, new ListNode(9)));
		ListNode l2 = new ListNode(2, new ListNode(6, new ListNode(10)));
		ListNode l3 = new ListNode(3, new ListNode(7, new ListNode(11)));
		ListNode l4 = new ListNode(4, new ListNode(8, new ListNode(12)));
		ListNode l5 = new ListNode(1, new ListNode(2, new ListNode(3)));

		ListNode[] arr = new ListNode[]{l1, l2, l3, l4, l5};
		ListNode newList = Merger.mergeKLists(arr);
		System.out.println(newList);
		
		
	}
}
