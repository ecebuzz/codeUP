
public class Solution {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
		/*
		 * Given two sorted linked list, merge them into one sorted.
		 * 
		 * Assumption:
		 * 1) Both linked lists are sorted in ascending order;
		 * 2) If both linked lists are null, return null;
		 * 
		 * Approach:
		 * Initialize a wrapper node head, and have two runners
		 * iterate through the two sorted lists and link each node
		 * in ascending order.
		 * 
		 * Complexity:
		 * 1) Time Complexity: Since, in the worst case, we have to
		 *    iterate through all the nodes of the two lists, the 
		 *    time complexity is O(m+n), where m and n are the length
		 *    of the two lists.
		 * 2) Space Complexity: The space complexity is O(1).
		 * 
		 */
		// Null case
		if(l1 == null && l2 == null) { return null; }

		if(l1 == null || l2 == null) { 
			return (l1 == null ? l2 : l1);
		}

		ListNode head = new ListNode(0);
		ListNode cur = head;
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		// Merge two list nodes into one
		while(cur1 != null &&
				cur2 != null) {
			if(cur1.val < cur2.val) {
				// list 1 node should be merged into the result list
				cur.next = cur1;
				cur1 = cur1.next;
			}
			else {
				// list 2 node should be merged into the result list
				cur.next = cur2;
				cur2 = cur2.next;
			}
			// Move the result list runner
			cur = cur.next;
		}
		
		// Any list that has remaining nodes can
		// be directly merged in without further operations
		if(cur1 != null) {
			cur.next = cur1;
		}
		else if(cur2 != null) {
			cur.next = cur2;
		}

		return head.next;
	}
}
