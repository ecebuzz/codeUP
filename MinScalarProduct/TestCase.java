import java.util.Arrays;

public class TestCase {
	private int[] x;
	private int[] y;

	public TestCase( int size, String[] a, String[] b ) {
		if( size < 1 ) { return; }
		x = new int[size];
		y = new int[size];
		for( int i = 0; i < size; i++ ) {
//			x[i] = (int) a.charAt(i);
//			y[i] = (int) b.charAt(i);
			x[i] = Integer.parseInt( a[i] );
			y[i] = Integer.parseInt( b[i] );
		}
	}
	
//	public void printArrays() {
//		System.out.println( "Arrays are:" );
//		System.out.println( x );
//		System.out.println( y );
//	}
	
	public double computeMinProduct() {
		
		if( x.length != y.length || x.length == 0 || y.length == 0 ) {
			return Integer.MIN_VALUE;
		}
		
		Arrays.sort(x);
		Arrays.sort(y);
		double scale = Math.max( x[x.length - 1], y[y.length - 1] );
		double result = 0.;
		int length = x.length;
		for( int i = 0; i < length; i++ ) {
			result += ( x[i] / scale ) * ( y[length - i - 1] / scale );
		}
		return ( result * scale * scale );
	}
}
