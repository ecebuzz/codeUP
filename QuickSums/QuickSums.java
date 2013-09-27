
public class QuickSums {
	public static void main(String[] args) {
		String numbers = "99999";
		int sum = 45;
		system.out.println(minSums(numbers, sum));
	}

	public static int minSums(String numbers, int sum) {
		//Exception handle
		//TODO
		if(sum < 0) { return -1; }
		if(numbers == null) { return -1; }
		if(numbers.length() == 0) { return -1; }

		HashMap<String, Integer> partialRes = new HashMap<String, Integer>();
		return computeSums(numbers, sum, partialRes);
	}

	public static int computeSums(String numbers, int sum, HashMap<String, Integer> partialRes ) {

		for(int i = 0; i < numbers.length(); i++) {
			int num = Integer.parseInt(numbers.substring(0, i));
			// Trailing zeors
			if(num == 0 && i != numbers.length() - 1) {
				continue;
			}
			if(i == number.length() - 1) {
				if(num == sum) {
					return 1;
				}
				else {
					return -1;
				}
			}
			if(num <= sum) {
				String left = numbers.substring(i + 1);
				if(partialRes.contains(left)) {
					return partialRes.get(left);
				}
				else {
					
					int depth = computeSums(left, sum - num, partialRes) 
					partialRes.put(left, depth);
				}

					
				}
			}
		}
	}
}
