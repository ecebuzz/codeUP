import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MinScalarProduct {
	public static void main( String args[] ) throws Exception {
	/*Problem
	You are given two vectors v1=(x1,x2,...,xn) and v2=(y1,y2,...,yn). The scalar product of these vectors is a single number, calculated as x1y1+x2y2+...+xnyn.
	Suppose you are allowed to permute the coordinates of each vector as you wish. 
	Choose two permutations such that the scalar product of your two new vectors is the smallest possible, and output that minimum scalar product.

	Input

	The first line of the input file contains integer number T - the number of test cases. 
	For each test case, the first line contains integer number n. The next two lines contain n integers each, giving the coordinates of v1 and v2 respectively.
	Output

	For each test case, output a line: Case # X: Y
	*/
//		String inputFileName = "A-small-practice.in";
//		String inputFileName = "test.in";
		String inputFileName = "A-large-practice.in";
		String outputFileName = inputFileName.substring( 0, inputFileName.lastIndexOf( '.' ) ) + ".out";
		File inputFile = new File( inputFileName );
		Scanner in = new Scanner( inputFile );
		PrintWriter out = new PrintWriter( outputFileName );
		int num_of_case = 0;
		if( in.hasNextLine() ) {
			num_of_case = Integer.parseInt( in.nextLine() );	
		}
		
		if( num_of_case < 1 ) {
			throw new Exception( "Input File Error: Num of case can not be < 1!" );
		}
		
		TestCase[] testcases = new TestCase[num_of_case];
		
		for( int i = 0; i < num_of_case; i++ ) {
			int size = 0;
			String x;
			String y;
			if( in.hasNextLine() ) {
				size = Integer.parseInt( in.nextLine() );
			}
			x = in.nextLine();
			y = in.nextLine();
			if( size < 1 ) {
				throw new Exception( "Input File Error: Vector size can not be < 1!" );
			}
			if( x != null && y != null ) {
				testcases[i] = new TestCase( size, x.split( " " ), y.split( " " ) );
			}
			else {
				throw new Exception( "Input File Error: No enough line for two vectors!" );
			}

		}

		in.close();
		System.out.println( Long.MAX_VALUE );
		System.out.println( Long.MIN_VALUE );
		for( int i = 0; i < num_of_case; i++ ) {
			double result = testcases[i].computeMinProduct();
			if( result != Integer.MIN_VALUE ) {
//				testcases[i].printArrays();
				System.out.printf( "Case #%d: %d\n", i + 1, (long)result );
				out.printf( "Case #%d: %d\n", i + 1, (long)result );

			}
			else {
				throw new Exception( "Can not compute min scalar product!" );
			}
		}
		out.close();	
	}
}
