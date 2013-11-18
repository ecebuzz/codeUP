
public class Solution {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode mergeTwoSortedLists(ListNode l1, listNode l2) {
		// Null case
		if(l1 == null && l2 == null) { return null; }

		if(l1 == null || l2 == null) { 
			return (l1 == null ? l2 : l1);
		}

		ListNode head = new ListNode(0);
		ListNode cur = head;
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		while(cur1 != null &&
				cur2 != null) {
			if(cur1.val < cur2.val) {
				cur.next = cur1;
				cur1 = cur1.next;
			}
			else {
				cur.next = cur2;
				cur2 = cur2.next;
			}
			cur = cur.next;
		}

		if(cur1 != null) {
			cur.next = cur1;
		}
		else if(cur2 != null) {
			cur.next = cur2;
		}

		return head.next;
	}
}
