import java.util.ArrayList;
import java.util.Collections;

public class UserName {

	public static void main( String[] args ) {
		//Testcase 1
//		String[] existingNames = {"MasterOfDisaster", "DingBat", "Orpheus", "WolfMan", "MrKnowItAll"};
//		String newName = "TygerTyger";
		//Testcase 2
//		String[] existingNames = {"MasterOfDisaster", "TygerTyger1", "DingBat", "Orpheus", 
//			 "TygerTyger", "WolfMan", "MrKnowItAll"};
//		String newName = "TygerTyger";
		//Testcase 3
//		String[] existingNames = {"TygerTyger2000", "TygerTyger1", "MasterDisaster", "DingBat", 
//				 "Orpheus", "WolfMan", "MrKnowItAll"};
//		String newName = "TygerTyger";
		//Testcase 4
//		String[] existingNames = {"grokster2", "BrownEyedBoy", "Yoop", "BlueEyedGirl", 
//				 "grokster", "Elemental", "NightShade", "Grokster1"};
//		String newName = "grokster";
		//Testcase 5
		String[] existingNames = {"Bart4", "Bart5", "Bart6", "Bart7", "Bart8", "Bart9", "Bart10",
				 "Lisa", "Marge", "Homer", "Bart", "Bart1", "Bart2", "Bart3",
				 "Bart11", "Bart12"};
		String newName = "Bart";
		
		System.out.println( newMember( existingNames, newName ) );

	}

	public static String newMember( String[] existingNames, String newName ) {
	if( existingNames == null || newName == null ) {
			//TODO Exception handle
		}

		// No conflict name
		if( existingNames.length == 0 ) { return newName; }

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		boolean toNumber = false;
		for( String name : existingNames ) {
			if( name.length() >= newName.length() ) {
				
				String subStr = name.substring( 0, newName.length() );

				if( subStr.equals( newName )  ) {
					String num = name.substring( newName.length() );
					if( num.isEmpty() ) {
						numbers.add( 0 );
					}
					else {
						int intNum = Integer.parseInt( num );
						numbers.add( intNum );						
					}

				}
			}
			
		}
		
		Collections.sort( numbers );
		if( numbers.isEmpty() ) {
			return newName;
		}
		
		if( numbers.get(0) != 0 ) {
			return newName;
		}
		
		int ind = 0;

		for( int num : numbers ) {
			if( ind == num ) {
				ind++;
			}
			else {
				break;
			}
		}
		

		String returnName = newName;
	
		returnName += Integer.toString( ind );

		return returnName;

	}
}
