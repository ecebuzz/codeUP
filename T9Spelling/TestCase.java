import java.util.Hashtable;

public class TestCase {
	private String message;
	private String press_message;

	public TestCase(String str) {
		message = str.toLowerCase();
	}

	public String printString() {
		return press_message;
	}
	
	public void encode(Hashtable<Character, String> codeBook) {
		/* Encode message from characters to press numbers
		 * @Params
		 * Hashtable<Character, String> codeBook
		 */
		if(codeBook == null) {
			System.out.println("Hash table codeBook is null!");
			return;
		}
		if(message.length() == 0) {
			System.out.println("The message to encode is empty!");
			return;
		}
		StringBuilder encoded_message = new StringBuilder();
		char prev_code = '0';
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) == ' ') {
				char code = '0';
				if(prev_code == code) {
					encoded_message.append(" ");
				}
				encoded_message.append("0");
				prev_code = code;
				continue;
			}
			if(message.charAt(i) >= 'a' && message.charAt(i) <= 'z') {
				char code = codeBook.get(message.charAt(i)).charAt(0);
//				int code = (int) (message.charAt(i) - 'a') / 3 + 1;
				if(prev_code == code) {
					encoded_message.append(" ");
				}
				encoded_message.append(codeBook.get(message.charAt(i)));
				prev_code = code;
				
			}
			else {
				System.out.println("The message contains characters other than a-z and space!");
				return;
			}
		}
		press_message = encoded_message.toString();
		return;
	}

}
