import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class WelcomeToCodeJam {
	public static void main( String[] args ) throws Exception {
		/* Welcome To Code Jam
		 * Input sequence 
		 * Output count the occurence of "welcome to code jam" in the sequence with increasing indices
		 */
		// Test Code
//		String inputStr = "wweellccoommee to code qps jam";
//		String inputStr = "elcomew elcome to code jam";
//		String inputStr = "welcome to codejam";
//		String inputStr = "welcome to code jamjamjamjam";
//		String inputStr = "wwwlelcocmeme otoo  codde jjam";
		String inputStr = "So you've registered. We sent you a welcoming email, to welcome you to code jam. But it's possible that you still don't feel welcomed to code jam. That's why we decided to name a problem \"welcome to code jam.\" After solving this problem, we hope that you'll feel very welcome. Very welcome, that is, to code jam.";
//		SequenceFinder instance = new SequenceFinder( inputStr );
		SequenceFinderTree instance = new SequenceFinderTree( inputStr );
		instance.scanSequence();
		System.out.printf( "%d", instance.getCount() );
		/*

//		String filePart = "test";
//		String filePart = "C-small-practice";
		String filePart = "C-large-practice";
		String inputFilename = filePart + ".in";
		String outputFilename = filePart + ".out";
		
		File inputFile = new File( inputFilename );
		if( !inputFile.exists() ) {
			throw new FileNotFoundException( "Can not open the input file!" );
		}
		

		Scanner in = new Scanner( inputFile );

		
		// Read in the number of test cases
		int N = 0;
		if( in.hasNextInt() ) {
			N = in.nextInt();
		}
		else {
			throw new Exception( "Input file format error: Can not read in the number of test cases!" );
		}
		in.nextLine();
		
		// Read in and initialize each test case
//		SequenceFinder[] instances = new SequenceFinder[N];
		SequenceFinderTree[] instances = new SequenceFinderTree[N];
		PrintWriter indexFile = new PrintWriter( filePart + ".indexed" );
		for( int i = 0; i < N; i++ ) {
			if( in.hasNextLine() ) {
				String str = in.nextLine();
				instances[i] = new SequenceFinderTree( str );
				indexFile.printf( "Case #%d: %s\n", i + 1, str );
			}
			else  {
				throw new Exception( "Input file format error: The number of lines does not match with the number of test cases!" );
			}
		}
		in.close();
		indexFile.close();
		

		
		
		// Scan each sequence finding the occurence of target subseq
		PrintWriter out = new PrintWriter( outputFilename );
		for( int i = 0; i < N; i++ ) {
			instances[i].scanSequence();
			System.out.printf( "Case #%d: %04d\n", i + 1, instances[i].getCount() );
			out.printf( "Case #%d: %04d\n", i + 1, instances[i].getCount() );
		}
		out.close();
		
		System.out.println( "Done!" );

*/

	}
}
