import java.util.Scanner;

public class Solution {
	class Node implements Comparable {
		public int x;
		public int y;
		public int dist;
		public Node parent;

		public Node() {
			x = -1;
			y = -1;
			dist = Integer.MAX_VALUE;
			parent = null
		}

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

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int N = 0, M = 0;
		if(in.hasNextInt()) {
			N = in.nextInt();
		}

		if(in.hasNextInt()) {
			M = in.nextInt();
		}

		if( N < 1 || M < 1 ) {
			throw Exception("Map size can not be less than 1!");
		}

		in.nextLine();

		Node farm = new Node();
		Node pond = new Node();

		String[] line = null;
		// Read in the coordinate of the pond
		if(in.hasNextLine()) {
			line = in.nextLint().split(" ");
			if(line.length != 2) {
				throw Exception("Coordinate input format error!");
			}

			pond.x = Integer.parseInt(line[0]);
			pond.y = Integer.parseInt(line[1]);
		}
		// Read in the coordinate of the farm
		if(in.hasNextLine()) {
			line = in.nextLint().split(" ");
			if(line.length != 2) {
				throw Exception("Coordinate input format error!");
			}

			farm.x = Integer.parseInt(line[0]);
			farm.y = Integer.parseInt(line[1]);
		}

		int[][] evaluationMap = new int[N][M];

		String evaluation = null;
		for(int i = 0; i < N; i++) {
			if(in.hasNextLine()) {
				evaluation = in.nextLine();
			}

			if(evaluaton.length() != M) {
				throw Exception("Map size does not match!");
			}


			for(int j = 0; j < M; j++) {
				evaluationMap[i][j] = Character.getNumericValue(evaluation.charAt(j));	
			}

			System.out.println(computeCost(pond, farm, evaluationMap));

		}

		public static int computeCost(Node pond, Node farm, int[][] evaluationMap) {
			//Check
			if(pond.equals(farm)) { return -1; }
			if(evaluationMap == null) { return -1; }

			pond.dist = 0;
			LinkedList<Node> list = new LinkedList<Node>();
			list.add(pond);


			while(!list.isEmpty()) {
				Node cur = list.remove(0);
				ArrayList<Node> neighbors = getNeighbor()
			}



		}

		public static ArrayList<Node> getNeighbor(Node cur, evaluationMap)


		public static void initializeList(LinkedList<Node> list, 
				Node pond, int[][] evaluationMap) {
			for(int i = 0; i < evaluationMap.length; i++) {
				for(int j = 0; j < evaluationMap[0].length; j++) {
					Node node = new Node();
					node.x = i;
					node.y = j;
					if(pond.equals(node)) {
						list.add(pond);
						continue;
					}
					list.add(node);
				}
			}
		}



	}
}
