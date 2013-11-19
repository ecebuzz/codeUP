import java.util.HashMap;
public class Solution {
	public static int findMostFrequencyNumber(int[] arr) {
		/*
		 * Given an integer array, find the most frequency
		 * number in the array
		 * 
		 * Assumption:
		 * 1) The array is made up of integers
		 * 2) The array can not be null or empty
		 * 
		 * Approach:
		 * Build a HashMap between the number and its frequency.
		 * Iterate through all the numbers and get the most
		 * frequency number.
		 * 
		 * Complexity:
		 * Time Complexity: Since HashMap has O(1) find and 
		 * add element operations, the time complexity is
		 * O(n), where n is the size of input array.
		 * Space Complexity: The space complexity is O(n) for
		 * holding the HashMap.
		 * 
		 * Additional Data Structure:
		 * HashMap<Integer, Integer>: mapping the number and
		 * its frequency. The reason for using HashMap is because
		 * its O(1) time complexity for finding and adding elements.
		 * 
		 */

		// Null case 
		if(arr == null) { return -1; }

		// Build a HashMap between the number and its frequency
		HashMap<Integer, Integer> numFreq = 
			new HashMap<Integer, Integer>();

		for(int num : arr) {
			if(numFreq.containsKey(num)) {
				// Increment the frequency
				numFreq.put(num,
						numFreq.get(num) + 1);
			}
			else {
				numFreq.put(num, 1);
			}
		}

		int maxFreq = Integer.MIN_VALUE;
		int mostFreqNum = -1;
		for(int key : numFreq.keySet()) {
			int freq = numFreq.get(key);
			if(freq > maxFreq) {
				// More frequency number
				maxFreq = freq;
				mostFreqNum = key;
			}
		}

		return mostFreqNum;

	}
}
