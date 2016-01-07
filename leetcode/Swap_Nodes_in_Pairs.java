package leetcode;

public class Swap_Nodes_in_Pairs {
	public static ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode t0 = new ListNode(0);
		t0.next = head;
		
		ListNode cur = t0;
	
		while(cur.next != null && cur.next.next != null) {
			ListNode temp = cur.next;
			cur.next = temp.next;
			temp.next = cur.next.next;
			cur.next.next = temp;
			cur = temp;
		}
	
		return t0.next;
    }
	
	public static void main(String[] args) {
		ListNode lead = new ListNode(1);
		ListNode head = lead;
		for(int i = 2 ; i <= 5 ; i++) {
			ListNode cur = new ListNode(i);
			lead.next = cur;
			lead = cur;
		}
		lead = head;
		System.out.print("List before: ");
		while(lead != null) {
			System.out.print(lead.val + " -> ");
			lead = lead.next;
		}
		System.out.println("null");
		
		// after removal
		head = swapPairs(head);
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
