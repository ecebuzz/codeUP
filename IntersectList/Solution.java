import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution{
	
	public static void main(String[] args) {
		
		int[] listA = {4, 73, -5, 11};
		int[] listB = {-5, 73, -1, 9, 9, 4, 7};
		
		ArrayList<Integer> intersectList = 
				intersectList(listA, listB);
		
		if(intersectList != null) {
			System.out.println(Arrays.toString(intersectList.toArray()));
		}
	}
	

	
	public static ArrayList<Integer> intersectList(int[] listA, int[] listB) {
		/*
		 * Given two lists of integers, return an intersection
		 * list only contains unique integers and no duplicates 
		 * 
		 * Assumptions:
		 * 1) Two lists can duplicates and unsorted.
		 * 2) The longer list has length n and the shorter list 
		 * has length m.
		 * 
		 * Approach:
		 * 	1) Iterate through the shorter list, build a HashMap 
		 *     of its elements and set the default map value to
		 *     false and remove duplicates
		 *  2) Iterate through the longer list, look up the element
		 *     in HashMap. If the element is present and it has
		 *     not been inserted, insert the element to the result
		 *     list and set the map value to true. Otherwise, ignore
		 *     the element.
		 *     
		 * Complexity:
		 * 1) Time complexity: The time complexity depends on the hashing
		 *    technique used and the distribution of elements in the 
		 *    input lists. Here, we can have O(1) for HashMap search and
		 *    insert. Therefore, the total complexity is O(m+n), i.e. linear
		 *    time complexity.
		 * 2) Space complexity: The space complexity if O(m) for building
		 *    the HashMap.
		 *    
		 * Data Structure:
		 * 1) HashMap<Integer, Boolean>: mapping the shorter list element to
		 *    its visited status (default false, not visited). The reason for
		 *    using HashMap is because it has O(1) time complexity for 
		 *    insertion and search and it can been used for handling duplicates
		 *    in the origin two lists.
		 * 2) ArrayList<Integer>: holding the elements of the intersection of
		 *    the two lists. Since no ordering is required, it can dynamically 
		 *    insert elements with time complexity O(1).
		 */

		/*
		 * @param
		 * Input: two lists of integers 
		 *        int[] listA
		 *        int[] listB
		 * Output: intersection set of the input two lists
		 * 		  ArrayList<Integer>
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

		// Build a HashMap for shorter list
		int whichList = listA.length > listB.length ? 0 : 1;
		HashMap<Integer, Boolean> listSet = 
				buildListSet(whichList == 0 ? listA : listB);

		// HashMap failure case
		if(listSet == null) {
			return null;
		}

		// Get the intersection
		ArrayList<Integer> intersectList = 
				getIntersectList(listSet, whichList == 0 ? listB : listA);

		return intersectList;

	}

	public static HashMap<Integer, Boolean> buildListSet(int[] list) {
		/*
		 * Build a HashMap for shorter list and move duplicates
		 */
		HashMap<Integer, Boolean> listSet = new HashMap<Integer, Boolean>();
		for(int element : list) {
			if(!listSet.containsKey(element)) {
				// Add unique element
				listSet.put(element, false);
			}
		}
		return listSet;
	}

	public static ArrayList<Integer> getIntersectList(HashMap<Integer, Boolean> listSet, 
			int[] list) {
		/*
		 * Get the intersection set of two list
		 */
		ArrayList<Integer> intersectList = new ArrayList<Integer>();
		for(int element : list) {
			if(listSet.containsKey(element)) {
				// If it's in the intersection set
				if(!listSet.get(element)) {
					// If not present in the result list
					// Add the element into the result list
					intersectList.add(element);
					// Mark it as visited
					listSet.put(element, true);
				}				
			}

			if(intersectList.size() == listSet.size()) {
				// Early stop. If the intersection has all the elements
				// from the shorter list, no need to continue.
				break;
			}
		}
		return intersectList;
	}
} 
