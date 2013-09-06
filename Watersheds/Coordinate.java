
public class Coordinate implements Comparable {
	public int x;
	public int y;

	public Coordinate( int x, int y ) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo( Object obj ) {
		Coordinate other = ( Coordinate ) obj;

		if( other.x > x ) {
			return -1;
		}
		else if( other.x < x ) {
			return 1;
		}

		if( other.y > y ) {
			return -1;
		}
		else if( other.y < y ) {
			return 1;
		}
		


		return 0;
	}
	
}
