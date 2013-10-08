import java.util.Scanner;
import java.util.ArrayList;

public class Solution {
	// Nested Position class
	static class Position {
		public int x;
		public int y;
		
		public Position() {
			this.x = -1;
			this.y = -1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// Scanner for read in from the STDIN
		Scanner in = new Scanner(System.in);

		// Record the starting place
		Position start = new Position();
		// Indicate whether the start has been read or not
		boolean readStart = false;
		// 2D ArrayList to hold the map info
		ArrayList<ArrayList<Character>> map = new ArrayList<ArrayList<Character>>(); 

		// Read in the map info
		int lineIdx = 0;
		int length = 0;
		while(in.hasNextLine()) {
			String line = in.nextLine();
			if(line.length() == 0) {
				// End of read
				break;
			}
			line = line.toLowerCase();
			ArrayList<Character> mapLine = new ArrayList<Character>();

			for(int i = 0; i < line.length(); i++) {
				char element = line.charAt(i);
				if(element == '@') {
					if(!readStart) {
						start.x = lineIdx;
						start.y = i;
						readStart = true;
					}
					else {
						throw new Exception("Multiple start position!");
					}
				}
				mapLine.add(element);
			}

			if(lineIdx == 0) {
				length = line.length();
			}

			if(length != line.length()) {
				throw new Exception("The length of each line does not match!");
			}
			map.add(mapLine);
			lineIdx ++;
		}
		in.close();
		if(readStart == false) {
			throw new Exception("No start point is read in!");
		}

		// Compute the distance
		System.out.println(computeDist(start, to2DArray(map)));

	}

	// Transform 2D ArrayList to 2D array
	public static char[][] to2DArray(ArrayList<ArrayList<Character>> map) {
		// Exception check
		if(map == null) { return null; }
		if(map.isEmpty()) { return null; }
		if(map.get(0).isEmpty()) { return null; }

		int x = map.size();
		int y = map.get(0).size();
		char[][] arrMap = new char[x][y];

		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				ArrayList<Character> list = map.get(i);
				arrMap[i][j] = list.get(j);
			}
		}

		return arrMap;
	}

	
	public enum Direction {
		E, W, N, S;
       	};

	public static int computeDist(Position start, 
			char[][]  map) {
		// Exception check
		if(start == null) { return -1; }
		if(map == null) { return -1; }

		Position cur = start;
		// Indicate the direction of next step
		Direction direction = Direction.E;
		// Indicate whether node has been visted or not
		boolean[][] visited = new boolean[map.length][map[0].length];


		int count = 1;
		Position next = getNextStep(map, cur, direction);


		while(!hitWall(next, map)) {
			if(visited[next.x][next.y]) {
				// Infinite loop
				return -1;
			}
			cur = next;
			if(isPrism(map[next.x][next.y])) {
				visited[next.x][next.y] = true;
			}
			direction = getDirection(map, cur, direction);
			next = getNextStep(map, cur, direction);
			count ++;
		}

		return count;
	}
	
	public static boolean isPrism(char character) {
		if(character == '>' || character == '^' 
				|| character == 'v' || character == '<') {
			return true;
		}
		return false;
	}

	public static boolean hitWall(Position next, char[][] map) {
		if(next.x < 0 || next.x >= map.length ||
				next.y < 0 || next.y >= map[0].length) {
			return true;
				}	
		return false;

	}

	public static Direction getDirection(char[][] map, Position cur, Direction direction) {
		char direct = map[cur.x][cur.y];

		if(direct == '>') {
			return Direction.E;
		}
		if(direct == '<') {
			return Direction.W;
		}
		if(direct == '^') {
			return Direction.N;
		}
		if(direct == 'v') {
			return Direction.S;
		}
		// No change
		return direction;
	}

	public static Position getNextStep(char[][] map, Position cur, 
			Direction direction) {
		
		Position next = new Position();
		
		

		if(direction == Direction.E) {
			// Move east
			next.x = cur.x;
			next.y = cur.y + 1;
		}
		else if(direction == Direction.W) {
			// Move west
			next.x = cur.x;
			next.y = cur.y - 1;
		}
		else if(direction == Direction.N) {
			// Move north
			next.x = cur.x - 1;
			next.y = cur.y;
		}
		else {
			// Move south
			next.x = cur.x + 1;
			next.y = cur.y;
		}

		return next;

		
	}


}

