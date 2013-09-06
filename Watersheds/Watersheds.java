import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Watersheds {
	public final static int NUM_OF_MAPS_LIMIT = 100;
	public static void main( String[] args ) throws Exception {
		
		String FilenamePart = "test";
//		String FilenamePart = "B-small-practice";
//		String FilenamePart = "B-large-practice";


		String inputFilename = FilenamePart + ".in";
		String outputFilename = FilenamePart + ".out";

		File inputFile = new File( inputFilename );
		Scanner in = new Scanner( inputFile );


		int T = 0;
		if( in.hasNextInt() ) {
			T = in.nextInt();
		}
		else {
			throw new Exception( "Input format error: Can not read in the number of testcases!" );
		}

		if( T <= 0 || T > NUM_OF_MAPS_LIMIT ) {
			throw new Exception( "Input error: The number of maps is not in the valid range!" );
		}
		/*
	
//		int[][] altitudeMap = { { 3, 3, 4, 5, 6, 7, 8 }, { 4, 4, 5, 6, 7, 8, 9 } };
//		int[][] altitudeMap = { {9}, {8}, {7}, {6}, {5}, {9}, {4}, {3}};
//		int[][] altitudeMap = { { 9, 6, 3}, { 5, 9, 6 }, { 3, 5, 9 } };
//		int[][] altitudeMap = { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 7 } };
//		int[][] altitudeMap = { { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 }, { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 } };
//		int[][] altitudeMap = { { 1, 2, 3, 4, 5 }, { 2, 9, 3, 9, 6 }, { 3, 3, 0, 8, 7 }, { 4, 9, 8, 9, 8 }, { 5, 6, 7, 8, 9 } };
		Map instance = new Map( altitudeMap.length, altitudeMap[0].length );
		instance.buildMap( altitudeMap );

		instance.waterSheds();

		char[][] map = instance.getMap();

		for( int i = 0; i < altitudeMap.length; i++ ) {
			StringBuilder line = new StringBuilder();

			for( int j = 0; j < altitudeMap[0].length; j++ ) {
				line.append( Character.toString( map[i][j]) );	
				line.append( " " );
			}

			System.out.println( line.toString().trim() );
		}
		
		*/
		Map[] instances = new Map[T];
		for( int i = 0; i < T; i++ ) {
			int height = 0, width = 0;
			
			// Read in the height of map
			if( in.hasNextInt() ) {
				height = in.nextInt();
			}
			else {
				throw new Exception( "Input format error: Can not read in the height!" );
			}
			
			// Read in the width of map
			if( in.hasNextInt() ) {
				width = in.nextInt();
			}
			else {
				throw new Exception( "Input format error: Can not read in the width!");
			}
			
			// Check validation of height and width
			if( height <= 0 || width <= 0 ) {
				throw new Exception( "Input format error: The height and width of map can not be non-positive!" );
			}
			
			in.nextLine();
			int[][] altitudeMap = new int[height][width];
			
			for( int j = 0; j < height; j++ ) {
				if( in.hasNextLine() ) {
					String[] line = in.nextLine().split( " " );
					if( line.length == width ) {
						for( int k = 0;k < width; k++ ) {
							int altitude = Integer.parseInt( line[k] );
							if( altitude >= 0 ) {
								altitudeMap[j][k] = altitude;
							}
							else {
								throw new Exception( "Input format error: The altitude can not be negative!" );
							}
						}
					}
					else {
						throw new Exception( "Input format error: The map does not match with the width!" );
					}
				}
				else {
					throw new Exception( "Input format error: The map does not match with the height!" );
				}
			}
			instances[i] = new Map( height, width );
			if( !instances[i].buildMap( altitudeMap ) ) {
				throw new Exception( "Can not build the map!" );
			}
		}
		
		in.close();
		
		PrintWriter out = new PrintWriter( outputFilename );
		
		for( int i = 0; i < T; i++ ) {
			
			System.out.printf( "Case #%d:\n", i + 1 );
			out.printf( "Case #%d:\n", i + 1 );
			instances[i].waterSheds();

			char[][] map = instances[i].getMap();
			int[][] altitudeMap = instances[i].getAltitude();
			for( int j = 0; j < altitudeMap.length; j++ ) {
				StringBuilder line = new StringBuilder();

				for( int k = 0; k < altitudeMap[0].length; k++ ) {
					line.append( Character.toString( map[j][k]) );	
					line.append( " " );
				}

				System.out.println( line.toString().trim() );
				out.println(  line.toString().trim() );
			}
		}
		out.close();
		
		System.out.println( "Done!" );
		return ;
		
	}
}
