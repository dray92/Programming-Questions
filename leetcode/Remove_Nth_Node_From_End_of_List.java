package leetcode;

   
public class Remove_Nth_Node_From_End_of_List {
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		
		if(head == null || n <= 0)
			return head;
		
		ListNode fast = head;
		for(int i = 0; i < n ; i++)
			fast = fast.next;
		
		// if fast is null, head needs to be deleted
		if(fast == null)
			return head.next;
		
		ListNode cur = head;
		
		while(fast.next != null) {
			fast = fast.next;
			cur = cur.next;
		}
		
		cur.next = cur.next.next;
		
		return head;
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
		System.out.print("List: ");
		while(lead != null) {
			System.out.print(lead.val + " -> ");
			lead = lead.next;
		}
		System.out.println("null");
		
		// after removal
		head = removeNthFromEnd(head, 5);
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