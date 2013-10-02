import java.util.ArrayList;
import java.util.Collections;

public class Boxing {
	public static void main(String[] args) {
		// Testcase 0
//		int[] a = {1, 2, 3, 4, 5, 6};
//		int[] b = {1, 2, 3, 4, 5, 6, 7};
//		int[] c = {1, 2, 3, 4, 5, 6};
//		int[] d = {0, 1, 2};
//		int[] e = {1, 2, 3, 4, 5, 6, 7, 8};
		// Testcase 1
//		int[] a = {100, 200, 300, 1200, 6000};
//		int[] b = { };
//		int[] c = {900, 902, 1200, 4000, 5000, 6001};
//		int[] d = {0, 2000, 6002};
//		int[] e = {1, 2, 3, 4, 5, 6, 7, 8};
		// Testcase 2
//		int[] a = {1, 2, 3, 4, 5, 6};
//		int[] b = {1, 2, 3, 4, 5, 6, 7};
//		int[] c = {1, 2, 3, 4, 5, 6};
//		int[] d = {0, 1, 2};
//		int[] e = {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println(maxCredit(a, b, c, d, e));
	}

	public static int maxCredit(int[] a, int[] b, int[] c,
			int[] d, int[] e) {

		// Put all the judgement into one arraylist
		ArrayList<int[]> records = new ArrayList<int[]>();
		records.add(a);
		records.add(b);
		records.add(c);
		records.add(d);
		records.add(e);
		// Store the leftmost valid index for each judgement
		int[] indices = new int[5];

		int start = 0, end = 0;
		int count = 0;
		ArrayList<Integer> validList = popList(indices, start, records);
		while(!validList.isEmpty()) {
			if(validList.size() < 3) {
				break;
			}
			Collections.sort(validList);
			// At least 3 judge should agree it's valid punch
			end = validList.get(2);
			if(end - start <= 1000) {
				// valid punch
				count++;
				start = end + 1;
			}
			else {
				// move the start time
				start = end - 1000 + 1;
			}
			validList = popList(indices, start, records);

		}

		return count;
	}

	public static ArrayList<Integer> popList(int[] indices, int start,
			ArrayList<int[]> records) {
		ArrayList<Integer> validList = new ArrayList<Integer>();

		for(int i = 0; i < indices.length; i++) {
			if(indices[i] >  records.get(i).length - 1) {
				continue;
			}

			int[] judge = records.get(i);
			while(indices[i] < judge.length) {
			    if(judge[indices[i]] >= start) {
				    break;
			    }
        	        	indices[i]++;
			}

			if(indices[i] < judge.length) {
				validList.add(judge[indices[i]]);
			}
		}

		return validList;
	}
}
