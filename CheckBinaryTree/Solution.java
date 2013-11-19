import java.util.ArrayList;
public class Solution {

	static class TreeNode {
		/*
		 * BinaryTree Node
		 */
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode() {
			left= null;
			right= null;
		}

		public TreeNode(int val,
				TreeNode left, TreeNode right) {
			this.val = val;
			this.left= left;
			this.right= right;
		}

	}
	
	static class Message {
		/*
		 * Storing the 
		 */
		int val;
		public Message() {
			val = Integer.MIN_VALUE;
		}
	}
	
	public static boolean isBST(TreeNode root) {
		/*
		 * Given the root node of a binary tree, check
		 * it's a binary search tree or not
		 * 
		 * Assumptions:
		 * 1) The tree node holds integer values
		 * 2) Each node has access to its left and right
		 *    child.
		 * 3) If the root is null, it's a valid binary
		 *    search tree.
		 *    
		 * Approach:
		 * A valid binary search tree (BST) must 
		 *    meet the following conditions:
		 *    i) The left subtree must be a valid BST, and
		 *       all the elements must be smaller than
		 *       its root value;
		 *    ii) The right subtreee must be a valid BST,
		 *        and all the elements must be bigger than
		 *        its root value.
		 *  Based on this, I design a recursion algorithm. 
		 *  Pass down the min value and max value. If it's 
		 *  a valid tree, the current node must fall in the
		 *  range defined by the min and max value and its
		 *  left subtree must fall between the current min value
		 *  and the current node value while its right subtree
		 *  must fall between the current node value and the 
		 *  current max value.
		 *  
		 *  Complexity:
		 *  1) Time complexity: since every node will be touched
		 *     at most once, the time complexity is O(N), where
		 *     N is the number of nodes in the binary tree.
		 *  2) Space complexity: It uses O(1) space (neglecting
		 *     the stack space used by calling function recursively)
		 * @param
		 * Input: root node
		 *        TreeNode root
		 * Output: if is BST, true
		 *         else,      false
		 */
		// Boundary case
		if(root == null) {
			// Empty tree is a BST
			return true;
		}

		// Using inorder traversal of the tree.
		// If any reverse order is witnessed, return false
		// else reeturn true
		Message msg = new Message();
		
//		return isInOrderBST(root, msg);
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
	}
	
	public static boolean checkBST(TreeNode root, int min, int max) {
		/*
		 * Check the binary search tree property is hold recursively
		 */
		if(root == null) { return true; }
		if(min < root.val && max > root.val) {
			// If the current node meets the binary search property,
			// recursively check its left subtree
			// and right subtree.
			return checkBST(root.left, min, root.val) &&
					checkBST(root.right, root.val, max);
		}
		else {
			// Binary search tree property is violdated at
			// the current node
			return false;
		}
	}
	
	public static boolean isInOrderBST(TreeNode root, Message msg) {
		if(root == null) { return true; }
		if(isInOrderBST(root.left, msg)) {
			if(root.val > msg.val) {
				msg.val = root.val;
				return isInOrderBST(root.right, msg);
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	


	public static boolean isValidBST(TreeNode root) {
		/*
		 * Given the root node of a binary tree, check
		 * it's a binary search tree or not
		 * @param
		 * Input: root node
		 *        TreeNode root
		 * Output: if is BST, true
		 *         else,      false
		 */
		// Exception hanle
		if(root == null) {
			// Empty tree is a BST
			return true;
		}

		// Using inorder traversal of the tree.
		// If any reverse order is witnessed, return false
		// else reeturn true
		
		ArrayList<Integer> inOrderList = new ArrayList<Integer>();
		// Get the in-order traversal
		
        inOrderTraverse(root, inOrderList);


		// If ascending order, return true
		// else, return false
		return isAscending(inOrderList);
	}

	public static void inOrderTraverse(TreeNode root, ArrayList<Integer> inOrderList) {
		if(root == null) { return; }

		// Traverse the left subtree
		inOrderTraverse(root.left, inOrderList);

		// Push in the current node
		inOrderList.add(root.val);

		// Traverse the right subtree
		inOrderTraverse(root.right, inOrderList);
	}

	public static boolean isAscending(ArrayList<Integer> list) {
		/*
		 * Check an arraylist is in ascending order
		 * If is, return true
		 * else, return false
		 */

		if(list.size() <= 1) { return true; }

		int prev = list.get(0);
		for(int i = 1; i < list.size(); i++) {
			int cur = list.get(i);
			if(prev >= cur) {
				// If reverse order happens
				return false;
			}
			prev = cur;
		}

		return true;
	}

}
