
public class SequenceBuilder {
//	public StringBuilder strBuilder;
	public int size;
	public int cur;
	public int next;
	public int[] count;

	public SequenceBuilder( String seq ) {
//		strBuilder = new StringBuilder();
		cur = 0;
		next = 1;
		size = 1;
		count = new int[seq.length()];
	}

//	public int size() {
//		return strBuilder.size();
//	}
}
