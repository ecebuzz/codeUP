import java.util.HashMap;
import java.util.LinkedList;

public class BuildBST {
	/* Build up the binary search tree with its
	 * in-order traversal
	 * pre-order traversal
	 * 			1
	 * 		2		3
	 * 	 4	   5  6 	7
	 * 8	9
	 *   10   11
	 *   in-order : 	8 4 10 9 11 2 5 1 6 3 7
	 *   pre-order:		1 2 4 8 9 10 11 5 3 6 7
	 */
	public static void main( String args[] ) throws Exception {
//		TreeNode root = new TreeNode();
		String inOrder  = "8 4 10 9 11 2 5 1 6 3 7";
		String preOrder = "1 2 4 8 9 10 11 5 3 6 7";
		TreeNode root = buildBST( inOrder, preOrder );
		StringBuilder inOrderT = new StringBuilder();
		StringBuilder preOrderT = new StringBuilder();
		inOrderPrint( root, inOrderT );
		preOrderPrint( root, preOrderT );
		System.out.printf( "InOder Traversal: %s\n", inOrderT.toString().trim() );
		System.out.printf( "PreOrder Traversal: %s\n", preOrderT.toString().trim() );
		
	}
	
	public static void inOrderPrint( TreeNode root, StringBuilder inOrderT ) {
		if( root == null ) { return ; }
		// Left subtree
		inOrderPrint( root.left, inOrderT );
		// Subtree root
		inOrderT.append( Integer.toString( root.data ) );
		inOrderT.append( " " );
		// Right subtree
		inOrderPrint( root.right, inOrderT );
	}
	
	public static void preOrderPrint( TreeNode root, StringBuilder preOrderT ) {
		if( root == null ) { return ; }
		// Subtree root
		preOrderT.append( Integer.toString( root.data ) );
		preOrderT.append( " " );
		// Left subtree
		preOrderPrint( root.left, preOrderT );
		// Right subtree
		preOrderPrint( root.right, preOrderT );
	}
	// Recursively
	public static TreeNode buildBST ( String inOrder, String preOrder ) throws Exception {
		String[] inOrderArr = inOrder.split( " " );
		String[] preOrderArr = preOrder.split( " " );
		
		if( inOrderArr.length != preOrderArr.length ) {
			throw new Exception( "The lenght of inorder traversal is not the same as that of preorder traversal!" );
		}
		
		HashMap<Integer, Integer> inOrderIdx = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> preOrderIdx = new HashMap<Integer, Integer>();
		for( int i = 0; i < inOrderArr.length; i++ ) {
			inOrderIdx.put( Integer.parseInt( inOrderArr[i] ), i );
			preOrderIdx.put( Integer.parseInt( preOrderArr[i] ), i );
		}
		
		return buildBSTrecursion( inOrderArr, preOrderArr, 0, inOrderArr.length - 1, 0, inOrderArr.length - 1,
				inOrderIdx, preOrderIdx );
	}
	
	public static String[] subArray( String[] arr, int start, int end ) {
		String[] newArr = new String[end - start + 1];
		for( int i = 0; i < newArr.length; i++ ) {
			newArr[i] = arr[start + i];
		}
		return newArr;
	}
	class Index {
		public int inStart;
		public int inEnd;
		public int preStart;
		public int preEnd;
		public Index( int ins, int ine, int pres, int pree ) {
			inStart = ins;
			inEnd = ine;
			preStart = pres;
			preEnd = pree;
		}
	}
	public static TreeNode buildBSTiteratively( String[] inOrderArr, String[] preOrderArr, 
			HashMap<Integer, Integer> inOrderIdx ) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<String[]> inOrderQueue = new LinkedList<String[]>();
		LinkedList<String[]> preOrderQueue = new LinkedList<String[]>();
		
		Index index = new Index( 0, inOrderArr.length - 1, 0, preOrderArr.length - 1 );
		int inStart = 0;
		int inEnd = inOrderArr.length - 1;
		int preStart = 0;
		int preEnd = preOrderArr.length -1;
		TreeNode root = new TreeNode( Integer.parseInt( preOrderArr[0] ), null, null );
		queue.add( root );
		

		
		while( !queue.isEmpty() ) {
			TreeNode current = queue.removeFirst();
			int rootIdx = inOrderIdx.get( Integer.parseInt( preOrderArr[0] ) );
			if( inStart < rootIdx ) {
				current.left = new TreeNode( Integer.parseInt( preOrderArr[preStart + 1] ), null, null );
				queue.add( current.left );
				inOrderQueue.add( subArray( inOrderArr, inStart, rootIdx - 1 ) );
				preOrderQueue.add( subArray( preOrderArr, preStart + 1, preStart + rootIdx - inStart ) );
			}
			if( rootIdx < inEnd ) { 
				current.right = new TreeNode( Integer.parseInt( preOrderArr[preStart + rootIdx - inStart + 1] ), null, null );
				queue.add( current.right );
				inOrderQueue.add( subArray( inOrderArr, rootIdx + 1, inEnd ) );
				preOrderQueue.add( subArray( preOrderArr, preStart + rootIdx - inStart + 1, preEnd ) );
			}
			
			
		}
		
		return null;
		
	}
	
	public static TreeNode buildBSTrecursion( String[] inOrderArr, String[] preOrderArr, 
			int inStart, int inEnd, int preStart, int preEnd, HashMap<Integer, Integer> inOrderIdx,
			HashMap<Integer, Integer> preOrderIdx ) {
		if( inStart > inEnd || preStart > preEnd ) { return null; }
		
		TreeNode root = new TreeNode( Integer.parseInt( preOrderArr[preStart] ), null, null );
		int rootIdx = inOrderIdx.get( root.data );
		root.left = buildBSTrecursion( inOrderArr, preOrderArr, inStart, rootIdx - 1,
				preStart + 1, preStart + rootIdx - inStart, inOrderIdx, preOrderIdx );
		root.right = buildBSTrecursion( inOrderArr, preOrderArr, rootIdx + 1, inEnd, 
				preStart + rootIdx - inStart + 1, preEnd, inOrderIdx, preOrderIdx );
		
		return root;
	}
}
