import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SwapZero {
	public static void main( String args[] ) throws Exception {

		String fileNamePart = "test";
		Scanner srcIn, tgtIn;

		File srcFile = new File( fileNamePart + ".s" );
		srcIn = new Scanner( srcFile );

		File tgtFile = new File( fileNamePart + ".t" );
		tgtIn = new Scanner( tgtFile );

		
		String[] inSrc;
		
		if( srcIn.hasNextLine() ) {
			inSrc = srcIn.nextLine().split( " " );
		}
		else {
			throw new Exception( fileNamePart + ".src is empty!" );
		}
		srcIn.close();

		int[] src = toIntArr( inSrc );
		int[] srcPos = toPos( src );

		String[] inTgt;

		if( tgtIn.hasNextLine() ) {
			inTgt = tgtIn.nextLine().split( " " );
		}
		else {
			throw new Exception( fileNamePart + ".tgt is empty!" );
		}
		tgtIn.close();

		int[] tgt = toIntArr( inTgt );
		int[] dest = toPos( tgt );

		ArrayList<String> swaps = new ArrayList<String>();
		swapZero( src, tgt, srcPos, dest, swaps );
		for( int i = 0; i < swaps.size(); i++ ) {
			System.out.println( swaps.get(i) );
		}

	}
	
	public static int[] toIntArr( String[] ins ) {
		if( ins == null ) { return null; }
		int[] arr = new int[ins.length];
		for( int i = 0; i < arr.length; i++ ) {
			arr[i] = Integer.parseInt( ins[i] );
		}
		return arr;
	}

	public static int[] toPos( int[] src ) {
		if( src == null ) { return null; }
		int[] arr = new int[src.length];

		for( int i = 0; i < src.length; i++ ) {
			arr[src[i]] = i;
		}
		return arr;
	}	
	
	public static boolean isPermutation( int[] src, int[] tgt ) {
		if( src == null || tgt == null ) { return false; }
		if( src.length != tgt.length ) { return false; }
		int[] count = new int[src.length];
		for( int i = 0; i < src.length; i++ ) {
			count[src[i]] ++;
		}
		for( int i = 0; i < tgt.length; i++ ) {
			if( count[tgt[i]] < 1 ) {
				return false;
			}
			count[tgt[i]]--;
		}
		return true;
	}	

	public static void swapZero( int[] src, int[] tgt, int[] srcPos, int[] dest, ArrayList<String> swaps ) {
		if( !isPermutation( src, tgt ) ) { return; }

		int ind = srcPos[0];
		int count = 0;
		while( count < src.length ) {
			if( src[ind] == 0 ) {
				if( ind != dest[0] ) {
					int element = tgt[ind];
				    srcPos[0] = srcPos[element];
				    srcPos[element] = ind;	
				    swaps.add( "Swap 0 with " + Integer.toString( element ) );
				    src[ind] = element;
				    src[srcPos[0]] = 0;
				}	
			}
			else {
				if( src[ind] != tgt[ind] ) {
					int element = src[ind];
					// Swap with 0
					srcPos[src[ind]] = srcPos[0];
					srcPos[0] = ind;
					src[srcPos[element]] = element;
					src[ind] = 0;
					swaps.add( "Swap 0 with " + Integer.toString( element ) );

					element = tgt[ind];

					srcPos[0] = srcPos[element];
					srcPos[element] = ind;
					src[srcPos[0]] = 0;
					src[ind] = element;
					swaps.add( "Swap 0 with " + Integer.toString( element) );
				}
			}
			if( src[ind] == tgt[ind] ) {
				count++;
			}
			ind = ( ind + 1 ) % src.length;
		}

	}
	
}
