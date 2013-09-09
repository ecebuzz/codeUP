import java.util.HashMap;
import java.util.ArrayList;
public class SequenceFinder {
	public final static int MOD_CONST = 10000;
	public final static String seq = "welcome to code jam";
	private HashMap<Character, ArrayList<Integer>> charToIdx;
	private String inputStr;
	private int count;
//	private ArrayList<int[]> completeSeq;

	public int getCount() {
		return count;
	}
	public SequenceFinder( String str ) {
		this.inputStr = str;
		this.count = 0;
		charToIdx = new HashMap<Character, ArrayList<Integer>>();

		for( int i = 0; i < seq.length(); i++ ) {
			char cur = seq.charAt( i );
			ArrayList<Integer> list = null;
			if( charToIdx.containsKey( cur ) ) {
				list = charToIdx.get( cur );
				list.add( i );
			}
			else {
				list = new ArrayList<Integer>();
				list.add( i );
				charToIdx.put( cur, list );
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add( seq.length() );
		charToIdx.put( '\0', list );
	}



	public void scanSequence() {

		if( inputStr == null ) { return ; }
		if( inputStr.isEmpty() ) { return ; }
		char[] sequence = inputStr.toLowerCase().toCharArray();
		HashMap<Integer, ArrayList<SequenceBuilder>> map = new HashMap<Integer, ArrayList<SequenceBuilder>>();


		for( char element : sequence ) {
//			if( element == 'm' ) {
//				System.out.println( "Stop!" );
//			}
			ArrayList<Integer> indices = null;
			if( charToIdx.containsKey( element ) ) {
				indices = charToIdx.get( element );
			}
			
			if( indices != null ) {
				for( int index : indices ) {
					if( map.containsKey( index ) ) {
						// Check whether cur is matched with any SequenceBuilder
						ArrayList<SequenceBuilder> list = map.get( index );
						if( !list.isEmpty() ) {
							SequenceBuilder builder = list.get( 0 );
							builder.count[builder.cur] ++;
							break;
						}


					}
					else if( map.containsKey( index - 1 ) ) {
						// Add to the next of existing SequenceBuilders
						ArrayList<SequenceBuilder> list = map.get( index - 1 );
						if( !list.isEmpty() ) {
							SequenceBuilder builder = list.remove( 0 );
							builder.size ++;
							builder.cur ++;
							builder.next ++;
							builder.count[builder.cur] ++;
							if( map.containsKey( builder.cur ) ) {
								ArrayList<SequenceBuilder> newlist = map.get( builder.cur );
								newlist.add( builder );
							}
							else {
								ArrayList<SequenceBuilder> newlist = new ArrayList<SequenceBuilder>();
								newlist.add( builder );
								map.put( builder.cur, newlist );
							}
							break;
						}

						
					}
					else if( index == 0 ){
						// Start new sequence builder with new 'w'
						ArrayList<SequenceBuilder> list = new ArrayList<SequenceBuilder>();
						SequenceBuilder builder = new SequenceBuilder( seq );
						builder.count[builder.cur] ++;
						list.add( builder );
						map.put( 0, list );
						break;
					}
				}
			}
			//EndFor
		}
		
		ArrayList<SequenceBuilder> list = null;
		if( map.containsKey( seq.length() - 1 ) ) {
			list = map.get( seq.length() - 1 );
			for( SequenceBuilder builder : list ) {
				int temp = 1;
				for( int num : builder.count ) {
					temp *= num;
				}
				count += temp;
				count = count % MOD_CONST;
			}
		}
		
		//End scanSequence
	}
}
