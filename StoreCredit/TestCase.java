import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Arrays;
public class TestCase {
	public final static int p_max = 1000;
	public int credit;
	public int num_of_items;
	public Hashtable<Integer, LinkedList<Integer>> item_list = new Hashtable<Integer, LinkedList<Integer>>();
	public int[] item_prices;

	public TestCase(int c, int ni, int[] prices) {
		credit = c;
		num_of_items = ni;
		for(int i = 0; i < num_of_items; i++) {
			if(item_list.containsKey(prices[i])) {
				item_list.get(prices[i]).add(i);
			}
			else{
				LinkedList<Integer> newitem = new LinkedList<Integer>();
				newitem.add(i);
				item_list.put(prices[i], newitem);
			}
		}
		item_prices = prices.clone();
		Arrays.sort(item_prices);
	}

	public int[] searchItems() {
		int max = item_prices[item_prices.length-1];
		// Exception check
		if(credit > (item_list.get(max).size() + 1) * max) {
			return null;
		}
		int[] indices = new int[2];
		for(int i = num_of_items - 1; i >= 0; i--) {
			if(item_prices[i] < credit && item_prices[i] * 2 >= credit) {
				LinkedList<Integer> list = item_list.get(item_prices[i]);
				indices[0] = list.removeFirst();
				if(list.size() == 0){
					item_list.remove(item_prices[i]);
				}
				else {
					item_list.put(item_prices[i], list);
				}

				int remainder = credit-item_prices[i];
				if(item_list.containsKey(remainder)){
					LinkedList<Integer> list1 = item_list.get(remainder);
					indices[1] = list1.remove();
					return indices;
				}
			}
			if(item_prices[i] * 2 < credit) {
				//Early stop
				return null;
			}
		}
		return null;

	}
}


