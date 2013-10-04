import java.util.Scanner;

public class Solution {
	class Node implements Comparable {
		public int x;
		public int y;
		public int dist;

		public static int comparedTo(Object obj) throws Exception {
			//TODO Exception Handle
			if(obj.getClass() != this.getClass()) {
				throw Exception("Class Type Error!");
			}

			Node other = (Node) obj;
			if(other.dist > obj.dist) { return -1; }
			if(other.dist < obj.dist) { return 1; }
			return 0;
		}

		public static int equals(Node other) {
			if(other == null) { return false; }

			if(other.x == this.x && other.y == this.y) {
				return true;
			}
			return false;
		}

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = 0, M = 0;
	}
}
