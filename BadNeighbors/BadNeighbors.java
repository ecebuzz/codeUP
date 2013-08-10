import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class BadNeighbors {
	public static final int NUM_OF_FILES = 5;
	public static void main( String args[] ) throws Exception {

		String inputFileNamePart = "test";

		for( int k = 1; k <= NUM_OF_FILES; k++ ) {
//		int k = 4;
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
	}

	public static int maxDonations( int[] funds ) {
		if( funds.length < 3 ) {
			return getMax( funds );
		}
		int[]  new_funds = funds.clone();
		int max1 = 0, max2 = 0;
		if( funds[0] > funds[funds.length - 1 ] ) {
			max1 = funds[0]; 
			new_funds[funds.length - 1] = 0;
		}
		else {
			max1 = 0;
			new_funds[0] = 0;
		}
		max2 = new_funds[1];
		max1 += new_funds[2];

		
		for( int i = 3; i < funds.length; i++ ) {
			if( i % 2 == 1 ) {
				max2 = Math.max( max1 - funds[i - 1], max2 ) + new_funds[i];
			}
			else {
				max1 = Math.max( max2 - funds[i - 1], max1 ) + new_funds[i];
			}
		}
		return Math.max( max1, max2 );

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
