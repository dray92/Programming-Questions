package leetcode;

public class Remove_Duplicates_from_Sorted_List {
	public static ListNode deleteDuplicates(ListNode head) {
        
		if(head == null)
			return null;
		
		if(head.next == null)
			return head;
		
		ListNode cur = head;
		
		while(cur.next != null) {
			ListNode curNext = cur.next;
			if(cur.val == curNext.val) {
				cur.next = curNext.next;
			} else {
				cur = cur.next;
			}
			
		}
		
		return head;
    }
	
	public static void main(String[] args) {
		ListNode lead = new ListNode(1);
		ListNode head = lead;
		for(int i = 2 ; i <= 2 ; i++) {
			ListNode cur = new ListNode(i);
			lead.next = cur;
			lead = cur;
		}
		ListNode cur = new ListNode(2);
		lead.next = cur;
		lead = cur;
		
		lead = head;
		System.out.print("List: ");
		while(lead != null) {
			System.out.print(lead.val + " -> ");
			lead = lead.next;
		}
		System.out.println("null");
		
		// after removal
		head = deleteDuplicates(head);
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
