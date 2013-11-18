
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


	public static boolean isValidBST(TreeNode root) {
		/*
		 * Given the root node of a binary tree, check
		 * it's a binary search tree or not
		 * @params
		 * Input: root node
		 *        TreeNode root
		 * Output: if is BST, true
		 *         else,      false
		 */
		// Exception Hanld
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
