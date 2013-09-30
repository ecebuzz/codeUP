import java.util.HashMap;

public class QuickSums {
	public static void main(String[] args) {
//		//Testcase 0
//		String numbers = "99999";
//		int sum = 45;
//		//Testcase 1
//		String numbers = "1110";
//		int sum = 3;
//		//Testcase 2
//		String numbers = "0123456789";
//		int sum = 45;
//		//Testcase 3
//		String numbers = "99999";
//		int sum = 100;
//		//Testcase 4
//		String numbers = "382834";
//		int sum = 100;
		//Testcase 5
		String numbers = "9230560001";
		int sum = 71;
		System.out.println(minSums(numbers, sum));
	}

	public static int minSums(String numbers, int sum) {
		//Exception handle
		//TODO
		if(sum < 0) { return -1; }
		if(numbers == null) { return -1; }
		if(numbers.length() == 0) { return -1; }

		HashMap<String, HashMap<Integer, Integer>> partialRes = new HashMap<String, HashMap<Integer, Integer>>();
		computeSums(numbers, sum, partialRes);
		if(partialRes.containsKey(numbers)) {
			HashMap<Integer, Integer> map = partialRes.get(numbers);
			if(map.containsKey(sum)) {
				return map.get(sum);
			}
		}
		return -1;
	}

	public static void computeSums(String numbers, int sum, HashMap<String, HashMap<Integer, Integer>> partialRes) {

//		if(partialRes.containsKey(numbers)) {
//			HashMap<Integer, Integer> map = partialRes.get(numbers);
//			if(map.containsKey(sum)) {
//				return ;
//			}
//		}
		// sum to depth map
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < numbers.length(); i++) {
			int num = Integer.parseInt(numbers.substring(0, i + 1));
			// Trailing zeors
			if(num == 0 && i != numbers.length() - 1) {
				continue;
			}
			if(i == numbers.length() - 1) {
				if(num == sum && !map.containsKey(sum)) {
					map.put(sum, 0);
				}
				else {
					map.put(num, 0);
				}
				break;
			}
			if(num <= sum) {
				String left = numbers.substring(i + 1);
				if(!partialRes.containsKey(left)) {
					computeSums(left, sum - num, partialRes); 
					
				}
				int curDepth = -1;
				
				HashMap<Integer, Integer> sumToDepth =	partialRes.get(left);
				if(sumToDepth.containsKey(sum - num)) {
					map.put(sum, sumToDepth.get(sum - num) + 1);
				}
				else {
					for(int element : sumToDepth.keySet()) {
						if(!map.containsKey(element+num)) {
							map.put(element + num, sumToDepth.get(element) + 1);
						}
					}
				}
				

			}
			else {
				break;
			}
		}
		partialRes.put(numbers, map);

		
	}
}
