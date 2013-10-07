import java.util.HashSet;

public class AvoidRoads {
	public static void main(String[] args) {
//		int width = 6;
//		int height = 6;
//		String[] bad = {"0 0 0 1", "6 6 5 6"};
//		int width = 1;
//		int height = 1;
//		String[] bad = {};
//		int width = 2;
//		int height = 2;
//		String[] bad = {"0 0 1 0", "1 2 2 2", "1 1 2 1"};
		int width = 35;
		int height = 31;
		String[] bad = {};
		System.out.println(numWays(width, height, bad));
	}
	
	public enum Direction {
		UP, RIGHT;
	}

	public static long numWays(int width, int height, String[] bad) {
		// Exception check
		if(width < 1 || height < 1) { return -1; }
		
		long[][] wayCount = new long[height + 1][width + 1];
		// Initialize the count to be -1
		for(int i = 0; i < wayCount.length; i++) {
			for(int j = 0; j < wayCount[0].length; j++) {
				wayCount[i][j] = -1;
			}
		}

		HashSet<String> blocks = new HashSet<String>();
		for(String str : bad) {
			blocks.add(str);
		}

		wayCount[0][0] = countWays(wayCount, blocks, 0, 0, Direction.UP) +
			countWays(wayCount, blocks, 0, 0, Direction.RIGHT);
		return wayCount[0][0];
	}

	public static long countWays(long[][] wayCount, HashSet<String> blocks,
			int originX, int originY, Direction direction) {

		if(wayCount == null) { return -1; }
		if(wayCount.length == 0) { return -1; }
		int x = (direction == Direction.UP ? (originX + 1) : originX);
		int y = (direction == Direction.RIGHT ? (originY + 1) : originY);

		// Out of Boundary
		if( x < 0 || x >= wayCount.length 
				|| y < 0 || y >= wayCount[0].length) {
			return 0;
				}
		// Check blocks
		String from = "" + originX + " " + originY;
		String to = "" + x + " " + y;
		if(blocks.contains(from + " " + to) 
				|| blocks.contains(to + " " + from)) {
			return 0;
		}

		// Hit destination
		if( x == wayCount.length - 1 && y == wayCount[0].length - 1) {
			return 1;
		}


		// Check if the position has been visited
		if(wayCount[x][y] != -1) {
			return wayCount[x][y];
		}

		wayCount[x][y] = countWays(wayCount, blocks, x, y, Direction.UP) +
			countWays(wayCount, blocks, x, y, Direction.RIGHT);
		return wayCount[x][y];
	}
}
