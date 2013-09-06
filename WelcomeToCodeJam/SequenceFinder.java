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


			if( element  == 'w' ) {
				SequenceBuilder builder = new SequenceBuilder();
				builder.size ++;

				ArrayList<SequenceBuilder> list = null;
				int next = builder.next;

				if( map.containsKey( next ) ) {
					list = map.get( next );
					list.add( builder );
				}
				else {
					list = new ArrayList<SequenceBuilder>();
					list.add( builder );
					map.put( next, list );
				}
				continue;
			}

			
			ArrayList<Integer> indices = null;
			if( charToIdx.containsKey( element ) ) {
				indices = charToIdx.get( element );
			}
			if( element == 'e' ) {
//				if( indices.contains( seq.length() - 1 ) ) {
					System.out.println( "Stop!" );
//				}
			}
			if( indices != null ) {
				for( int index : indices ) {
					if( map.containsKey( index ) ) {
						ArrayList<SequenceBuilder> list = map.get( index );
						if( !list.isEmpty() ) {
							SequenceBuilder top = list.remove(0);
							top.size ++;
							top.cur ++;
							top.next ++;
							if( top.size == seq.length() ) {
								this.count ++;
								this.count = this.count % MOD_CONST;
								break;
							}
			
							int next = top.next;
			
							if( map.containsKey( next ) ) {
								list = map.get( next );
								list.add( top );
							}
							else {
								list = new ArrayList<SequenceBuilder>();
								list.add( top );
								map.put( next, list );
							}
							break;
						}
						
					}
				}
			}
		}
	}
}
