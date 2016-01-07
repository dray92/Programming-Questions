package leetcode;

public class Reverse_Nodes_in_k_Group {
	public static ListNode reverseKGroup(ListNode head, int k) {
		
		if(head == null || head.next == null || k < 2)
			return head;
		
		ListNode start = new ListNode(0);
		start.next = head;
		ListNode newHead = start;
		
		outerloop:
		while(start != null && start.next != null) {
			ListNode last = start.next, ptr = last;
			ListNode cur = last;
			for(int i = 0 ; i < k ; i++) {
				if(cur == null)
					break outerloop;
				cur = cur.next;
			}
			for(int i = 1 ; i < k ; i++) {
				ListNode temp = ptr.next;
				ListNode temp2 = start.next;
				last.next = temp.next;
				start.next = temp;
				temp.next = temp2;
			}
			start = last;
		}
		
		return newHead.next;
	}
	
	public static void main(String[] args) {
		ListNode lead = new ListNode(1);
		ListNode head = lead;
		for(int i = 2 ; i <= 10 ; i++) {
			ListNode cur = new ListNode(i);
			lead.next = cur;
			lead = cur;
		}
		lead = head;
		System.out.print("List: ");
		while(lead != null) {
			System.out.print(lead.val + " -> ");
			lead = lead.next;
		}
		System.out.println("null");
		
		// after removal
		head = reverseKGroup(head, 3);
		lead = head;
		System.out.print("List after: ");
		while(lead != null) {
			System.out.print(lead.val + " -> ");
			lead = lead.next;
		}
		System.out.println("null");
	}
	
	public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	
}
