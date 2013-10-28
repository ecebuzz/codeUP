import java.util.Set;
import java.util.HashMap;

public class GroceryBagger {
	public static void main(String[] args) {
		// Example 0
//		int strength = 2;
//	    String[] itemType = {"DAIRY",
//		 "DAIRY",
//		 "PRODUCE",
//		 "PRODUCE",
//		 "PRODUCE",
//		 "MEAT"};
	        
	    // Example 1
	    int strength = 3;
	    String[] itemType =	{"DAIRY",
	    			 "DAIRY",
	    			 "PRODUCE",
	    			 "PRODUCE",
	    			 "PRODUCE",
	    			 "MEAT"};

		int numOfBags = minimumBags(strength, itemType);
		System.out.println(numOfBags);
	}

	public static int minimumBags(int strength, String[] itemType) {
		// Exception handle
		if(strength < 1) {
			return -1;
		}

		if(itemType == null) {
			return -1;
		}
		
		if(itemType.length == 0) {
			return 0;
		}

		int numOfBags = 0;
		HashMap<String, Integer> typeSize = 
			new HashMap<String, Integer>();

		// Count the number of each type and hash them
		for(String item : itemType) {
			String itemLowerCased = item.toLowerCase();
			if(typeSize.containsKey(itemLowerCased)) {
				typeSize.put(itemLowerCased, 
						typeSize.get(itemLowerCased) + 1);
			}
			else {
				typeSize.put(itemLowerCased, 1);
			}
		}

		// Assign bags according to the strength and type
		Set<String> keySet = typeSize.keySet();
		for(String key : keySet) {
			int numOfItems= typeSize.get(key);
			numOfBags += Math.ceil(numOfItems * 1.0 / strength);
		}

		return numOfBags;
	}
}
