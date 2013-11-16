
public class CheckBinaryTree {
	/*
	 * Given a binary tree, check whether it's
	 * a binary search tree
	 */

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

	public class Message {
		/*
		 * Message class for pass the information
		 * of whether the left sub tree and right sub tree
		 * are BST and the maximum and minimum valuve
		 * have been seen so far
		 */
		public boolean isBST;
		public int value;

		public Message() {
			isBST = true;
			value = Integer.MIN_VALUE;
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

		// Using inorder traversal of the tree, and remeber
		// the maximum value has been seen.
		// if any reverse order is witnessed, return false
		// else reeturn true
		
		Message msg = new Message();

		inOrderTraverse(msg, root);
		isBST(msg, root, true);

		return msg.isBST;

	}

	
	public static void isBST(Message msg, TreeNode root, boolean isLeft) {
		// Exception handle
		if(root == null) { return; }

		// Check the left substree is a BST
		isBST(msg, root.left, true);
		if(!msg.isBST) {
			return ;
		}

		if(msg.max >= root.val) {
			msg.isBST = false;
			return ;
		}



		// Check the right subtree is a BST
		isBST(msg, root.right, false);
		if(!msg.isBST) {
			return ;
		}

		if(msg.min <= root.val) {
			msg.isBST = false;
			return ;
		}


		// Update the corresponding max and min value
		
		if(isLeft) {
			msg.max = (root.right == null ? root.val : msg.min);
		}
		else {
			msg.min = (root.left == null? root.val : msg.max);
		}
	}


}
