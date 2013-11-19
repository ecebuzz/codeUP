
public class Solution {
	
	//  Definition for singly-linked list.
	  class ListNode {
	  	int val;
	  	ListNode next;
	  	ListNode(int x) {
	  		val = x;
	  		next = null;
	  	}
	  }
	 

	public static ListNode hasCycle(ListNode head) {
		/*
		 * Given a singly-linked list, return the
		 * node where the cycle begins. If there is
		 * no cycle, return null.
		 * 
		 * Assumption:
		 * 1) The list is a singly linked list;
		 * 2) If the head node is null or there is
		 *    no cycle exists, return null. Otherwise,
		 *    return the beginning node of the cycle;
		 * 3) If two runners, a faster one moves 2 steps
		 *    at a time and a slower one moves 1 step at
		 *    a time, traverse the linked list, either one
		 *    of them will hit the null node or they
		 *    will arrive at the same node.
		 *    
		 *    
		 * Approach:
		 * A faster runner moves 2 steps at one
		 * time and a slower runner moves 1 step
		 * at a time. When the two runners first
		 * meet, start another slower runner at the
		 * head and move the current slower runner
		 * forward. When the two runners meet, they're
		 * at the beginning node of cycle.
		 * 
		 * Complexity:
		 * 1) Time complexity: The time complexity is
		 *    O(n), were n is the number of nodes in the
		 *    linked list.
		 * 2) Space complexity: The space complexity is
		 *    O(1).
		 * 
		 * @param
		 * Input: ListNode
		 *        The head node of the singly linked list
		 *        
		 * Output: ListNode 
		 *         The beginning node of the cycle
		 *          
		 */

		// Null case
		if(head == null) { return null; }

		ListNode fastRunner = head;
		ListNode slowRunner = head;

		while(fastRunner.next != null && 
				fastRunner.next.next != null) {
			// fastRunner moves 2 steps at a time
			// while slowRuuner moves 1 step at 
			// a time.
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
