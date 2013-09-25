import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MatchMaking {
	public static void main( String[] args ) {
		//Testcase 0
//		String[] namesWomen = {"Constance", "Bertha", "Alice"};
//		String[] answersWomen = {"aaba", "baab", "aaaa"};
//		String[] namesMen = {"Chip", "Biff", "Abe"};
//		String[] answersMen = {"bbaa", "baaa", "aaab"};
//		String queryWoman = "Bertha";

		//Testcase 1 
//		String[] namesWomen ={"Constance", "Bertha", "Alice"};
//	String[] answersWomen = 	{"aaba", "baab", "aaaa"};
//	String[] namesMen = 	{"Chip", "Biff", "Abe"};
//	String[] answersMen = 	{"bbaa", "baaa", "aaab"};
//	String queryWoman = 	"Constance";

//		//Testcase 2 
//	String[] namesWomen =	{"Constance", "Alice", "Bertha", "Delilah", "Emily"};
//	String[] answersWomen = 	{"baabaa", "ababab", "aaabbb", "bababa", "baabba"};
//	String[] namesMen = 	{"Ed", "Duff", "Chip", "Abe", "Biff"};
//	String[] answersMen = 	{"aabaab", "babbab", "bbbaaa", "abbbba", "abaaba"};
//	String queryWoman = 	"Constance";
//
//		//Testcase 3 
//	String[] namesWomen =	{"Constance", "Alice", "Bertha", "Delilah", "Emily"};
//	String[] answersWomen = 	{"baabaa", "ababab", "aaabbb", "bababa", "baabba"};
//	String[] namesMen = 	{"Ed", "Duff", "Chip", "Abe", "Biff"};
//	String[] answersMen = 	{"aabaab", "babbab", "bbbaaa", "abbbba", "abaaba"};
//	String queryWoman = 	"Delilah";
//
//		//Testcase 4 
//	String[] namesWomen =	{"Constance", "Alice", "Bertha", "Delilah", "Emily"};
//	String[] answersWomen = 	{"baabaa", "ababab", "aaabbb", "bababa", "baabba"};
//	String[] namesMen = 	{"Ed", "Duff", "Chip", "Abe", "Biff"};
//	String[] answersMen = 	{"aabaab", "babbab", "bbbaaa", "abbbba", "abaaba"};
//	String queryWoman = 	"Emily";
//
//		//Testcase 5 
//	String[] namesWomen =	{"anne", "Zoe"};
//	String[] answersWomen = 	{"a", "a"};
//	String[] namesMen = 	{"bob", "chuck"};
//	String[] answersMen = 	{"a", "a"};
//	String queryWoman = 	"Zoe";
//
//		//Testcase 6 
//	String[] namesWomen =	{"F", "M", "S", "h", "q", "g", "r", "N", "U", "x", "H", "P",
//			 "o", "E", "R", "z", "L", "m", "e", "u", "K", "A", "w", "Q",
//			  "O", "v", "j", "a", "t", "p", "C", "G", "k", "c", "V", "B",
//			   "D", "s", "n", "i", "f", "T", "I", "l", "d", "J", "y", "b"};
//	String[] answersWomen = 	{"abaabbbb", "bbaabbbb", "aaabaaab", "aabbaaaa", "baabbaab",
//			 "aaababba", "bbabbbbb", "bbbabbba", "aaabbbba", "aabbbaaa",
//			  "abbabaaa", "babbabbb", "aaaaabba", "aaaabbaa", "abbbabaa",
//			   "babababa", "abbaaaaa", "bbababba", "baaaaaba", "baaaaabb",
//			    "bbbbabba", "ababbaaa", "abbbabab", "baabbbaa", "bbbaabbb",
//			     "aababbab", "ababbabb", "abbaabba", "baabbabb", "aaabaaab",
//			      "aabbbaba", "aabaaabb", "abababba", "aabbaaaa", "aabbabaa",
//			       "bababaaa", "aabaaaab", "bbbbaabb", "baaababb", "abaabbab",
//			        "aabbbaaa", "baabbaba", "bbabbbaa", "aabbbbaa", "abbbaaab",
//				 "abababbb", "ababaaba", "bababaaa"};
//	String[] namesMen = 	{"f", "C", "v", "g", "Q", "z", "n", "c", "B", "o", "M", "F",
//			 "u", "x", "I", "T", "K", "L", "E", "U", "w", "A", "d", "t",
//			  "e", "R", "D", "s", "p", "q", "m", "r", "H", "j", "J", "V",
//			   "l", "a", "k", "h", "G", "y", "i", "P", "O", "N", "b", "S"};
//	String[] answersMen = 	{"bbbaabab", "bbabaabb", "ababbbbb", "bbbababb", "baababaa",
//			 "bbaaabab", "abbabbaa", "bbbabbbb", "aabbabab", "abbababa",
//			  "aababbbb", "bababaab", "aaababbb", "baabbaba", "abaaaaab",
//			   "bbaababa", "babaabab", "abbabbba", "ababbbab", "baabbbab",
//			    "babbaaab", "abbbbaba", "bbabbbba", "baaabaab", "ababbabb",
//			     "abbbaabb", "bbbbaabb", "bbbaaabb", "baabbaba", "bbabaaab",
//			      "aabbbaab", "abbbbabb", "bbaaaaba", "bbbababa", "abbaabba",
//			       "bababbbb", "aabaaabb", "babbabab", "baaaabaa", "ababbaba",
//			        "aaabaabb", "bbaaabaa", "baaaaabb", "bbaabaab", "bbababab",
//				 "aabaaaab", "aaaaabab", "aabbaaba"};
//	String queryWoman = 	"U";
//
//		//Testcase 7 
	String[] namesWomen =	{"q", "M", "w", "y", "p", "N", "s", "r", "a", "H", "o", "n",
			 "F", "m", "l", "b", "D", "j", "C", "u", "f", "I", "g", "L",
			  "i", "x", "A", "G", "O", "k", "h", "d", "c", "E", "B", "v",
			   "J", "z", "K", "e", "t"};
	String[] answersWomen = 	{"aabbaaabb", "baabababb", "bbaababba", "bbbaaaaaa", "abaaaabaa",
			 "bababbbab", "abbaabbaa", "aabababbb", "bababaaaa", "abbababaa",
			  "aabbbbbba", "bbabbabab", "babaabbba", "babbabbbb", "baaabbbbb",
			   "baaabaaaa", "aaabbaaab", "abbaabbbb", "abbabbbab", "bbaaaabba",
			    "babbaaabb", "aabbabbab", "baaababba", "ababaabab", "bbbaabbab",
			     "aaaabbabb", "babaaaaaa", "abbbbaaab", "aabaaabba", "bbbaaaaba",
			      "bbbbbbaab", "aabbaaabb", "aabaabbab", "aababaaba", "bbabbbbab",
			       "abbabaaab", "babaaabbb", "bababbaaa", "aabbaabaa", "baaabbabb",
			        "bbbbbbbbb"};
	String[] namesMen = 	{"m", "k", "n", "q", "L", "E", "M", "l", "w", "x", "g", "e",
			 "i", "z", "F", "r", "a", "h", "f", "D", "J", "K", "j", "v",
			  "A", "t", "N", "y", "s", "c", "o", "p", "d", "b", "B", "G",
			   "O", "I", "u", "C", "H"};
	String[] answersMen = 	{"bbaaabbba", "bbaaaaaab", "abaaababb", "baaaabbbb", "abbbababa",
			 "baaaaaaaa", "aabbbbbab", "aaaaabbba", "baabababb", "babaaabab",
			  "baaababaa", "bbbbaabba", "bbaabbabb", "bbaaababb", "abbabbaba",
			   "aababaaab", "abbbbbbaa", "aabbaabaa", "bbbaabbba", "abbabbaba",
			    "aaabbbaaa", "bbaabaaaa", "aabababbb", "abbbbabab", "baaabbbba",
			     "bababbbba", "aababbaab", "bbaabbaab", "bbbaaabbb", "babbbbabb",
			      "ababababb", "babaaabab", "bbaaaaaba", "aaaaabaaa", "abbaaabbb",
			       "bbbbababb", "baabababb", "bbaabaaaa", "aaababbbb", "abbbbbbba",
			        "bbaabbaaa"};
	String queryWoman = 	"o";

		System.out.println( makeMatch( namesWomen, answersWomen, namesMen, answersMen, queryWoman ) );
	}

	public static String makeMatch( String[] namesWomen, String[] answersWomen,
			String[] namesMen, String[] answersMen, String queryWoman ) {
		//TODO Exception handle
		
		if( namesWomen.length == 1 ) { return namesMen[0]; }

		String[] sortedNamesWomen = namesWomen.clone();
		Arrays.sort( sortedNamesWomen );
		HashMap<String, Integer> mapWomen = new HashMap<String, Integer>();

		for( int i = 0; i < namesWomen.length; i++ ) {
			mapWomen.put( namesWomen[i], i );
		}

		// Build a men list of left men for date
		ArrayList<String> menList = new ArrayList<String>();
		HashMap<String, Integer> mapMen = new HashMap<String, Integer>();
		for( int i = 0; i < namesMen.length; i++  ) {
			String name = namesMen[i];
			mapMen.put( name, i );
			menList.add( name );
		}
		Collections.sort( menList );

		for( int i = 0; i < sortedNamesWomen.length; i++ ) {
			String name = sortedNamesWomen[i];
			if( name.equals( queryWoman ) ) {
				break;
			}

			String selectedMan = matchMan( answersWomen[ mapWomen.get( name ) ], 
					answersMen, mapMen, menList );
			menList.remove( selectedMan );
		}


		return matchMan( answersWomen[ mapWomen.get( queryWoman ) ], 
				answersMen, mapMen, menList );


	}

	public static String matchMan( String answer, String[] answersMen,
		       	HashMap<String, Integer> mapMen, ArrayList<String> menList ) {
		if( menList.size() == 1 ) { return menList.get(0); }

		int score = 0;
		String selectedMan = "";
		for( int i = 0; i < menList.size(); i++ ) {
			String name = menList.get(i);
			int tmpScore = computeScore( answer, answersMen[ mapMen.get( name ) ] );
			if( tmpScore > score ) {
				score = tmpScore;
				selectedMan = name;
			}
		}
		return selectedMan;
	}

	public static int computeScore( String ans1, String ans2 ) {
		int score = 0;
		for( int i = 0; i < ans1.length(); i++ ) {
			if( ans1.charAt(i) == ans2.charAt(i) ) {
				score ++;
			}
		}

		return score;
	}



}
