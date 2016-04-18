package leetcode;

// https://leetcode.com/problems/reorder-list/
public class Reorder_List {
	
	public static void reorderList2(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
        	return;
        
        ListNode mid = head, cur = head;
        int num = 0;
        
        while(cur.next.next != null) {
        	mid = mid.next;
        	cur = cur.next.next;
        	num++;
        	if(cur.next == null) {
        		num--;
        		break;
        	}
        }
        
        ListNode start = head;
        while(num >= 0 && start != mid) {
        	ListNode movedNode = mid;
        	int count = num;
        	while(count-- > 0) 
        		movedNode = movedNode.next;
        	
        	// node to move is movedNode.next
        	ListNode node = movedNode.next;
        	movedNode.next = null;
        	
        	node.next = start.next;
        	start.next = node;
        	
        	num--;
        	start = start.next.next;
        }
    }
	
	public static ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
            
        ListNode newHead = new ListNode(-1);
        ListNode curNewHead = newHead;
        
        ListNode cur = head;
        while(cur != null) {
            ListNode temp = cur;
            cur = cur.next;
            
            temp.next = curNewHead.next;
            curNewHead.next = temp;
            
        }
        
        return newHead.next;
    }
	
	public static void reorderList(ListNode head) {
		if(head == null || head.next == null || head.next.next == null)
        	return;
        
		ListNode mid = head, cur = head;
        while(cur.next != null && cur.next.next != null) {
        	mid = mid.next;
        	cur = cur.next.next;
        }
        
        ListNode second = mid.next;
        mid.next = null;
        
        second = reverseList(second);
        
        cur = head;
        while(second != null) {
        	ListNode temp = second;
        	second = second.next;
        	
        	temp.next = cur.next;
        	cur.next = temp;
        	cur = cur.next.next;
        }
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(5);
		System.out.println(head);
		reorderList(head);
		System.out.println(head);
	}
	
	static class ListNode {
		 int val;
		 ListNode next;
		 
		 ListNode(int x) { 
			 val = x; 
			 next = null;
		 }
		 
		 @Override
		 public String toString() {
			 ListNode cur = this;
			 StringBuilder st = new StringBuilder();
			 st.append("[");
			 while(cur!=null) {
				 st.append(cur.val);
				 if(cur.next != null)
					 st.append(", ");
				 cur = cur.next;
			 }
			 st.append("]");
			 return st.toString();
		 }
	}
}