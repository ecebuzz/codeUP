
public class Solution {
	public static int findMostFrequencyNumber(int[] arr) {
		/*
		 * Given an integer array, find the most frequency
		 * number in the array
		 */

		// Null case 
		if(arr == null) { return -1; }

		// Build a HashMap between the num and its frequency
		HashMap<Integer, Integer> numFreq = 
			new HashMap<Integer, Integer>();

		for(int num : arr) {
			if(numFreq.containsKey(num)) {
				numFreq.put(num,
						numFreq.get(num) + 1);
			}
			else {
				numFreq.put(num, 1);
			}
		}

		int maxFreq = Integer.MIN_VALUE;
		int mostFreqNum;
		for(int key : numFreq.keySet()) {
			int freq = numFreq.get(key);
			if(freq > maxFreq) {
				maxFreq = freq;
				mostFreqNum = key;
			}
		}

		return mostFreqNum;

	}
}
