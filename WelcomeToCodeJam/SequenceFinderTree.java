import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;


public class SequenceFinderTree {
	public final static boolean DEBUG = false;
	public final static int MOD_CONST = 10000;
//	public final static int MOD_CONST = Integer.MAX_VALUE;

	public final static String seq = "welcome to code jam";
	private HashMap<Character, ArrayList<Integer>> charToIdx;
	private String inputStr;
	private BigInteger count;
	
	public int getCount() {
		int sol = count.mod( BigInteger.valueOf( MOD_CONST ) ).intValue();
		return sol;
	}
	public SequenceFinderTree( String str ) {
		this.inputStr = str;
		this.count = BigInteger.valueOf(0);
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
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add( seq.length() );
//		charToIdx.put( '\0', list );
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
		int timeStep = 0;
		for( char cur : sequence ) {
			timeStep ++;
			if( cur != 'w' && heads.isEmpty() ) {
				continue;
			}
			
			if( cur == 'w'  ) {
				if( heads.isEmpty() || prev != cur ) {
					SequenceNode head = new SequenceNode( cur, 0, timeStep );
					heads.add( head );
				}
				else {
					SequenceNode head = heads.get( heads.size() - 1 );
//					head.count ++;		
					head.count = head.count.add(BigInteger.valueOf(1));
				}
				prev = cur;
				continue;
			}
			
			ArrayList<Integer> indices = null;
			if( charToIdx.containsKey( cur ) ) {
				indices = charToIdx.get( cur );
			}
			
			if( indices != null ) {
//				Collections.sort( indices, Collections.reverseOrder() );
				boolean flag = false;
				for( int index : indices ) {
					if( map.containsKey( index ) ) {
						if( prev == cur ) {
							ArrayList<SequenceNode> list = map.get( index );
							SequenceNode node = list.get( list.size() - 1 );
//							if( node.count == Integer.MAX_VALUE ) {
//								node.count %= 
//							}
							node.count = node.count.add(BigInteger.valueOf(1));
//							node.count ++;
//							break;
							flag = true;
						}
					}
					
					if( map.containsKey( index - 1 ) && !flag ) {
//						if( index == 10 || index == 15 ) {
//							System.out.println( "DEBUG!" );
//						}
						ArrayList<SequenceNode> list = map.get( index - 1 );
						SequenceNode childNode = new SequenceNode( cur, index, timeStep );
//						boolean flag = false;
						for( SequenceNode par : list ) {
//							if( par.timeStep < timeStep ) {
								if( par.child == null ) {
									par.child = new ArrayList<SequenceNode>();
									//par.child.add( childNode );
								}
								par.child.add( childNode );
//								flag = true;
//							}
						}
//						if( flag ) {
							ArrayList<SequenceNode> childList = null;
							if( map.containsKey( index ) ) {
								 childList = map.get( index );
								 childList.add( childNode );

							}
							else {
								childList = new ArrayList<SequenceNode>();
								childList.add( childNode );
								map.put( index, childList );
							}
//						}
						
//						prev = cur;
//						break;
					}
					
				}
			}
			prev = cur;
		}
		
		count = countWays( heads );
//		System.out.println( "DEBUG" );
	}
	
	public BigInteger countWays( ArrayList<SequenceNode> heads ) {
		if( heads == null ) { return BigInteger.valueOf(0); }
		if( heads.isEmpty() ) { return BigInteger.valueOf(0); }
		
		
		
		BigInteger partialCount = BigInteger.valueOf(0);
		for( SequenceNode node : heads ) {
//			if( node.value == 'j' ) {
//				System.out.println( "DEBUG!" );
//			}
//			if( node.value == ' ' && node.child.get(0).value == 'j' ) {
//				System.out.println( "DEBUG!" );
//			}
//			node.visited = true;
			if( node.level == 18 ) {
				partialCount = partialCount.add(node.count);
				node.visited = true;
				
			}
			else {
				if( !node.visited ) {
					BigInteger childCount = countWays( node.child );
					node.count = node.count.multiply( childCount );
//					node.count %=  MOD_CONST;
					partialCount = partialCount.add( node.count );
					node.visited = true;
				}
				else {
//					partialCount += node.count;
					partialCount = partialCount.add( node.count );
				}
				
			}
//			partialCount %= MOD_CONST;
		}
//		return partialCount % MOD_CONST;
		return partialCount;

	}
	
}
