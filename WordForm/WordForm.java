import java.util.HashSet;

public class WordForm {
	public static void main(String[] args) {
//		//Testcase 0
//		String word = "WHEREABOUTS";
//		//Testcase 1
//		String word = "yoghurt";
//		//Testcase 2
//		String word = "YipPy";
//		//Testcase 3
//		String word = "AyYyEYye";
		//Testcase 4
		String word = "yC";
		System.out.println(getSequence(word));
	}

	public static String getSequence(String word) {
		//TODO Exception handle
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};
		HashSet<Character> vowelSet = new HashSet<Character>();

		for(char vowel : vowels) {
			vowelSet.add(vowel);
		}

		StringBuilder sequence = new StringBuilder();
		String lowercaseWord = word.toLowerCase();
		char prev = ' ';
		for(int i = 0; i < word.length(); i++) {
			char cur = 'C';
			if(vowelSet.contains(lowercaseWord.charAt(i))) {
				cur = 'V';
			}
			else if(i != 0) {
				if(lowercaseWord.charAt(i) == 'y' && !vowelSet.contains(lowercaseWord.charAt(i - 1)) && prev != 'V') {
					cur = 'V';
				}
			}
			if(cur != prev) {
				sequence.append(Character.toString(cur));
				prev = cur;
			}
		}	
		return sequence.toString();
	}

}
