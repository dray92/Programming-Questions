package leetcode;

public class Linked_List_Cycle {

	public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow || fast.next == slow)
                return true;
        }
        return false;
    }
	
	class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		 	val = x;
		 	next = null;
		 }
	}
}
