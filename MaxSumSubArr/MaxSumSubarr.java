import java.util.Arrays;
public class MaxSumSubarr {
	public static void main(String[] args) {
		
		// Find the range of the max sum subarray
		int[] arr = {5, 6, -4, 3};
//		int[] arr = {8, 9, -6, 0, 3, 9};
//		int[] arr = {-5, -6, -4, -3};
//		int[] arr = {6, -7, 5};
//		int[] arr = {6, -7, 5, 3};
		int[] sol = maxSumSubarr(arr);
		System.out.println(Arrays.toString(sol));
	}

	public static int[] maxSumSubarr(int[] arr) {
		// Exception check
		if(arr == null) { return null; }
		if(arr.length == 0) { return null; }

		int start = 0, end = 0, 
		    maxStart = 0, maxEnd = 0;
	        int sum = arr[0], maxSum = arr[0];

		for(int i = 1; i < arr.length; i++) {
			if(sum < 0) {
				// Abandon negative subarrays
				start = i;
				end = i;
				sum = 0;
			}
			else {
				// Shift the end
				end++;
			}

			sum += arr[i];

			if(sum > maxSum) {
				// Find larger sum
				maxStart = start;
				maxEnd = end;
				maxSum = sum;
			}
		}
		int[] sol = {maxStart, maxEnd};
		return sol;

	}

}
