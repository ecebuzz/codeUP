import java.util.ArrayList;
import java.util.HashSet;

public class AlienMessage {
	private String msg;
	public ArrayList<String> validWords;
	public HashSet[] hashWord;
	private int length;
	
	public AlienMessage( String msg, int length ) {
		this.msg = msg;
		this.length = length;
		validWords = new ArrayList<String>();
		this.hashWord = new HashSet[length];
		for( int i = 0; i < length; i++ ) {
			hashWord[i] = new HashSet<String>();
		}
	}

	public ArrayList<String> getValidWords() {
		return validWords;
	}

	public void buildPosHash( HashSet[] posDict ) {
		if( msg.isEmpty() ) { return; }
		String str = msg;
		
		for( int i = 0; i < length; i++ ) {
			int subStrIdx = 0;
			if( str.charAt(0) == '(' ) {
				for( int k = 1; k < str.length(); k++ ) {
					if( str.charAt(k) == ')' ) { 
						subStrIdx = k;
						break;						
					}
					String charStr = Character.toString( str.charAt(k) );
					if( posDict[i].contains( charStr ) ) {
						hashWord[i].add( charStr );
					}
				}
			}
			else {
				String charStr = Character.toString( str.charAt(0) );
				if( posDict[i].contains( charStr ) ) {
					hashWord[i].add( charStr );
				}
				subStrIdx = 0;
			}
			str = str.substring( subStrIdx + 1 );
		}
	}
	public void decipher( HashSet<String> dict ) {
		if( msg == null ) { return; }
		
//		ArrayList<String> list = decode( msg, 0, posDict );
//		for( String element : list ) {
//			if( dict.contains( element ) ) {
//				validWords.add( element );
//			}
//		}
		
		for( String validWord : dict ) {
			boolean valid = true;
			for( int i = 0; i < length; i ++ ) {
				if( !hashWord[i].contains( Character.toString( validWord.charAt(i) ) ) ) {
					valid = false;
					break;
				}
			}
			if( valid ) {
				validWords.add( validWord );
			}
		}
	}
	
	
	// Not efficient!
	public ArrayList<String> decode( String str, int pos, HashSet[] posDict ) {
		if( str.isEmpty() ) { return new ArrayList<String>(); }
		ArrayList<String> curList = new ArrayList<String>();
		int subStrIdx = 0;

		if( str.charAt(0) == '(' ) {
			for( int i = 1; i < str.length(); i++ ) {
				if( str.charAt(i) == ')' ) {
					subStrIdx = i;
					break;
				}
				String charStr = Character.toString( str.charAt(i) );
				if( posDict[pos].contains( charStr ) ) {
					curList.add( charStr );
				}
			}
		}
		else {
			String charStr = Character.toString( str.charAt(0) );
			if( posDict[pos].contains( charStr ) ) {
				curList.add( charStr );
			}
			subStrIdx = 0;
		}

		ArrayList<String> subList = null;
		if( !curList.isEmpty() ) {
			subList = decode( str.substring( subStrIdx + 1 ), pos + 1, posDict );
		}
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
