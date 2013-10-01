import java.util.ArrayList;
import java.util.Arrays;
public class QuipuReader {
	public static void main(String[] args) {
//		// Testcase 0
//		String[] knots = { "-XXXXXXX--XX-----XXXXX---",
//			  "---XX----XXX-----XXXX----",
//			    "-XXXXX---XXXXX--XXXXXXXX-" };
//		// Testcase 1 
//		String[] knots = { "XX---XXXX",
//				  "XXX-----X" };
//		// Testcase 2
		String[] knots = { "-XXX---XX----X",
				  "--X----X-XXXXX",
				    "-XX--XXXX---XX" };
//		// Testcase 3
//		String[] knots = { "-------X--------",
//				  "--XXX----XXXX---",
//				    "--------------XX" };
//		// Testcase 4
//		String[] knots = { "--XXX-XXXXXXXX----------XXXXXXXXX--XXXXXXXX-",
//				  "--XX----XXXX-----XXXXXX---XXX------XXXXXXXX-",
//				    "--------------------X----XXXXXXXX--XXXXXXXX-",
//				      "--XX-------X------XXXX----XXX-------XXXXXX--",
//				        "--XXX---XXXXX-------X------XX--------X------",
//					  "-XXXX--XXXXXXX-----------XXXXXXX----XXXXX---",
//					    "-----------X---XXXXXXXX----XX--------XXX----",
//					      "-----------X---XXXXXXXX----X----------------",
//					        "---X--XXXXXXXX--XXXXXXX---XXX---------------",
//						  "--XX---XXXXXXX--XXXXXXX----XX-------XXXXX---" };
//		// Testcase 5
//		String[] knots = {"X", "-"};
		System.out.println(Arrays.toString(readKnots(knots)));
	}
	public static int[] readKnots(String[] knots) {
		//TODO Exception handle
		//null or empty case
		//size is not bigger than 1 
		//all the strings are not the same length

		int[] numbers = new int[knots.length];

		ArrayList<Integer> starts = new ArrayList<Integer>();
		ArrayList<Integer> ends = new ArrayList<Integer>();

		// Get the starts and ends
		int index = 0;
		for(int i = 0; i < knots[0].length(); i++) {
			// Look for the start of the next seq
			if(index % 2 == 0) {
				if(hasKnot(knots, i)) {
					starts.add(i);
					index++;
				}
			}
			else {
				if(!hasKnot(knots, i)) {
					ends.add(i);
					index++;
				}
				else {
					
					if(knotEnd(knots, i)) {						
							ends.add(i);
							index++;
					}
				}
			}
		}

		if(starts.size() != ends.size()) {
			ends.add(knots[0].length() - 1);
		}

		for(int i = 0; i < numbers.length; i++) {
			StringBuilder number = new StringBuilder();
			for(int k = 0; k < starts.size(); k++) {
				number.append(extractNum(knots[i], 
						starts.get(k), ends.get(k)));
			}
			numbers[i] = Integer.parseInt(number.toString());
		}
		return numbers;
	}

	public static boolean knotEnd(String[] knots, int index) {
		if(index == knots[0].length() - 1) {
			return true;
		}
		for(int i = 0; i < knots.length; i++) {
			if(knots[i].charAt(index) == 'X' && knots[i].charAt(index + 1) == 'X') {
				return false;
			}
		}
		return true;
	}
	public static boolean hasKnot(String[] knots, int index) {
		for(int i = 0; i < knots.length; i++) {
			if(knots[i].charAt(index) == 'X') {
				return true;
			}
		}

		return false;
	}

	public static int extractNum(String knot, int start, int end) {
		int num = 0;
		for(int i = start; i <= end; i++) {
			if(knot.charAt(i) == 'X') {
				num++;
			}
		}

		return num;
	}
}
