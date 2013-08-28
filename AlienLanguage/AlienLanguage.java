import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.ArrayList;

public class AlienLanguage {
	public static void main( String args[] ) throws Exception {
		String fileNamePart = "test";
		String inputFileName = fileNamePart + ".in";
		String outputFileName = fileNamePart + ".out";
		File inputFile = new File( inputFileName );
		Scanner in = new Scanner( inputFile );
		int L = 0, D = 0, N = 0;	
		if( in.hasNextLine() ) {
			String[] line = in.nextLine().split( " " );
			if( line.length != 3 ) {
				throw new Exception( "Input File Format Error: L/D/N is not matched!" );
			}
			L = Integer.parseInt( line[0] );
			D = Integer.parseInt( line[1] );
			N = Integer.parseInt( line[2] );
		}
		HashSet<String> dict = new HashSet<String>();
		for( int i = 0; i < D; i++ ) {
			if( in.hasNextLine() ) {
				String line = in.nextLine();
				if( line.length() == L ) {
					dict.add( line );
				}
				else {
					throw new Exception( "Input File Error: The word length is not L!" );
				}
			}
			else {
				throw new Exception( "Input File Error: D is not matched with dictornary length!" );
			}
		}
		AlienMessage[] testcase = new AlienMessage[N];

		for( int i = 0; i < N; i++ ) {
			if( in.hasNextLine() ) {
				testcase[i] = new AlienMessage( in.nextLine(), L );
			}
			else {
				throw new Exception( "Input File Error: There is not enough test cases!" );
			}

		}
		in.close();
		

		for( int i = 0; i < N; i++ ) {
			testcase[i].decipher( dict );
		}

		for( int i = 0; i < N; i++ ) {
			ArrayList<String> result = testcase[i].getValidWords();
			System.out.printf( "Case #%d: %d\n", i, result.size() );
		}

	}
}
