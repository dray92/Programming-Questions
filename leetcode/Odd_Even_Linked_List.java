package leetcode;

// https://leetcode.com/problems/odd-even-linked-list/
public class Odd_Even_Linked_List {
	
	static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { 
			 val = x; 
			 next = null;
		 }
		 
		 public String toString() {
			return String.valueOf(this.val);
		}
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println(getString(head));
		head = oddEvenList(head);
		System.out.println(getString(head));
	}
	
	public static String getString(ListNode head) {
		 StringBuilder st = new StringBuilder();
		 ListNode cur = head;
		 while(cur != null) {
			 st.append(cur.val);
			 
			 if(cur.next != null)
				 st.append(" -> ");
			 
			 cur = cur.next;
		 }
		 return st.toString();
	 }
	
	public static ListNode oddEvenList(ListNode head) {
        if(head == null)
        	return null;
        
        if(head.next == null)
        	return head;
        
        ListNode oddTail = head, evenTail = head.next;
        
        boolean isNextOdd = true;
        
        while(evenTail != null && evenTail.next != null) {
        	ListNode temp = evenTail.next;
        	ListNode tempNext = temp.next;
        	
        	if(isNextOdd) {
        		temp.next = oddTail.next;
        		oddTail.next = temp;
        		oddTail = temp;
        	} else {
        		temp.next = evenTail.next;
        		evenTail.next = temp;
        		evenTail = temp;
        	}
        	
        	isNextOdd = !isNextOdd;
        	evenTail.next = tempNext;
        }
        
        return head;
    }
}
