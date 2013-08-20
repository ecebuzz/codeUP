
public class BitSet {
	public static void main( String args[] ) {
		/** Set the range starting at i and ending at j of n to the
		 * value of m. m is the length of j - i + 1.
		 */
		//Example
		int n = 1 << 10;
		int m = 0x15;
		int i = 2;
		int j = 6;
		int result = bitSet( n, m, i, j );
		System.out.printf( "n is %s\n", Integer.toBinaryString( n ) );
		System.out.printf( "m is %s\n", Integer.toBinaryString( m ) );
		System.out.printf( "Replacing from i to j of n with m %s\n", Integer.toBinaryString( result ) );
	}

	public static int bitSet( int n, int m, int i, int j ) {
		if( i > j ) { return -1; }
		if( Integer.toBinaryString( m ).length() > ( j - i + 1 ) ) { return -1; }
		int left = (~0) << i;
		int right = ( 1 << ( j + 1 ) ) - 1;
		int mask = left & right;
		// Clear n
		n = n & ( ~mask );
		return n | m << i;
	}
}
