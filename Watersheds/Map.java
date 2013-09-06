import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Set;

public class Map {
	/*
	 * Map Class
	 * @param
	 * char[][] map: to mark the character of each coordinate
	 * int[][] altitudeMap: to record the altitude of each coordinate
	 * int height: the height of the map
	 * int width: the width of the map
	 * Hash<Integer, ArrayList<Coordinate>> list: map the altitude to a
	 * linked list of sorted coordinates
	 */

	private char[][] map;
	private int[][] altitudeMap;
	private int height;
	private int width;
	private HashMap<Integer, ArrayList<Coordinate>> list;
	private char curRegion;

	public Map( int height, int width ) {
		map = new char[height][width];
		this.height = height;
		this.width = width;
		for( int i = 0; i < height; i++ ) {
			for( int j = 0; j < width; j++ ) {
				map[i][j] = '+';
			}
		}
		map[0][0] = 'a';
		list = new HashMap<Integer, ArrayList<Coordinate>>();
		curRegion = 'a';
	}

	public char[][] getMap() {
		return map;
	}
	
	public int[][] getAltitude() {
		return altitudeMap;
	}

	public boolean buildMap( int[][] altitude ) {
		if( altitude == null ) { return false; }
		if( altitude.length != height || altitude[0].length != width ) {
			return false;
		}

		for( int i = 0; i < height; i++ ) {
			for( int j = 0; j < width; j++ ) {
				if( list.containsKey( altitude[i][j] ) ) {
					list.get( altitude[i][j] ).add( new Coordinate( i, j ) );
				}
				else {
					ArrayList<Coordinate> listOfCoordinates = new ArrayList<Coordinate>();
					listOfCoordinates.add( new Coordinate( i, j ) );
					list.put( altitude[i][j], listOfCoordinates );
				}
			}
		}

		for( int key : list.keySet() ) {
			ArrayList<Coordinate> listOfCoordinates = list.get( key );
			Collections.sort( listOfCoordinates );
		}
		this.altitudeMap = altitude.clone() ;
		return true;

	}

	public void waterSheds() {
		ArrayList<Integer> altitude = new ArrayList( list.keySet() );
//		int[] altitude = keys.toArray( new int[keys.size()] );
		Collections.sort( altitude, Collections.reverseOrder() );

		for( int element : altitude ) {
			ArrayList<Coordinate> listOfCoordinates = list.get( element );
			while( !listOfCoordinates.isEmpty() ) {
				Coordinate cur = listOfCoordinates.remove( 0 );
				if( map[cur.x][cur.y] == '+' ) {
					// Not marked need backpropagation from basins
					Coordinate next = getNextShed( cur );
					if( next != null ) {
						map[cur.x][cur.y] = backpropogate( next );
					}
					else {
						// Find sink
						curRegion = (char) ( curRegion + 1 );
						map[cur.x][cur.y] = curRegion;
					}
				}
				else {
					// Already marked, propagate its mark to basins
					Coordinate next = getNextShed( cur );
					if( next != null ) {
						propogate( next, map[cur.x][cur.y] );
					}
				}
			}
		}

	}

	public char backpropogate( Coordinate cur ) {
		if( cur == null ) { return '+'; }

		if( map[cur.x][cur.y] != '+' ) {
			return map[cur.x][cur.y];
		}

		Coordinate next = getNextShed( cur );

		if( next == null ) { 
			// Find sink
			curRegion = (char) ( curRegion + 1 );
			map[cur.x][cur.y] = curRegion; 			
		}
		else { 
			map[cur.x][cur.y] = backpropogate( next ); 
		}
		return map[cur.x][cur.y];
	}

	public void propogate( Coordinate cur, char region ) {
		
		map[cur.x][cur.y] = region;
		Coordinate next = getNextShed( cur );


		if( next != null ) {
			if( map[next.x][next.y] == '+' ) {
				propogate( next, region );
			}
		}

		return ;
	}

	public Coordinate getNextShed( Coordinate cur ) {

		if( cur == null ) { return null; }
		ArrayList<Coordinate> validCords = new ArrayList<Coordinate>();

		// North
		if( cur.x - 1 >= 0 ) {
			if( altitudeMap[cur.x-1][cur.y] < altitudeMap[cur.x][cur.y] ) {
				validCords.add( new Coordinate( cur.x - 1, cur.y ) );
			}
		}

		// West
		if( cur.y - 1 >= 0 ) {
			if( altitudeMap[cur.x][cur.y - 1] < altitudeMap[cur.x][cur.y] ) {
				validCords.add( new Coordinate( cur.x, cur.y - 1 ) );
			}
		}

		// East 
		if( cur.y + 1 < width ) {
			if( altitudeMap[cur.x][cur.y + 1] < altitudeMap[cur.x][cur.y] ) {
					validCords.add( new Coordinate( cur.x, cur.y + 1) );
			}
		}
				
		// South
		if( cur.x + 1 < height ) {
				if( altitudeMap[cur.x + 1][cur.y] < altitudeMap[cur.x][cur.y] ) {
				validCords.add( new Coordinate( cur.x + 1, cur.y ) );
			}
		}

		

		if( validCords.isEmpty() ) { return null; }

		Coordinate result = validCords.get(0);
		int minAltitude = altitudeMap[result.x][result.y];
		for( int i = 1; i < validCords.size(); i++ ) {
			Coordinate temp = validCords.get(i);
			if( altitudeMap[temp.x][temp.y] < minAltitude ) {
				result = temp;
				minAltitude = altitudeMap[temp.x][temp.y];
			}
		}
//		for( Coordinate element : validCords ) {
//			if( altitudeMap[element.x][element.y] < minAltitude ) {
//				result = element;
//				minAltitude = altitudeMap[element.x][element.y];			}
//		}

		return result;
	}

}	
