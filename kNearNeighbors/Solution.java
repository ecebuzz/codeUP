import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
public class Solution {

	static class Point implements Comparable {
		public double x;
		public double y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}

		public double distanceFromOrigin() {
			return x * x + y * y;
		}

		public String toString() {
			return "[" + this.x +
					" " + this.y + "]";
		}
		@Override
		public int compareTo(Object otherObj) {
			Point other = (Point) otherObj;

			double dist1 = this.distanceFromOrigin();
			double dist2 = other.distanceFromOrigin();

			if(dist1 < dist2) {
				return -1;
			}
			else if(dist1 > dist2) {
				return 1;
			}

			return 0;
		}
		

	}
	
	public static void main(String[] args) throws Exception {
		String inputFileName = "input.txt";
		File inputFile = new File(inputFileName);
		Scanner in = new Scanner(inputFile);
		
		// First determine how many points
		int numOfPoints = -1;
		if(in.hasNextInt()) {
			numOfPoints = in.nextInt();
		}
		else {
			throw new Exception("Can't read in the number of points!");
		}
		
		if(numOfPoints < 1) {
			throw new Exception("The number of points must be an integer that greater than 0!");
		}
		in.nextLine();
		
		Point[] points = new Point[numOfPoints];
		
		for(int i = 0; i < numOfPoints; i++) {
			// Read in two coordinates x, y
			if(in.hasNextLine()) {
				String[] line = in.nextLine().split(" ");
				if(line.length == 2) {
					points[i] = new Point(Double.parseDouble(line[0]),
						Double.parseDouble(line[1]));
				}
				else {
					throw new Exception("The coordinate format is invalid!");
				}
			}
			else {
				throw new Exception("Input file format: Can't read in the required number of points!");
			}
			
		}
		
		Point[] kNearestPoints = getKClosestToOrigin(points, 2);
		
		if(kNearestPoints != null) {
			for(Point point : kNearestPoints) {
				System.out.println(point.toString());
			}
		}
		else {
			throw new Exception("Can't find the k nearest points to the origin!");
		}
	}

	public static Point[] getKClosestToOrigin(Point[] points, int k) {
		/*
		 * Given an array of points, find the 
		 * k nearest points to the origin, using
		 * add/multiply/subtract/divide
		 */
		// Exception Handle
		if(points == null) { return null; }
		if(points.length == 0 ) { return new Point[0]; }
		if(points.length <= k ) { return points; }

		// Build a max heap with size of k
		PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(k, 
				Collections.reverseOrder());

		for(Point point : points) {
			if(maxHeap.size() < k) {
				// Initialize the max heap with the k points
				maxHeap.add(point);
			}
			else {
				Point maxPoint = maxHeap.peek();
				if(maxPoint.compareTo(point) > 0) {
					// If get smaller point than the max
					// has been seen, remove the max point
					//  and add the new point
					maxHeap.poll();
					maxHeap.add(point);
				}
			}
		}

		Point[] kClosestPoints = new Point[k];
		maxHeap.toArray(kClosestPoints);

		return kClosestPoints;

	}
}

