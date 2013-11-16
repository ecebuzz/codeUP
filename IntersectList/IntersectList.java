import java.util.ArrayList;
import java.util.HashSet;

public class IntersectList {
	/*
	 * Given two lists of integers, return an intersection
	 * list only contains unique integers and no duplicates 
	 */
	
	public static ArrayList<Integer> intersectList(int[] listA, int[] listB) {
		/*
		 * @param
		 * Input: two lists of integers 
		 *        int[] listA
		 *        int[] listB
		 * Ouput: intersection set of the input two lists
		 */

		// Exception Handle
		// null case
		if(listA == null || listB == null) {
			return null;
		}

		// Empty list case
		if(listA.length == 0 || listB.length == 0) {
			return new ArrayList<Integer>();
		}

		// Build a HashSet for shorter list
		HashSet<Integer> listSet = new HashSet<Integer>();
		int whichList = listA.length > listB.length ? 0 : 1;
		buildListSet(listSet, whichList == 0 ? listA : listB);

		// HashSet failure case
		if(listSet == null) {
			return null;
		}

		// Get the intersection
		ArrayList<Integer> intersectList = new ArrayList<Integer>();
		getIntersectList(intersectList, listSet, whichList == 0 ? listB : listA);

		return intersectList;

	}

	public static void buildListSet(HashSet<Integer> listSet, int[] list) {
		/*
		 * Build a HashSet for shorter list
		 */

		for(int element : list) {
			listSet.add(element);
		}
	}

	public static void getIntersectList(ArrayList<Integer> intersectList,
		       HashSet<Integer> listSet, int[] list) {
		/*
		 * Get the intersection set of two list
		 */

		for(int element : list) {
			if(listSet.contains(element)) {
				// If it's in the intersection set
				intersectList.add(element);
			}
		}
	}
} 
