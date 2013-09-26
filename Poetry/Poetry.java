import java.util.HashSet;
import java.util.HashMap;

public class Poetry {
	public static void main(String[] args) {
//		//Testcase 0
//		String[] poem = {"I hope this problem",
//			 "is a whole lot better than",
//			  "this stupid haiku"};
////		//Testcase 1
//		String[] poem = {"     ",
//				 "Measure your height",
//				 "AND WEIGHT      ",
//				 "said the doctor",
//				 "",
//				 "And make sure to take your pills",
//				 "   to   cure   your    ills",
//				 "Every",
//				 "DAY"};
////		//Testcase 2
//		String[] poem = {"One bright day in the middle of the night",
//				 "Two dead boys got up to fight",
//				 "Back to back they faced each other",
//				 "Drew their swords and shot each other",
//				 "",
//				 "A deaf policeman heard the noise",
//				 "And came to arrest the two dead boys",
//				 "And if you dont believe this lie is true",
//				 "Ask the blind man he saw it too"};
////		//Testcase 3
//		String[] poem = {"",
//				 "",
//				 "",
//				 ""};
//		//Testcase 4
//		String[] poem = {"This poem has uppercase letters",
//				 "In its rhyme scheme",
//				 "Alpha", "Blaster", "Cat", "Desert", "Elephant", "Frog", "Gulch", 
//				 "Horse", "Ireland", "Jam", "Krispy Kreme", "Loofah", "Moo", "Narf",
//				 "Old", "Pink", "Quash", "Rainbow", "Star", "Tour", "Uvula", "Very",
//				 "Will", "Xmas", "Young", "Zed", "deception", "comic", "grout",
//				 "oval", "cable", "rob", "steal", "steel", "weak"};
////		//Testcase 5
//		String[] poem = {" ",
//			 "     ",
//			 "This poem",
//			 "         ",
//			 " ",
//			 " ",
//			 "",
//			 "Has lots of blank lines",
//			 " ",
//			 "      ",
//			 "                                            ",
//			 "         ",
//			 " ",
//			 "              ",
//			 "                                                  ",
//			 "  in      it           "};
//		//Testcase 6
		String[] poem = {"too bad   your",
		 "     solution went   sour"};
		String rhyme = rhymeScheme(poem);
		System.out.println(rhyme.length());
		System.out.println(rhyme);
	}

	public static String rhymeScheme(String[] poem) {
		if(poem == null) {
			//TODO Exception Handle
		}

		if(poem.length == 0) {
			//TODO Exception Handle
		}

		String prevSubstr = " ";
		char letter = 'a';
		StringBuilder rhyme = new StringBuilder();
		boolean flag = false;
		HashMap<String,String> map = new HashMap<String,String>();

		for(String line : poem) {
			String[] splitLine = line.trim().split(" ");
			String append = " ";
			if(!(splitLine.length == 0) && !splitLine[0].isEmpty()) {
				String newSubstr = getValidSubstr(splitLine[splitLine.length - 1]);
				if(!newSubstr.equals(prevSubstr) && flag && !map.containsKey(newSubstr)) {

					if(letter == 'z') {
						letter = 'A';
					}
					else {
						letter ++;
					}
					
				}
				if( map.containsKey(newSubstr)) {
					append = map.get(newSubstr);
				}
				else {
					append = Character.toString(letter);
					map.put(newSubstr, append);
				}
				
				prevSubstr = newSubstr;
			}
			else {
				prevSubstr = " ";
			}
			if(append.equals("a")) {
				flag = true;
			}
			rhyme.append(append);
		}

		return rhyme.toString();
	}

	public static String getValidSubstr(String str) {
		if(str == null) {
			//TODO Exception Handle
		}
		char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
		HashSet<Character> set = new HashSet<Character>();
		
		for(char vowel : vowels) {
			set.add(vowel);
		}

		String lowercaseStr = str.toLowerCase();
		String validSubstr = "";
		for(int i = 0; i < str.length(); i++) {
			if(set.contains(lowercaseStr.charAt(i))) {
				if(lowercaseStr.charAt(i) == 'y' && i == 0) {
					continue;
				}
				if(i == str.length() - 1) {
					validSubstr = lowercaseStr.substring(i);
					break;
				}
				else {
					if(!set.contains(lowercaseStr.charAt(i + 1)) || (lowercaseStr.charAt(i + 1) == 'y' && (i+1) != str.length() - 1)) {
						// No stop after hit valid substring until it's the last one
						validSubstr = lowercaseStr.substring(i);
					}
				}
			}
		}	

		return validSubstr;
	}
}
