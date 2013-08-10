import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class BadNeighbors {
	public static final int NUM_OF_FILES = 5;
	public static void main( String args[] ) throws Exception {

		String inputFileNamePart = "test";

//		for( int k = 1; k <= NUM_OF_FILES; k++ ) {
		int k = 3;
			String inputFileName = inputFileNamePart + Integer.toString( k ) + ".in";
			File inputFile = new File( inputFileName );
			Scanner in = new Scanner( inputFile );
			String[] neighbor_funds;

			if( in.hasNextLine() ) {
				neighbor_funds = in.nextLine().split( ", " );

			}
			else {
				throw new Exception( "Input File Error: Can not read in the neighbor fund!" );
			}
			in.close();
			int[] funds = new int[neighbor_funds.length];
			for( int i = 0; i < funds.length; i++ ) {
				funds[i] = Integer.parseInt( neighbor_funds[i] );
			}
			System.out.printf( "The maximum funds is %d\n", maxDonations( funds ) );

		}
//	}

	public static int maxDonations( int[] funds ) {
		if( funds.length < 3 ) {
			return getMax( funds );
		}
		int[] sums1 = new int[funds.length];
		int[] sums2 = new int[funds.length];
		for( int i = 0; i < 2; i++ ) {
			sums1[i] = funds[i];
			sums2[i+1] = funds[i+1];
		}
		for( int i = 2; i < funds.length; i++ ) {
			sums1[i] = sums1[i-2] + funds[i];
			sums2[i] = sums2[i-2] + funds[i];
		}
		sums1[sums1.length-1] = sums2[sums2.length-1];
		return getMax( sums1 );
//		for( int i = 0; i < 2; i++ ) {
//			for( int shift = 2; shift < 4; shift ++ ) {
//				int sum = funds[i];
//				int ind = i + shift;
//				while( ind < ( funds.length - 1 + i) ) {
//					sum += funds[ind];
//					ind += shift;
//				}
//				if( sum > max_sum ) {
//					max_sum = sum;
//				}
//			}
//		}
		
//		return max_sum;
	}

	public static int getMax( int[] funds ) {
		int max = funds[0];

		for( int i = 1; i < funds.length; i++ ) {
			if( funds[i] > max ) {
				max = funds[i];
			}
		}
		return max;
			
	}
}
