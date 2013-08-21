import java.util.Scanner;

public class NextBinaryNum {
	public static void main( String args[] ) {
//		System.out.println( "Please input a positive integer to find the next smallest and the previous largest number with the same number of 1 bits:" );
//		Scanner in = new Scanner( System.in );
//		int num;
//		if( in.hasNextInt() ) {
//			num = in.nextInt();
//		}
		int num = 1;
//		int num = 0x5e;//Integer.parseInt( "1011110", 2 );
		printNextBinaryNum( num );
		
	}

	public static void printNextBinaryNum( int num ) {
		// Check the input validation
		if( num <= 0 ) { 
			System.out.println( "Invalid input: Please input positive integer!" );
			return ;
		}
		// Find the next smallest integer with the same number of 1s
		// Locate the leftmost zero
		if( num == ( ~0 >> 1 ) ) {
			System.out.printf( "No next smallest positive integer with the same number of 1 bit for %s\n", Integer.toBinaryString( num ) );
		}
		else {
			int ones = 0;
			int pos = 0;
			while( ( ( num >> pos ) & 1 ) == 0 ) {
				pos++;
			}
			while( pos < 31 ) {
				if( ( ( num >> pos ) & 1 ) == 1 ) {
					ones++;
				}
				else {
					break;
				}
				pos++;
			}
			int nextSmallest = ( num & ( ~0 << pos ) ) | ( 1 << pos );
			ones--;
			while( ones > 0 ) {
				nextSmallest |= ( 1 << ( ones - 1 ) );
				ones--;
			}
			System.out.printf( "The next smallest integer with the same number of 1 bit is %s\n", Integer.toBinaryString( nextSmallest ) );
		}

		

		if( num == 1 ) {
			System.out.printf( "No previous largest positive integer with the same number 1 bit for %s\n", Integer.toBinaryString( num ) );
		}
		else {
			//Find the next largest integer with the same number of 1s
			// Locate the rightmost one before zero
			// Remove appending ones
			int pos = 0;
			int appendingOnes = 0;
			while( ( ( num >> pos ) & 1 ) == 1 ) {
				pos++;
				appendingOnes++;
			}
			int zeros = 0;
			while( pos < 31 ) {
				if( ( ( num >> pos ) & 1 ) == 0 ) {
					zeros++;
				}
				else {
					break;
				}
				pos++;
			}
			int nextLargest = num & ~( ( 1 << ( pos + 1 ) ) - 1 );
			nextLargest |= 1 << ( pos - 1 );
			while( appendingOnes > 0 ) {
				nextLargest |= 1 << ( pos - appendingOnes - 1 );
				appendingOnes--;
			}

			System.out.printf( "The previous largest integer with the same number of 1 bit is %s\n", Integer.toBinaryString( nextLargest ) );
		}
		
	}
}
