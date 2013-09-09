import java.util.ArrayList;

public class SequenceNode {
	public char value;
	public int count;
	public int level;
	public ArrayList<SequenceNode> child;
	
	public SequenceNode( char value, int level ) {
		this.value = value;
		this.count = 1;
		this.level = level;
		this.child = null;
	}
}
