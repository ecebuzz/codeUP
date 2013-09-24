import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class RopeIntranet {
	public static void main( String[] args ) throws Exception {

		String filePart = "test";
//		String filePart = "A-small-practice";
//		String filePart = "A-large-practice";


		String inputFilename = filePart + ".in";
		String outputFilename = filePart + ".out";

		File inputFile = new File( inputFilename );
		Scanner in = new Scanner( inputFile );

		int T = 0;

		if( in.hasNextInt() ) {
			T = in.nextInt();
		}
		else {
			throw new Exception( "Input format error: can not read in the number of test cases!" );
		}

		if( T < 1 || T > 15 ) {
			throw new Exception( "Input error: the number of test cases is not in the valid range!" );
		}	

		RopeConnection[] instances = new RopeConnection[T];

		for( int i = 0; i < T; i++ ) {
			int N = 0;
			if( in.hasNextInt() ) {
				N = in.nextInt();
			}
			else {
				throw new Exception( "Input format error: can not read in the number of wires!" );
			}

			in.nextLine();
			int[][] pos = new int[N][2];

			for( int k = 0; k < N; k++ ) {
				if( in.hasNextLine() ) {
					String[] line = in.nextLine().split( " " );
					if( line.length != 2 ) {
						throw new Exception( "Input format error: can not read in the wire positions!" );
					}
					pos[k][0] = Integer.parseInt( line[0] );
					pos[k][1] = Integer.parseInt( line[1] );
				}
			}

			instances[i] = new RopeConnection( N, pos );

		}

		in.close();
		
		PrintWriter out = new PrintWriter( outputFilename );
		for( int i = 0; i < T; i++ ) {
			int count = instances[i].computeIntersection();
			System.out.printf( "Case #%d: %d\n", i + 1, count );
			out.printf( "Case #%d: %d\n", i + 1, count );
		}
		out.close();
	}

}
