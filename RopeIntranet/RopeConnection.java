import java.util.HashMap;
import java.util.Collections;
import java.util.HashSet;
import java.util.ArrayList;

public class RopeConnection {

	private int numOfLines;
	private int[][] ropePos;
	private int count;

	public RopeConnection( int size, int[][] pos ) {
		this.numOfLines = size;
		this.ropePos = pos.clone();
		this.count = 0;
	}

	public int computeIntersection() {
		HashSet<Double> midPointSet = new HashSet<Double>();
		ArrayList<Integer> grads = new ArrayList<Integer>();
		HashMap<Integer, ArrayList<Double>> map = new HashMap<Integer, ArrayList<Double>>();

		for( int i = 0; i < ropePos.length; i++ ) {
			int grad = ropePos[i][0] - ropePos[i][1];
			double midPoint = ( ropePos[i][0] + ropePos[i][1] ) / 2;
			if( map.containsKey( grad ) ) {
				ArrayList<Double> set = map.get( grad );
				set.add( midPoint );
			}
			else {
				grads.add( grad );
				ArrayList<Double> set = new ArrayList<Double>();
				set.add( midPoint );
				map.put( grad, set );
			}
		}

		Collections.sort( grads );

		for( int i = 0; i < grads.size(); i++ ) {
			ArrayList<Double> set = map.get( grads.get(i) );
			for( double midPoint1 : set ) {
				for( int j = i + 1; j < grads.size(); j++ ) {
					ArrayList<Double> list = map.get( grads.get(j) );
					for( double midPoint2 : list ) {
						if( !midPointSet.contains( midPoint1 ) || !midPointSet.contains( midPoint2 ) ) {
							count++;
							midPointSet.add( midPoint1 );
							midPointSet.add( midPoint2 );
						}
					}
				}
			}

		}

		return count;





	}


}
