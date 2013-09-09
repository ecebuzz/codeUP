import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;


public class SequenceFinderTree {
	public final static boolean DEBUG = false;
	public final static int MOD_CONST = 10000;
	public final static String seq = "welcome to code jam";
	private HashMap<Character, ArrayList<Integer>> charToIdx;
	private String inputStr;
	private int count;
	
	public SequenceFinderTree( String str ) {
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
		ArrayList<SequenceNode> heads = new ArrayList<SequenceNode>();
		HashMap<Integer, ArrayList<SequenceNode>> map = new HashMap<Integer, ArrayList<SequenceNode>>();
		map.put( 0, heads );
		
//		SequenceNode head = null;
		
		char prev = '0';
		for( char cur : sequence ) {
			if( cur != 'w' && heads.isEmpty() ) {
				break;
			}
			
			if( cur == 'w'  ) {
				if( heads.isEmpty() || prev != cur ) {
					SequenceNode head = new SequenceNode( cur, 0 );
					heads.add( head );
				}
				else {
					SequenceNode head = heads.get( heads.size() - 1 );
					head.count ++;					
				}
				prev = cur;
				break;
			}
			
			ArrayList<Integer> indices = null;
			if( charToIdx.containsKey( cur ) ) {
				indices = charToIdx.get( cur );
			}
			
			if( indices != null ) {
				Collections.sort( indices, Collections.reverseOrder() );
				for( int index : indices ) {
					if( map.containsKey( index ) ) {
						if( prev == cur ) {
							ArrayList<SequenceNode> list = map.get( index );
							SequenceNode node = list.get( list.size() - 1 );
							node.count ++;
							break;
						}
					}
					
					if( map.containsKey( index - 1 ) ) {
						ArrayList<SequenceNode> list = map.get( index - 1 );
						SequenceNode childNode = new SequenceNode( cur, index );
						for( SequenceNode par : list ) {
							if( par.child == null ) {
								par.child = new ArrayList<SequenceNode>();
								par.child.add( childNode );
							}
						}
						ArrayList<SequenceNode> childList = null;
						if( map.containsKey( index ) ) {
							 childList = map.get( index );

						}
						else {
							childList = new ArrayList<SequenceNode>();
						}
						childList.add( childNode );
					}
					
				}
			}
		}
	}
}
