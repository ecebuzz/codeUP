import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;


public class ReverseWords {
	public final static int l_min = 1;
	public final static int l_max = 25;
	public static void main(String[] args) throws Exception {

		/*
		 * Input Format:
		 * The first line of input gives the number of test cases N;
		 * For each test case there will be a line of letters and space
		 * characters indicating a list of space seperated words. Spaces
		 * will not appear at the start or the end of the line.
		 */
	
//		String inputFileName = "test.in";
//		String inputFileName = "B-small-practice.in";
		String inputFileName = "B-large-practice.in";
		String outputFileName = inputFileName.substring(0, inputFileName.lastIndexOf('.')) + ".out";
		File inputFile = new File(inputFileName);
		Scanner in = new Scanner(inputFile);
		PrintWriter out = new PrintWriter(outputFileName);

		int num_of_cases = 0;
		if(in.hasNextLine()) {
			num_of_cases = Integer.parseInt(in.nextLine());
		}
		else {
			throw new Exception("Input Error: no match of number of testcases!");
		}
		TestCase[] testcases = new TestCase[num_of_cases];
		for(int i = 0; i < num_of_cases; i++) {
			String line;
			if(in.hasNextLine()) {
				line = in.nextLine();
			}
			else {
				throw new Exception("Input Error: no enough line match the number of test cases!");
			}
			testcases[i] = new TestCase(line);
		}
		in.close();

		for(int i = 0; i < num_of_cases; i++) {
			String line = testcases[i].printString();
			System.out.printf("Case #%d: %s\n", i + 1, line);
			out.printf("Case #%d: %s\n", i + 1, line);
 			
		}
		out.close();
		return;

	}
}
