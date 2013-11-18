import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static final int numOfCourseToBeCal = 5;
	static class TestResult {
		int studentID;
		//Date testDate;
		int testScore;
		public TestResult(int id, int score) {
			studentID = id;
			testScore = score;
		}
	}

	public static void main(String[] args) throws Exception {
		String inputFileName = "input.txt";
		File inputFile = new File(inputFileName);
		Scanner in = new Scanner(inputFile);
		
		// Read in the number of records
		int numOfRecords = -1;
		if(in.hasNextInt()) {
			numOfRecords = in.nextInt();
		}
		else {
			throw new Exception("Can't read in the number of records!");
		}
		if(numOfRecords < numOfCourseToBeCal) {
			throw new Exception("The number of records must be greater than"
					+ "the numOfCourseToBeCal!");
		}
		in.nextLine();
		List<TestResult> results = new ArrayList<TestResult>();
		
		for(int i = 0;i < numOfRecords; i++) {
			if(in.hasNextLine()) {
				String[] line = in.nextLine().split(" ");
				if(line.length == 2) {
					results.add(new TestResult(Integer.parseInt(line[0]),
							Integer.parseInt(line[1])));
				}
				else {
					throw new Exception("Can't read in the stduent id and score");
				}
			}
			else {
				throw new Exception("Don't match the number of records!");
			}
		}
		
		Map<Integer, Double> resultMap = getFinalScores(results);
		
		if(resultMap != null) {
			printMap(resultMap);
		}
	}
	
	public static void printMap(Map<Integer, Double> map) {
		for(int key : map.keySet()) {
			System.out.println("StudentID:" + key 
					+ "\t FinalScore:" + map.get(key));
		}
	}

	public static void addElementToMinHeap(int score, 
			PriorityQueue<Integer> minHeap) {
		// Exception check
		if(minHeap == null) { return ; }

		if(minHeap.size() < numOfCourseToBeCal) {
			minHeap.add(score);
		}
		else {
			if(minHeap.peek() < score) {
				minHeap.poll();
				minHeap.add(score);
			}
		}
	}

	public static double calFinalScore(PriorityQueue<Integer> scores) {
		// Exception check
		if(scores == null) { return -1; }

		if(scores.size() < numOfCourseToBeCal) { return -1; }

		// Calculate the final score
		double finalScore = 0.0;
		for(int score : scores) {
			finalScore += score;
		}

		return finalScore / numOfCourseToBeCal;

	}

	public static Map<Integer, Double> getFinalScores(List<TestResult> resultList) {
		/*
		 * Given a list of test results, return
		 * the final score for each student.
		 */
		// Null case
		if(resultList == null) { return null; }

		// The number of results is smaller than
		// the number of courses to be calculated
		// for final score
		if(resultList.size() < numOfCourseToBeCal) { return null; }

		// Build a hashmap for each student and his/her test score
		// min heap
		HashMap<Integer, PriorityQueue<Integer>> studentScores =
			new HashMap<Integer, PriorityQueue<Integer>>();

		for(TestResult result : resultList) {
			if(studentScores.containsKey(result.studentID)) {
				PriorityQueue scores = 
					studentScores.get(result.studentID);
				addElementToMinHeap(result.testScore, scores);
			}
			else {
				PriorityQueue scores = 
					new PriorityQueue<Integer>(numOfCourseToBeCal);
				scores.add(result.testScore);
				studentScores.put(result.studentID,
						scores);
			}
		}

		Map<Integer, Double> finalScores = new HashMap<Integer, Double>();

		for(int studentID : studentScores.keySet()) {
			PriorityQueue<Integer> scores =
				studentScores.get(studentID);
			double finalScore = calFinalScore(scores);
			finalScores.put(studentID, finalScore);
		}

		return finalScores;
	}

}
