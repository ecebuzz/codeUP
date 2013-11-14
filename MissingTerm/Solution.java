import java.io.*;
import java.util.Scanner;

public class Solution {
	static class Result {
		int missingTerm;
		boolean found;

		public Result() {
			missingTerm = 0; 
			found = false;
		}

	}
	public static void main(String[] args) throws Exception  {

		Scanner in = new Scanner(System.in);
		// Read in the size of the series
		int seriesSize = 0;

		if(in.hasNextInt()) {
			seriesSize = in.nextInt();
		}
		else {
			throw new Exception("Series size must be an integer!");
		}

		in.nextLine();

		// Initialize the series using integer array
		int[] series = new int[seriesSize];

		for(int i = 0; i < seriesSize; i++) {
			if(in.hasNextInt()) {
				series[i] = in.nextInt();
				if(series[i] > 10e6 || series[i] < -10e6) {
					throw new Exception("Integer is out of range!");
				}
			}
			else {
				throw new Exception("The series must only contain integers!");
			}
		}

		Result result = findMissingTerm(series);
        
		if(result.found) {
			System.out.println(result.missingTerm);
		}
		else {
			throw new Exception("No missing term is found!");
		}
		

	}

	public static Result findMissingTerm(int[] series) {
		// Exception Handle
		Result result = new Result();
		if(series == null) {
			return result;
		}

		if(series.length < 3) {
			return result;
		}

		// find the right difference
		int difference = Math.min(series[1] - series[0], series[2] - series[1]);

		for(int i = 0; i < series.length - 2; i++) {
			if(series[i+1] != series[i] + difference) {
				result.found = true;
				result.missingTerm = series[i] + difference;
				return result;
			}
		}

		return result;

	}
}
