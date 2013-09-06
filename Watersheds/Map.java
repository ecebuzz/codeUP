import java.util.ArrayList;

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
		// Keep the map lexicographically smallest
		map[0][0] = 'a';
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
		this.altitudeMap = altitude.clone() ;
		return true;

	}

	public void waterSheds() {

		for( int i = 0; i < height; i++ ) {
			for( int j = 0; j < width; j++ ) {
				Coordinate cur = new Coordinate( i, j );
				if( map[cur.x][cur.y] == '+' ) {
					// Not marked need backpropagation from basins
					Coordinate next = getNextShed( cur );
					if( next != null ) {
						map[cur.x][cur.y] = backpropagte( next );
					}
					else {
						// Find sink
						curRegion = (char) ( curRegion + 1 );
						map[cur.x][cur.y] = curRegion;
					}
				}
				else {
					// Already marked, propagate its mark to basins
					propagte( getNextShed( cur ), map[cur.x][cur.y] );

				}
			}
		}

	}

	public char backpropagte( Coordinate cur ) {
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
			map[cur.x][cur.y] = backpropagte( next ); 
		}
		return map[cur.x][cur.y];
	}

	public void propagte( Coordinate cur, char region ) {
		
		if( cur == null ) { return ; }
		map[cur.x][cur.y] = region;
		Coordinate next = getNextShed( cur );


		if( next != null ) {
			if( map[next.x][next.y] == '+' ) {
				propagte( next, region );
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

		return result;
	}

}	
