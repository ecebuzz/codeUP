import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class StoreCredit{

	public static int c_max = 1000;
	public static int c_min = 5;
	public static int p_max = 1000;
	public static int p_min = 1;
	public static void main(String[] args) throws Exception {
		/*
		 * First line input number of test cases;
		 * Then input each test case:
		 * 	1) the total credit you have C_i
		 * 	2) the number of items available in the store
		 * 	3) price for each item in that store
		 */
		// Input and output file name and open
//		String inputFileName = "A-small-practice.in";
//		String inputFileName = "test.in";
		String inputFileName = "A-large-practice.in";

		File inputFile = new File(inputFileName); 
		Scanner in = new Scanner(inputFile);
		String outputFileName = inputFileName.substring(0, inputFileName.lastIndexOf('.')) + ".out";
		PrintWriter out = new PrintWriter(outputFileName);

		System.out.printf("Input file: %s.\n", inputFileName);
		System.out.printf("Output file: %s.\n", outputFileName);
		// Read in numer of cases
		int num_of_cases;
		if( in.hasNextInt() ) {
			num_of_cases = in.nextInt();
		}
		else {
			throw new Exception("Input Error of Number of Cases: Not an Integer!");
		}
		
		TestCase[] test_cases = new TestCase[num_of_cases];

		for(int i = 0; i < num_of_cases; i++) {
			// Read in total credit
			int credit, num_of_items;
			if(in.hasNextInt()) {
				credit = in.nextInt();
			}
			else {
				throw new IOException("Input Error of Credits: Not an Integer!");
			}
			if(credit < c_min || credit > c_max) {
				throw new Exception("Input Error of Credits: Not in the Range!");
			}
			if(in.hasNextInt()) {
				num_of_items = in.nextInt();
			}
			else {
				throw new IOException("Input Error of Num of Items: Not an Integer!");
			}
			/*
			 * Read in prices for each item by iterate through each price
			 */
			int[] prices = new int[num_of_items];
			for(int j = 0; j < num_of_items; j++) {
				if(in.hasNextInt()) {
					prices[j] = in.nextInt();
				}
				else {
					throw new IOException("Input Error: No Item Prices!");
				}
			}

			test_cases[i] = new TestCase(credit, num_of_items, prices);
		}
		in.close();
		for(int i = 0; i < num_of_cases; i++) {
			int[] sol = test_cases[i].searchItems();
			Arrays.sort(sol);

			if(sol != null) {
				out.printf("Case #%d: %d %d\n", i + 1, sol[0] + 1, sol[1] + 1);
				System.out.printf("Case #%d: %d %d\n", i + 1, sol[0] + 1, sol[1] + 1);
			}
		}
		out.close();
		return;
	}
}
