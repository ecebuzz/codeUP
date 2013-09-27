import java.util.Arrays;

public class PaperFold {
	public static void main(String[] args) {
//		//Testcase 0
//		int[] paper = {8, 11};
//		int[] box = {6, 10};
//		//Testcase 1
//		int[] paper = {11, 17};
//		int[] box = {6, 4};
//		//Testcase 2
//		int[] paper = {17, 11};
//		int[] box = {5, 4};
//		//Testcase 3
//		int[] paper = {1000, 1000};
//		int[] box = {62, 63};
//		//Testcase 4
//		int[] paper = {100, 30};
//		int[] box = {60, 110};
		//Testcase 5
		int[] paper = {1895, 6416};
		int[] box = {401, 1000};
		
		System.out.println(numFolds(paper, box));
	}

	public static int numFolds(int[] paper, int[] box) {
		//TODO Exception Handle
		//paper or box is null/empty
		//paper and box do not have 2 dimension
		//paper and box contain non-positive integers or not fall in the
		//constraint range
		
		double[] foldPaper = new double[paper.length];
		for(int i = 0; i < paper.length; i++) {
			foldPaper[i] = (double) paper[i];
		}
		Arrays.sort(foldPaper);
		Arrays.sort(box);

		int count = 0;
		while(true) {
			// Check the folds is still no more than 8
			if(count > 8) {
				count = -1;
				break;
			}
			// Match the box
			if(foldPaper[0] <= box[0] && foldPaper[1] <= box[1]) {
				break;
			}
			count++;
			if(foldPaper[1] < box[1]) {
				//Switch
				double tmp = foldPaper[0];
				foldPaper[0] = foldPaper[1];
				foldPaper[1] = tmp;
			}
			foldPaper[1] = foldPaper[1] / 2;
			Arrays.sort(foldPaper);
		}
		return count;
	}
}
