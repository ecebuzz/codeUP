
public class SequenceBuilder {
//	public StringBuilder strBuilder;
//	public int size;
	public int cur;
//	public int next;
	public int[] count;
	public int level;

	public SequenceBuilder( String seq ) {
//		strBuilder = new StringBuilder();
		cur = 0;
//		next = 1;
//		size = 1;
		count = new int[seq.length()];
		level = 0;
	}
	
	public SequenceBuilder( int length ) {
		cur = 0;
//		next = 1;
//		size = 1;
		count = new int[length];
	}
	
	
	public SequenceBuilder clone() {
		SequenceBuilder newObj = new SequenceBuilder( count.length );
		newObj.count = this.count.clone();
//		newObj.size = this.size;
		newObj.cur = this.cur;
//		newObj.next = this.next;
		
		return newObj;
	}

//	public int size() {
//		return strBuilder.size();
//	}
}
