import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
//import java.util.BigInteger;

public class Solution {
	static class Racer implements Comparable {
		// Racer class
		public int racerId;
		public long startTime;
		public long endTime;
		public int score;
		
		public int compareTo(Object obj) {
			if(obj.getClass() != this.getClass()) {
				return -1;
			}
			Racer other = (Racer) obj;
			if(other.score == this.score) {
				if(other.racerId > this.racerId) {
					return -1;
				}
				if(other.racerId < this.racerId) {
					return 1;
				}
				return 0;
			}
			if(other.score > this.score) {
				return -1;
			}
			if(other.score < this.score) {
				return 1;
			}
			return 0;
		}


	}

	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);

		int N = 0;
		if(in.hasNextInt()) {
			// Read in the number of racers
			N = in.nextInt();
		}

		if(N < 1 && N > 70000) {
			throw new Exception("Number of racers is not valid!");
		}
		in.nextLine();

		Racer[] racers = new Racer[N];
		for(int i = 0; i < N; i++) {
			if(in.hasNextLine()) {
				String[] line = in.nextLine().split(" ");
				if(line.length != 3) {
					throw new Exception("Input format error!");
				}

				racers[i] = new Racer();
				
				racers[i].racerId = Integer.parseInt(line[0]);
				racers[i].startTime = Long.parseLong(line[1]);
				racers[i].endTime = Long.parseLong(line[2]);
			}
		}
		in.close();


		computeScore(racers);
		// Sort the racers with regard to socre and racerId in asending order
		Arrays.sort(racers);
		for(Racer racer : racers) {
			System.out.printf("%d %d\n", racer.racerId, racer.score);
		}
	}

	public static void computeScore(Racer[] racers) {
		// Exception check

		if(racers == null) { return; }
		if(racers.length == 0) { return; }

		HashMap<Long, ArrayList<Integer>> startTimeToIdx = 
			new HashMap<Long, ArrayList<Integer>>();
		HashMap<Long, ArrayList<Integer>> endTimeToIdx = 
			new HashMap<Long, ArrayList<Integer>>();
		long[] startTimes = new long[racers.length];
		long[] endTimes = new long[racers.length];

		// Initialize the two time array and the corresponding HashMap
		initializeTimes(racers, startTimes, startTimeToIdx,
				endTimes, endTimeToIdx);
		// Sort both times in ascending order
		Arrays.sort(startTimes);
		Arrays.sort(endTimes);
		HashMap<Integer, HashSet<Integer>> startMap = 
				new HashMap<Integer, HashSet<Integer>>();
		HashMap<Integer, HashSet<Integer>> endMap = 
				new HashMap<Integer, HashSet<Integer>>();
		HashSet<Integer> restRacers = new HashSet<Integer>();
		for(int i = 0; i < racers.length; i++) {
			restRacers.add(i);
		}
		HashSet<Integer> rest = (HashSet<Integer>) restRacers.clone();
		for(int i = 0; i < startTimes.length; i++) {
			for(int idx : startTimeToIdx.get(startTimes[i])) {
				// Get racers start after the current racer
				rest.remove(idx);
				startMap.put(idx, rest);
			}
			rest = (HashSet<Integer>) rest.clone();
		}
		
		rest = (HashSet<Integer>) restRacers.clone();
		for(int i = endTimes.length - 1; i >= 0; i--) {
			for(int idx : endTimeToIdx.get(endTimes[i])) {
				// Get racers start after the current racer
				rest.remove(idx);
				endMap.put(idx, rest);
			}
			rest = (HashSet<Integer>) rest.clone();
		}
		
		// Compute the score
		for(int i = 0; i < racers.length; i++) {
			HashSet<Integer> set1 = startMap.get(i);
			HashSet<Integer> set2 = endMap.get(i);
			int score = 0;
			for(int element : set2) {
				if(set1.contains(element)) {
					score ++;
				}
			}
 			racers[i].score = score;
		}

			
	}
	

	public static void initializeTimes (Racer[] racers, long[] startTimes,
			HashMap<Long, ArrayList<Integer>> startTimeToIdx, 
			long[] endTimes, HashMap<Long, ArrayList<Integer>> endTimeToIdx) {
		for(int i = 0; i < racers.length; i++) {
			startTimes[i] = racers[i].startTime;
			if(startTimeToIdx.containsKey(startTimes[i])) {
				ArrayList<Integer> list = startTimeToIdx.get(startTimes[i]);
				list.add(i);
			}
			else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				startTimeToIdx.put(startTimes[i], list);
			}
			endTimes[i] = racers[i].endTime;
			if(endTimeToIdx.containsKey(endTimes[i])) {
				ArrayList<Integer> list = endTimeToIdx.get(endTimes[i]);
				list.add(i);
			}
			else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(i);
				endTimeToIdx.put(endTimes[i], list);
			}

		}
	}
}
