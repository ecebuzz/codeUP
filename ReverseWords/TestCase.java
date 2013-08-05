import java.util.LinkedList;
//import java.util.StringBuilder;

public class TestCase {
	public LinkedList<String> words = new LinkedList<String>();
	public TestCase(String line) {
		//Reverse the words using LinkedList
		if(line == null) {
			return;
		}
		String[] word = line.split(" ");
		for(int i = 0; i < word.length; i++ ) {
			words.addFirst(word[i]);
		}
	}
	public String printString() {
		if(words.size() == 0) {
			return null;
		}
		StringBuilder str = new StringBuilder();
		for(String element : words) {
			str.append(element);
			str.append(" ");
		}
		return str.toString().trim();
	}
//	public void printList() {
//		//Print the reverse words
//	}
	
}
