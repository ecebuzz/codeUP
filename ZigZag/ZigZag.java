import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class ZigZag {
	public static final int NUM_OF_FILES = 6;
	public static void main( String args[] ) throws Exception {

		String inputFileNamePart = "test";

		for( int k = 1; k <= NUM_OF_FILES; k++ ) {
//		int k = 5;
			String inputFileName = inputFileNamePart + Integer.toString( k ) + ".in";
			File inputFile = new File( inputFileName );
			Scanner in = new Scanner( inputFile );
			// Read in a sequence of integer numbers from inputFile in one
			// line divide by ", "
			String[] numbers;
			if( in.hasNextLine() ) {
				numbers = in.nextLine().split(", ");
			}
			else {
				throw new Exception( "Input File Error: Can not read in the sequence!" );
			}
			int[] sequence = new int[numbers.length];
			for( int i = 0; i < sequence.length; i++ ) {
				sequence[i] = Integer.parseInt( numbers[i] );
			}
			
			System.out.printf( "The length %d of the longest ZigZag subsequence of %s\n", longestZigZag( sequence ), Arrays.toString( numbers )  );
		}
		return ; 


	}

	public static int longestZigZag( int[]  sequence ) {
		if( sequence.length < 2 ) { return sequence.length; }

		int max_length = 2;
		
		int length = 2;
		int sign = sequence[0] - sequence[1] ;
		for( int i = 2; i < sequence.length; i++ ) {
			int newsign = sequence[i - 1] - sequence[i];
			if( newsign * sign < 0 ) {
				length ++;
			}

			if( newsign != 0 ) {
				sign = newsign;
			}
			if( length > max_length ) {
				max_length = length;
			}
		}
		return max_length;
	}
}
