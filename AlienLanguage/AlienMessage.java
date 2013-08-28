import java.util.ArrayList;
import java.util.HashSet;

public class AlienMessage {
	private String msg;
	public ArrayList<String> validWords;
	private int length;
	
	public AlienMessage( String msg, int length ) {
		this.msg = msg;
		this.length = length;
		validWords = new ArrayList<String>();
	}

	public ArrayList<String> getValidWords() {
		return validWords;
	}

	public void decipher( HashSet<String> dict ) {
		if( msg == null ) { return; }
		ArrayList<String> list = decode( msg );
		for( String element : list ) {
			if( dict.contains( element ) ) {
				validWords.add( element );
			}
		}
	}

	public ArrayList<String> decode( String str ) {
		if( str.isEmpty() ) { return new ArrayList<String>(); }
		ArrayList<String> curList = new ArrayList<String>();
		int subStrIdx = 0;

		if( str.charAt(0) == '(' ) {
			for( int i = 1; i < str.length(); i++ ) {
				if( str.charAt(i) == ')' ) {
					subStrIdx = i;
					break;
				}
				curList.add( Character.toString( str.charAt(i) ) );
			}
		}
		else {
			for( int i = 0; i < str.length(); i++ ) {
				if( str.charAt(i) == '(' ) {
					subStrIdx = i;
					break;
				}
				curList.add( Character.toString( str.charAt(i) ) );
			}
		}
		if( curList.size() == str.length() ) {
			subStrIdx = str.length();
		}
		ArrayList<String> subList = decode( str.substring( subStrIdx + 1 ) );
		ArrayList<String> result = new ArrayList<String>();

		for( String element : curList ) {
			if( !subList.isEmpty() ) {
				for( String subStr : subList ) {
					result.add( element + subStr );
				}

			}
			else {
				result.add( element );
			}
		}

		return result;

	}
}
