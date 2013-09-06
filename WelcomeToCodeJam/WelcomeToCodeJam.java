
public class WelcomeToCodeJam {
	public static void main( String[] args ) {
		String inputStr = "wweellccoommee to code qps jam";
		
		SequenceFinder instance = new SequenceFinder( inputStr );
		instance.scanSequence();
		System.out.printf( "%d", instance.getCount() );


	}
}
