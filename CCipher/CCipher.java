
public class CCipher {
	public static void main(String[] args) {
//		//Testcase 0
//		String cipherText = "VQREQFGT";
//		int shift = 2;
//		//Testcase 1
//		String cipherText = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		int shift = 10;
//		//Testcase 2
//		String cipherText = "TOPCODER";
//		int shift = 0;
//		//Testcase 3
//		String cipherText = "ZWBGLZ";
//		int shift = 25;
//		//Testcase 4
//		String cipherText = "DBNPCBQ";
//		int shift = 1;
		//Testcase 5
		String cipherText = "LIPPSASVPH";
		int shift = 4;
		System.out.println(decode(cipherText, shift));
	}

	public static String decode(String cipherText, int shift) {
		//Exception Handle TODO
		StringBuilder decodedStr = new StringBuilder();
		for(int i = 0; i < cipherText.length(); i++) {
			char character = cipherText.charAt(i);
			char decodedChar = character;
			if(character - shift < 'A') {
				decodedChar = (char) (character + 26 - shift);	
			}
			else {
				decodedChar = (char) (character - shift);
			}
			decodedStr.append(Character.toString(decodedChar));
		}
		return decodedStr.toString();
	}
}
