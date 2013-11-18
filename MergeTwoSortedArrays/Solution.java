
public class Solution {
	public static void mergeTwoSortedArrays(int[] A, int m,
			int B[], int n) {
		/*
		 * Given two sorted arrays A and B, merge B into A 
		 * as one sorted array (ascending order)
		 * 
		 * Assumption: A has extra space to hold the elements
		 * from B.
		 */
		// Exception handle
		if(A == null || B == null) { return ; }

		if(m < 0 || n < 0) { return ; }

		if(A.length < m + n) { return ; }

		int indexA = m - 1;
		int indexB = n - 1;

		while(indexA >= 0 &&
				indexB >= 0) {
			if(A[indexA] > B[indexB]) {
				A[indexA + indexB + 1] = 
					A[indexA];
				indexA --;
			}
			else {
				A[indexA + indexB + 1] = 
					B[indexB];
				indexB --;
			}
		}

		while(indexB >= 0) {
			A[indexB] = B[indexB];
			indexB --;
		}

		
	}
}
