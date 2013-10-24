import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Test;


public class UnitTest {
	@Test
	public void test() throws Exception {
		String path = "RacerRater_testcases/";
		String index = "002";
		String inputFileName = "input" + index + ".txt";
		String outputFileName = "output" + index + ".txt";
		File inputFile = new File(path + inputFileName);
		File outputFile = new File(path + outputFileName);
		Scanner in = new Scanner(inputFile);
		Scanner out = new Scanner(outputFile);	
		// Read input and output from files
		in.useDelimiter("\\Z");
		String input = in.next();
		out.useDelimiter("\\Z");
		String output = out.next();
		in.close();
		out.close();
		ByteArrayInputStream inStream = new ByteArrayInputStream(input.getBytes());
		// set stdin
		System.setIn(inStream);
		
		// set stdout
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(outStream);
		System.setOut(ps);
		// Execute test function
		main(null);
		// get result from stdI/O
		String stdOutput = outStream.toString();
		
		Assert.assertEquals(output + "\n", stdOutput);
	}
	// TODO
	// Test functions
}
