import java.util.HashMap;
import java.util.ArrayList;
public class SequenceFinder {
	public final static boolean DEBUG = false;
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
		ArrayList<SequenceBuilder> completeList = new ArrayList<SequenceBuilder>();
		int level = 0;

		for( char element : sequence ) {
			if( DEBUG ) {
				if( element == 'o' ) {
					System.out.println( "Stop!" );
				}
			}

			ArrayList<Integer> indices = null;
			if( charToIdx.containsKey( element ) ) {
				indices = charToIdx.get( element );
			}
			
			if( indices != null ) {
				level ++;
				boolean found = false;
				for( int i = indices.size() - 1; i >= 0; i-- ) {
					int index = indices.get(i);
					if( map.containsKey( index ) && !found ) {
						// Check whether cur is matched with any SequenceBuilder

							ArrayList<SequenceBuilder> list = map.get( index );
							if( !list.isEmpty() ) {
								
//								int last = 0;
//								ArrayList<SequenceBuilder> newList = new ArrayList<SequenceBuilder>();
								for( SequenceBuilder builder : list ) {
//									SequenceBuilder builder = list.get(last);
									if( level == builder.level + 1 ) {
										builder.count[builder.cur] ++;
										builder.level = level;
										found = true;
//										break;
									}
//									else {
//										SequenceBuilder newBuilder = builder.clone();
//										newBuilder.count[builder.cur] = 1;
//										newBuilder.level = level;
//										newList.add( newBuilder );
//									}
								}
//								for( SequenceBuilder builder : newList ) {
//									list.add( builder );
//								}
//								break;							
							}

					}
					
					if( map.containsKey( index - 1 ) && !found ) {
						// Add to the next of existing SequenceBuilders
						ArrayList<SequenceBuilder> list = map.get( index - 1 );
						if( !list.isEmpty() ) {
							for( SequenceBuilder validBuilder : list ) {
								SequenceBuilder builder = validBuilder.clone();
								builder.cur ++;
								builder.level = level;
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
						
							}
							break;
						
						}

						
					}
					
					if( index == 0 && !found ){
						// Start new sequence builder with new 'w'
						ArrayList<SequenceBuilder> list = new ArrayList<SequenceBuilder>();
						SequenceBuilder builder = new SequenceBuilder( seq );
						builder.count[builder.cur] ++;
						builder.level = level;
						list.add( builder );
						map.put( 0, list );
//						level ++;
						break;
					}
					
					if( found ) {
						break;
					}
					
				}
			}
			//EndFor

		}
		
		ArrayList<SequenceBuilder> list = null;
		if( map.containsKey( seq.length() - 1 ) ) {
			list = map.get( seq.length() - 1 );
//			for( SequenceBuilder builder : completeList ) {
			for( SequenceBuilder builder : list ) {

				int temp = 1;
				for( int num : builder.count ) {
					temp *= num;
					temp %= MOD_CONST;
				}
				count += temp;
				count = count % MOD_CONST;
			}
		}
		
		//End scanSequence
	}
}
