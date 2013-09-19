import java.math.BigInteger;
import java.util.ArrayList;

public class SequenceNode {
	public char value;
	public BigInteger count;
	public int level;
	public ArrayList<SequenceNode> child;
	public boolean visited;
	public int timeStep;
	
	public SequenceNode( char value, int level, int timeStep ) {
		this.value = value;
		this.count = BigInteger.valueOf(1);
		this.level = level;
		this.child = null;
		this.visited = false;
		this.timeStep = timeStep;
	}
}
