package leetcode;

public class Remove_Linked_List_Elements {
	
	public ListNode removeElements(ListNode head, int val) {
        
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode cur = newHead;
        
        while(cur.next != null) {
            if(cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return newHead.next;
    }
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			this.val = x; 
		}
	}

}
