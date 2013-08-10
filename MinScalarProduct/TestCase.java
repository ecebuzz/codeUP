import java.util.Arrays;
import java.math.BigInteger;

public class TestCase {
	private int[] x;
	private int[] y;
//	private int max;

	public TestCase( int size, String[] a, String[] b ) {
		if( a.length < 1 ) { return; }
//		x = a.clone();
//		y = b.clone();
		x = new int[size];
		y = new int[size];
		for( int i = 0; i < size; i++ ) {
//			x[i] = (int) a.charAt(i);
//			y[i] = (int) b.charAt(i);
			x[i] = Integer.parseInt( a[i] );
			y[i] = Integer.parseInt( b[i] );
//			if( max < Math.max( x[i], y[i] ) ) {
//				max = Math.max( x[i], y[i] );
//			}
		}
	}
	
//	public void printArrays() {
//		System.out.println( "Arrays are:" );
//		System.out.println( x );
//		System.out.println( y );
//	}
	
	public BigInteger computeMinProduct() {
		
		if( x.length != y.length || x.length == 0 || y.length == 0 ) {
			return new BigInteger( Integer.toString( Integer.MIN_VALUE ) );
		}
		
		Arrays.sort(x);
		Arrays.sort(y);
//		if( max <= 1000 ) {
//			
//		}
//		double scale = Math.max( x[x.length - 1], y[y.length - 1] );
//		long result = 0;
		BigInteger result = new BigInteger( "0" );
		int length = x.length;
		for( int i = 0; i < length; i++ ) {
//			long tmp = ( x[i] *  y[length - i - 1] ) + ( x[length - i - 1] * y[i] );
//			result += tmp;
			result = result.add( new BigInteger( Integer.toString( x[i] ) ).multiply( 
					new BigInteger( Integer.toString( y[length - i - 1] ) ) ) );
		}
//		if( length % 2 == 1 ) {
//			int ind = length / 2;
//			result += x[ind] * y[ind];
//		}
		return result;
	}
}
