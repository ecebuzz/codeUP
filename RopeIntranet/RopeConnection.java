import java.util.Arrays;
import java.util.ArrayList;



public class RopeConnection {

	private int size;
	private PosPair[] ropePos;
	private int count;

	public RopeConnection( int size, int[][] pos ) {
		this.size= size;
		this.count = 0;
		ropePos = new PosPair[size];
		for( int i = 0; i < size; i++ ) {
			ropePos[i] = new PosPair( pos[i][0], pos[i][1] );
		}
	}

	public int computeIntersection() {
		if( ropePos == null ) { return -1; }
		Arrays.sort( ropePos );
		int[] arr = new int[this.size];

		for( int i = 0; i < size; i++ ) {
			arr[i] = ropePos[i].getRightPos();
		}

		this.count = computeReverseOrders( arr );

		return count;
	}
	
	public int[] toIntegerArr( ArrayList<Integer> list ) {
		if( list == null ) { return null; } 
		int[] arr = new int[list.size()];
		for( int i = 0; i < list.size(); i++ ) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	public int computeReverseOrders( int[] arr ) {
		if( arr == null ) { return -1; }
		if( arr.length <= 1 ) { return 0;}

		// Merge-sort to compute the reverse orders
		ArrayList<Integer> lefts = new ArrayList<Integer>();
		ArrayList<Integer> rights = new ArrayList<Integer>();
		
		int mid = arr[0];
		int numOfInters = 0;

		for( int i = 1; i < arr.length; i++ ) {
			if( arr[i] < mid ) {
				numOfInters++;
				lefts.add( arr[i] );
				numOfInters += rights.size();
			}
			else {
				rights.add( arr[i] );
			}
		}

		numOfInters += computeReverseOrders( toIntegerArr( lefts ) );
		numOfInters += computeReverseOrders( toIntegerArr( rights ) );
		return numOfInters;

	}	


}
