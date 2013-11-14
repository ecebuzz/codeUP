/* Write your custom functions here */
static int diameterOfTree(Node root) {
/* For your reference
   class Node {
       Node left, right;
       int data;
               Node(int newData) {
           left = right = null;
           data = newData;
       }
   }
*/ 
    int diameter = 0;
	if(root == null) { return diameter; }

    
    int leftDiameter = diameterOfTree(root.left);
    int rightDiameter = diameterOfTree(root.right);
	int leftDepth = computeDepth(root.left);
	int rightDepth = computeDepth(root.right);
	diameter = leftDepth + rightDepth + 1;
    
	return Math.max( Math.max(diameter, leftDiameter), rightDiameter);    
}

static int computeDepth(Node root) {
	if(root == null) {
		return 0;
	}

	int leftDepth = computeDepth(root.left);
	int rightDepth = computeDepth(root.right);

	return 1 + Math.max(leftDepth, rightDepth);
}