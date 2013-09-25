
public class PosPair implements Comparable {
	private int leftPos;
	private int rightPos;
	public PosPair( int leftPos, int rightPos ) {
		this.leftPos = leftPos;
		this.rightPos = rightPos;
	}
	
	public int getLeftPos() {
		return this.leftPos;
	}
	
	public int getRightPos() {
		return this.rightPos;
	}
	
	public int compareTo( Object obj ) {
		if( obj == null ) {
			//TODO Exception handle
		}
		
		if( obj.getClass() != this.getClass() ) {
			//TODO  Exception handle
		}
		
		PosPair other = (PosPair) obj;
		if( this.leftPos < other.leftPos ) {
			return -1;
		}
		if( this.leftPos > other.leftPos ) {
			return 1;
		}
		return 0;
	}
}
