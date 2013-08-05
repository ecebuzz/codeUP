import java.util.Hashtable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class T9Spelling {
	/*
	 Problem
	 
	 The Latin alphabet contains 26 characters and telephones only have ten digits on the keypad. 
	 We would like to make it easier to write a message to your friend using a sequence of keypresses to indicate the desired characters.
	 The letters are mapped onto the digits as shown below. To insert the character B for instance, the program would press 22.
	 In order to insert two characters in sequence from the same key, the user must pause before pressing the key a second time.
	 The space character ' ' should be printed to indicate a pause. For example, 2 2 indicates AA whereas 22 indicates B.
	 */
	public static void main(String args[]) throws Exception {
		/* Input:
		 * The first line of input gives the number of cases, N. N test
		 * cases follow. 
		 * Each case is a line of text formated. Each message will
		 * consist of only lowercase a-z and space characters ' '.
		 * Pressing zero emits a space.
		 * Output:
		 * For each testcase, output one line containing "Case #x:"
		 * followed by the message translated into the sequence of
		 * keypresses.
		 */
//		String inputFileName = "test.in";
//		String inputFileName = "C-small-practice.in";
		String inputFileName = "C-large-practice.in";


		String outputFileName = inputFileName.substring(0, inputFileName.lastIndexOf('.')) + ".out";
		File inputFile = new File(inputFileName);
		Scanner in = new Scanner(inputFile);
		PrintWriter out = new PrintWriter(outputFileName);

		int num_of_cases;
		if(in.hasNextLine()) {
			num_of_cases = Integer.parseInt(in.nextLine());
		}
		else {
			throw new Exception("Input File Error: no Integer number of cases!");
		}

		Hashtable<Character, String> codeBook = new Hashtable<Character, String>();
		if(!buildCodeBook(codeBook)) {
			throw new Exception("Fail to build up the code book!");
		}

		TestCase[] testcases = new TestCase[num_of_cases];
		for(int i = 0; i < num_of_cases; i++) {
			if(in.hasNextLine()) {
				testcases[i] = new TestCase(in.nextLine());
			}
			else {
				throw new Exception("Input File Error: not enough line for test cases!");
			}

		}
		in.close();

		for(int i = 0; i < num_of_cases; i++) {
			testcases[i].encode(codeBook);
			System.out.printf("Case #%d: %s\n", i + 1, testcases[i].printString());
			out.printf("Case #%d: %s\n", i + 1, testcases[i].printString());

		}
		out.close();
		return;
	
	}

	public static boolean buildCodeBook(Hashtable<Character, String> codeBook) {
		/* Build up a code book from a-z characters to press number
		 * Input:
		 * Hashtable<Character, String> codeBook
		 * Output:
		 * If the codebook is successfully built, return true;
		 * else return false;
		 */
		char ch;
		for(int i = 0; i < 26; i++) {
			ch = (char)((int)'a' + i);
			StringBuilder code = new StringBuilder();
			if(ch < 'p') {
				int number = i / 3 + 2;
				int multiple = i % 3 + 1;
				for(int j = 0; j < multiple; j++) {
					code.append(Integer.toString(number));
				}

			}
			else if( ch >= 'p' && ch < 't') {
				int number = 7;
				int multiple = (int) ch - 'p';
				multiple += 1;
				for(int j = 0; j < multiple; j++) {
					code.append(Integer.toString(number));
				}
			}
			else if(ch >= 't' && ch < 'w') {
				int number = 8;
				int multiple = (int) ch - 't';
				multiple += 1;
				for(int j = 0; j < multiple; j++) {
					code.append(Integer.toString(number));
				}
			}
			else {
				int number = 9;
				int multiple = (int) ch - 'w';
				multiple += 1;
				for(int j = 0; j < multiple; j++) {
					code.append(Integer.toString(number));
				}
			}
			codeBook.put(ch, code.toString());
		}
		return true;

	}
}
