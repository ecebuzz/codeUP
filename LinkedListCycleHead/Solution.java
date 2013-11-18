
public class Solution {
	/*
	 * Definition for singly-linked list.
	 * class ListNode {
	 * 	int val;
	 * 	ListNode next;
	 * 	ListNode(int x) {
	 * 		val = x;
	 * 		next = null;
	 * 	}
	 * }
	 */

	public ListNode hasCycle(ListNode head) {
		/*
		 * Given a singly-linked list, return the
		 * node where the cycle begins. If there is
		 * no cycle, return null.
		 * 
		 * A faster runner moves 2 steps at one
		 * time and a slower runner moves 1 step
		 * at a time. When the two runners first
		 * meet, start another slower runner at the
		 * head and move the current slower runner
		 * forward. When the two runners meet, they're
		 * at the beginning node of cycle.
		 */

		// Null case
		if(head == null) { return null; }

		ListNode fastRunner = head;
		ListNode slowRunner = head;

		while(fastRunner.next != null && 
				fastRunner.next.next != null) {
			fastRunner = fastRunner.next.next;
			slowRunner = slowRunner.next;

			if(fastRunner.equals(slowRunner)) {
				break;
			}
		}

		if(fastRunner.next == null ||
				fastRunner.next.next == null) {
			// No cycle exists
			return null;
				}

		ListNode slowRunner2 = head;
		while(!slowRunner.equals(slowRunner2)) {
			slowRunner = slowRunner.next;
			slowRunner2 = slowRunner2.next;
		}

		return slowRunner;
	}
}
